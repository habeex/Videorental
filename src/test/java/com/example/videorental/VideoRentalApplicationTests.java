package com.example.videorental;

import com.example.videorental.controller.PriceController;
import com.example.videorental.controller.UserController;
import com.example.videorental.controller.VideoController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class VideoRentalApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private VideoController videoController;

    @Autowired
    private UserController userController;

    @Autowired
    private PriceController priceController;

    @Test
    public void whenContextLoadThenControllersCreated() {
        assertThat(videoController).isNotNull();
        assertThat(userController).isNotNull();
        assertThat(priceController).isNotNull();
    }
}
