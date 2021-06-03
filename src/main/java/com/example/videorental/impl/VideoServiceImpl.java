package com.example.videorental.impl;

import com.example.videorental.dto.ServerResponse;
import com.example.videorental.dto.ServerResponsePage;
import com.example.videorental.dto.VideoDto;
import com.example.videorental.enumType.VideoGenre;
import com.example.videorental.enumType.VideoType;
import com.example.videorental.model.Video;
import com.example.videorental.repository.VideoRepository;
import com.example.videorental.service.VideoService;
import com.example.videorental.utilities.SearchSpecification;
import com.example.videorental.utilities.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class VideoServiceImpl implements VideoService {

    @Autowired
    VideoRepository videoRepository;

    @Override
    public ServerResponse addVideo(VideoDto request) {
        try{
            if (!Utility.isValidInput(request.getTitle())) {
                return ServerResponse.badRequest("Please provide video title");
            }
            if (!Utility.isValidInput(request.getDescription())) {
                return ServerResponse.badRequest("Please provide video description");
            }
            if (!Utility.isValidInput(request.getRate())) {
                return ServerResponse.badRequest("Please provide price of the video");
            }
            if (!Utility.isValidInput(request.getGenre())) {
                return ServerResponse.badRequest("Please provide video genre");
            }
            if (!Utility.isValidInput(request.getType())) {
                return ServerResponse.badRequest("Please provide video type");
            }
            if (!Utility.isValidInput(request.getReleasedYear())) {
                return ServerResponse.badRequest("Please provide video year of released");
            }
            if (request.getType() == VideoType.Children && !Utility.isValidInput(request.getAge())) {
                return ServerResponse.badRequest("Please provide video maximum age");
            }
            Video video = new Video();
            video.setTitle(request.getTitle());
            video.setDescription(request.getDescription());
            video.setGenre(request.getGenre());
            video.setType(request.getType());
            video.setReleasedYear(request.getReleasedYear());
            video.setAge(request.getAge());
            videoRepository.save(video);
            return ServerResponse.successResponse("Successfully created", video);
        }catch (Exception e){
            return ServerResponse.exceptionMessage(e);
        }
    }

    @Override
    public ServerResponse updateVideo(long id, VideoDto request) {
        try{
            Video video = videoRepository.findById(id);
            if(video == null){
                ServerResponse.badRequest("Video not find");
            }
            if (Utility.isValidInput(request.getTitle())) {
                video.setTitle(request.getTitle());
            }
            if (Utility.isValidInput(request.getDescription())) {
                video.setDescription(request.getDescription());
            }
            if (Utility.isValidInput(request.getRate())) {
                video.setRate(request.getRate());
            }
            if (Utility.isValidInput(request.getGenre())) {
                video.setGenre(request.getGenre());
            }
            if (Utility.isValidInput(request.getType())) {
                video.setType(request.getType());
            }
            if (Utility.isValidInput(request.getReleasedYear())) {
                video.setReleasedYear(request.getReleasedYear());
            }
            if (Utility.isValidInput(request.getAge())) {
                video.setAge(request.getAge());
            }

            return ServerResponse.successResponse("Successfully created", "Video updated");
        }catch (Exception e){
            return ServerResponse.exceptionMessage(e);
        }
    }

    @Override
    public ServerResponse deleteVideo(long id) {
        Video video = videoRepository.findById(id);
        if(video == null){
            ServerResponse.badRequest("Video not find");
        }
         videoRepository.deleteById(id);
        return ServerResponse.successResponse("Success", "Video deleted");
    }

    @Override
    public ServerResponse getVideoById(long id) {
       try{
           Video video = videoRepository.findById(id);
           if(video == null){
               ServerResponse.badRequest("Video not find");
           }
           return ServerResponse.successResponse("Success", video);
       }catch (Exception e){
           return ServerResponse.exceptionMessage(e);
       }
    }

    @Override
    public ServerResponse getVideos(int limit, int page) {
        PageRequest pageable = PageRequest.of(page - 1, limit, Sort.by(Sort.Direction.DESC, "createdDate"));
        Page<Video> videos = videoRepository.findAll(pageable);
        return ServerResponsePage.successResponse("Success", videos.getContent(), videos.getTotalPages(), page, videos.getTotalElements());
    }

    @Override
    public ServerResponse getVideoByType(VideoType type, int limit, int page) {
        PageRequest pageable = PageRequest.of(page - 1, limit, Sort.by(Sort.Direction.DESC, "createdDate"));
        Page<Video> videos = videoRepository.findAllByType(pageable, type);
        return ServerResponsePage.successResponse("Success", videos.getContent(), videos.getTotalPages(), page, videos.getTotalElements());
    }

    @Override
    public ServerResponse getVideoByGenre(VideoGenre genre, int limit, int page) {
        PageRequest pageable = PageRequest.of(page - 1, limit, Sort.by(Sort.Direction.DESC, "createdDate"));
        Page<Video> videos = videoRepository.findAllByGenre(pageable, genre);
        return ServerResponsePage.successResponse("Success", videos.getContent(), videos.getTotalPages(), page, videos.getTotalElements());
    }

    @Override
    public ServerResponse filterVideo(String query, VideoType type, VideoGenre genre, int limit, int page) {
        PageRequest pageable = PageRequest.of(page - 1, limit, Sort.by(Sort.Direction.DESC, "createdDate"));
        Page<Video> videos = videoRepository.findAll(
                Specification.where(new SearchSpecification<Video>().equal("title", query))
                .or(new SearchSpecification<Video>().equal("type", type))
                .or(new SearchSpecification<Video>().equal("genre", genre)),
                pageable
        );
        return ServerResponsePage.successResponse("Success", videos.getContent(), videos.getTotalPages(), page, videos.getTotalElements());
    }

    @Override
    public ServerResponse searchVideo(String query, int limit, int page) {
        PageRequest pageable = PageRequest.of(page - 1, limit, Sort.by(Sort.Direction.DESC, "createdDate"));
        Page<Video> videos = videoRepository.findAll(
                Specification.where(new SearchSpecification<Video>().equal("title", query)),
                pageable
        );
        return ServerResponsePage.successResponse("Success", videos.getContent(), videos.getTotalPages(), page, videos.getTotalElements());    }
}
