package com.example.videorental.dto;

import com.example.videorental.enumType.GenderType;
import lombok.Data;

@Data
public class UserDto {
    String name;
    String email;
    GenderType gender;
    int age;
}
