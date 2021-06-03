package com.example.videorental.controller;

import com.example.videorental.dto.ServerResponse;
import com.example.videorental.dto.VideoDto;
import com.example.videorental.enumType.VideoGenre;
import com.example.videorental.enumType.VideoType;
import com.example.videorental.service.PriceService;
import com.example.videorental.service.UserService;
import com.example.videorental.service.VideoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/price", produces = "application/json")
@Api(tags = "Price Management", value = "Endpoint")
public class PriceController {

    @Autowired
    PriceService priceService;
    private HttpHeaders responseHeaders = new HttpHeaders();

    @ApiOperation(value = "Get all videos", response = ServerResponse.class)
    @RequestMapping(value = "user/{userId}/video/{videoId}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> calculatePrice(@PathVariable("userId") long userId, @PathVariable("videoId") long videoId, @RequestParam("rentDays") int rentDays){
        ServerResponse response = new ServerResponse();
        try {
            response = priceService.calculatePrice(userId, videoId, rentDays);
        } catch (Exception e) {
            response = ServerResponse.exceptionMessage(e);
        }
        return new ResponseEntity<ServerResponse>(response, responseHeaders, ServerResponse.getStatus(response.getStatus()));
    }
}
