package com.example.videorental.dto;

import com.example.videorental.enumType.VideoGenre;
import com.example.videorental.enumType.VideoType;
import lombok.Data;

@Data
public class VideoDto {
    private String title;
    private String description;
    private double rate;
    private VideoType type;
    private VideoGenre genre;
    private int age;
    private int releasedYear;
}
