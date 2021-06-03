package com.example.videorental.data;

import com.example.videorental.enumType.VideoGenre;
import com.example.videorental.enumType.VideoType;
import com.example.videorental.model.Video;

public class VideoData {
    public static Video newVideo(String title) {
        Video video = new Video();
        video.setTitle(title);
        video.setDescription("Working in the shadow of an esteemed police veteran, brash Detective Ezekiel \"Zeke\" Banks and his rookie partner take charge of a grisly investigation into murders that are eerily reminiscent of the city's gruesome past. Unwittingly entrapped in a deepening mystery, Zeke finds himself at the center of the killer's morbid game.");
        video.setGenre(VideoGenre.Horror);
        video.setType(VideoType.NewRelease);
        video.setReleasedYear(2021);
        video.setAge(19);
        video.setRate(15);
        return  video;
    }
}
