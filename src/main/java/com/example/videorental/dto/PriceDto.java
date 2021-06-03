package com.example.videorental.dto;

import lombok.Data;

@Data
public class PriceDto {
    String name;
    String videoTitle;
    int rentDays;
    double price;
}
