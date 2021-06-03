package com.example.videorental.controller;

import com.example.videorental.dto.ServerResponse;
import com.example.videorental.dto.VideoDto;
import com.example.videorental.enumType.VideoGenre;
import com.example.videorental.enumType.VideoType;
import com.example.videorental.service.VideoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/video", produces = "application/json")
@Api(tags = "Video Management", value = "Endpoint")
public class VideoController {

    @Autowired
    VideoService videoService;
    private HttpHeaders responseHeaders = new HttpHeaders();

    @ApiOperation(value = "Add video Note:  Video Type and type Video Genre are enum value as follow type:{ Regular, Children, NewRelease} genre:{Action, Drama, Romance, Comedy, Horror}", response = ServerResponse.class)
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> addVideo(@RequestBody VideoDto request){
        ServerResponse response = new ServerResponse();
        try {
            response = videoService.addVideo(request);
        } catch (Exception e) {
            response = ServerResponse.exceptionMessage(e);
        }
        return new ResponseEntity<ServerResponse>(response, responseHeaders, ServerResponse.getStatus(response.getStatus()));
    }

    @ApiOperation(value = "update video Note: Video Type and type Video Genre are enum value as follow type:{Regular, Children, NewRelease} genre:{Action, Drama, Romance, Comedy, Horror}", response = ServerResponse.class)
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<?> updateVideo(@PathVariable("id") long id, @RequestBody VideoDto request){
        ServerResponse response = new ServerResponse();
        try {
            response = videoService.updateVideo(id, request);
        } catch (Exception e) {
            response = ServerResponse.exceptionMessage(e);
        }
        return new ResponseEntity<ServerResponse>(response, responseHeaders, ServerResponse.getStatus(response.getStatus()));
    }

    @ApiOperation(value = "Get video by video genre ", response = ServerResponse.class)
    @RequestMapping(value = "/genre", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getVideoByGenre(@RequestParam("genre") VideoGenre genre, @RequestParam("page") int page, @RequestParam("limit") int limit){
        ServerResponse response = new ServerResponse();
        try {
            response = videoService.getVideoByGenre(genre, limit, page);
        } catch (Exception e) {
            response = ServerResponse.exceptionMessage(e);
        }
        return new ResponseEntity<ServerResponse>(response, responseHeaders, ServerResponse.getStatus(response.getStatus()));
    }

    @ApiOperation(value = "Get video by video type ", response = ServerResponse.class)
    @RequestMapping(value = "/type", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getVideoByType(@RequestParam("type") VideoType type, @RequestParam("page") int page, @RequestParam("limit") int limit){
        ServerResponse response = new ServerResponse();
        try {
            response = videoService.getVideoByType(type, limit, page);
        } catch (Exception e) {
            response = ServerResponse.exceptionMessage(e);
        }
        return new ResponseEntity<ServerResponse>(response, responseHeaders, ServerResponse.getStatus(response.getStatus()));
    }

    @ApiOperation(value = "Get all videos", response = ServerResponse.class)
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getVideos(@RequestParam("page") int page, @RequestParam("limit") int limit){
        ServerResponse response = new ServerResponse();
        try {
            response = videoService.getVideos(limit, page);
        } catch (Exception e) {
            response = ServerResponse.exceptionMessage(e);
        }
        return new ResponseEntity<ServerResponse>(response, responseHeaders, ServerResponse.getStatus(response.getStatus()));
    }

    @ApiOperation(value = "Get video by id ", response = ServerResponse.class)
    @RequestMapping(value = "/id", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getVideos(@RequestParam("id") long id){
        ServerResponse response = new ServerResponse();
        try {
            response = videoService.getVideoById(id);
        } catch (Exception e) {
            response = ServerResponse.exceptionMessage(e);
        }
        return new ResponseEntity<ServerResponse>(response, responseHeaders, ServerResponse.getStatus(response.getStatus()));
    }
}
