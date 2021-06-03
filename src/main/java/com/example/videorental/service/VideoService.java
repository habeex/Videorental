package com.example.videorental.service;

import com.example.videorental.dto.ServerResponse;
import com.example.videorental.dto.VideoDto;
import com.example.videorental.enumType.VideoGenre;
import com.example.videorental.enumType.VideoType;
import org.springframework.stereotype.Service;

/**
 * Interface for actions on {@code Video}.
 *
 * @author Olorunishola Habeeb
 */
@Service
public interface VideoService {
    /**
     * add new video based on given values.
     *
     * @param request  VideoDto
     * @return the ServerResponse
     */
    ServerResponse addVideo(VideoDto request);
    /**
     * update video info {@code id} based on given values.
     *
     * @param request  VideoDto
     * @return the ServerResponse
     */
    ServerResponse updateVideo(long id, VideoDto request);
    /**
     * delete existing video by providing video id {@code id}.
     *
     * @param id the video id
     * @return the ServerResponse
     */
    ServerResponse deleteVideo(long id);
    /**
     * Returns {@code Video} with given {@code id}.
     * @param id the video id
     * @return the Video
     */
    ServerResponse getVideoById(long id);
    /**
     * Returns paginated video {@code Video} with given value.
     * @param limit the items limit
     * @param page the page number
     * @return the Video
     */
    ServerResponse getVideos(int limit, int page);
    /**
     * Returns paginated video filter by video type {@code VideoType}
     * @param type the video type
     * @param limit the items limit
     * @param page the page number
     * @return the Video
     */
    ServerResponse getVideoByType(VideoType type, int limit, int page);
    /**
     * Returns paginated video filter by video genre {@code VideoType}
     * @param genre the video genre
     * @param limit the items limit
     * @param page the page number
     * @return the Video
     */
    ServerResponse getVideoByGenre(VideoGenre genre, int limit, int page);
    ServerResponse filterVideo(String query, VideoType type, VideoGenre genre, int limit, int page);
    ServerResponse searchVideo(String query, int limit, int page);
}
