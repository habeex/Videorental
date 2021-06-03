package com.example.videorental.service;

import com.example.videorental.repository.UserRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

@SpringBootTest
public class UserServiceTest {
    UserService userService;

    @Mock
    UserRepository userRepository;


    @Test
    public void create() throws Exception{

    }

    @Test
    public void getUserByEmail() throws Exception{

    }

    @Test
    public void searchForUser() throws Exception{

    }
}
