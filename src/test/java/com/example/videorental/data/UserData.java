package com.example.videorental.data;

import com.example.videorental.enumType.GenderType;
import com.example.videorental.model.User;

public class UserData {
    public static User newUser(String name, String email){
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setGender(GenderType.Male);
        user.setAge(20);
        return user;
    }
}
