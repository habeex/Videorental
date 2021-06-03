package com.example.videorental.impl;

import com.example.videorental.dto.ServerResponse;
import com.example.videorental.dto.ServerResponsePage;
import com.example.videorental.dto.UserDto;
import com.example.videorental.model.User;
import com.example.videorental.repository.UserRepository;
import com.example.videorental.service.UserService;
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
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;


    @Override
    public ServerResponse create(UserDto request) {
        try{
            if (!Utility.isValidInput(request.getName())) {
                return ServerResponse.badRequest("Please user name");
            }
            if (!Utility.isValidEmail(request.getEmail())) {
                return ServerResponse.badRequest("Please valid email address");
            }
            if (!Utility.isValidInput(request.getGender())) {
                return ServerResponse.badRequest("Please user gender");
            }
            if (!Utility.isValidInput(request.getAge())) {
                return ServerResponse.badRequest("Please user age");
            }
            User user = userRepository.findByEmail(request.getEmail());
            if(user != null) return ServerResponse.badRequest("User already exists");

            user = new User();
            user.setEmail(request.getEmail());
            user.setName(request.getEmail());
            user.setAge(request.getAge());
            user.setGender(request.getGender());
            userRepository.save(user);
            return  ServerResponse.successResponse("User Created", user);
        }catch (Exception e){
            return  ServerResponse.exceptionMessage(e);
        }
    }

    @Override
    public ServerResponse getUserByEmail(String email) {
        try{
            User user = userRepository.findByEmail(email);
            if(user == null) return ServerResponse.badRequest("User not exists");
            return  ServerResponse.successResponse("User Created", user);
        }catch (Exception e){
            return  ServerResponse.exceptionMessage(e);
        }
    }

    @Override
    public ServerResponse searchForUser(String query, int limit, int page) {
        PageRequest pageable = PageRequest.of(page - 1, limit, Sort.by(Sort.Direction.DESC, "createdDate"));
        Page<User> users = userRepository.findAll(
                Specification.where(new SearchSpecification<User>().like("name", query)),
                pageable
        );
        return ServerResponsePage.successResponse("Success", users.getContent(), users.getTotalPages(), page, users.getTotalElements());
    }
}
