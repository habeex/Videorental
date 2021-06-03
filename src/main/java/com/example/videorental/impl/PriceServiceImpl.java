package com.example.videorental.impl;

import com.example.videorental.dto.PriceDto;
import com.example.videorental.dto.ServerResponse;
import com.example.videorental.model.User;
import com.example.videorental.model.Video;
import com.example.videorental.repository.UserRepository;
import com.example.videorental.repository.VideoRepository;
import com.example.videorental.service.PriceService;
import com.example.videorental.utilities.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PriceServiceImpl implements PriceService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    VideoRepository videoRepository;

    @Override
    public ServerResponse calculatePrice(long userId, long videoId, int rentDays) {
        try{
            User user = userRepository.findById(userId);
            if(user == null) return ServerResponse.badRequest("User not exists");
            Video video = videoRepository.findById(videoId);
            if(video == null) return ServerResponse.badRequest("Video not find");

            if (!Utility.isValidInput(rentDays)) rentDays = 7;
            PriceDto price = new PriceDto();
            price.setName(user.getName());
            price.setVideoTitle(video.getTitle());
            price.setRentDays(rentDays);

            switch (video.getType()){
                case Regular:
                    price.setPrice(video.getRate() * rentDays);
                    break;
                case Children:
                    price.setPrice(video.getRate() * rentDays + (user.getAge() / 2));
                    break;
                case NewRelease:
                    price.setPrice(video.getRate() * rentDays - video.getReleasedYear());
                    break;
            }

            return ServerResponse.successResponse("Calculated price", price);
        }catch (Exception e){
            return ServerResponse.exceptionMessage(e);
        }
    }
}
