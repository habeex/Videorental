package com.example.videorental.controller;

import com.example.videorental.dto.ServerResponse;
import com.example.videorental.dto.UserDto;
import com.example.videorental.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/user", produces = "application/json")
@Api(tags = "User Management", value = "Endpoint")
public class UserController {

    @Autowired
    UserService userService;
    private HttpHeaders responseHeaders = new HttpHeaders();

    @ApiOperation(value = "create user account. Note: gender is either Male or Female", response = ServerResponse.class)
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody UserDto request){
        ServerResponse response = new ServerResponse();
        try {
            response = userService.create(request);
        } catch (Exception e) {
            response = ServerResponse.exceptionMessage(e);
        }
        return new ResponseEntity<ServerResponse>(response, responseHeaders, ServerResponse.getStatus(response.getStatus()));
    }

    @ApiOperation(value = "Search for user by name", response = ServerResponse.class)
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getVideos(@RequestParam("name") String name, @RequestParam("page") int page, @RequestParam("limit") int limit){
        ServerResponse response = new ServerResponse();
        try {
            response = userService.searchForUser(name, limit, page);
        } catch (Exception e) {
            response = ServerResponse.exceptionMessage(e);
        }
        return new ResponseEntity<ServerResponse>(response, responseHeaders, ServerResponse.getStatus(response.getStatus()));
    }

    @ApiOperation(value = "Get user by id ", response = ServerResponse.class)
    @RequestMapping(value = "/{email}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getUserByEmail(@PathVariable("email") String email){
        ServerResponse response = new ServerResponse();
        try {
            response = userService.getUserByEmail(email);
        } catch (Exception e) {
            response = ServerResponse.exceptionMessage(e);
        }
        return new ResponseEntity<ServerResponse>(response, responseHeaders, ServerResponse.getStatus(response.getStatus()));
    }
}
