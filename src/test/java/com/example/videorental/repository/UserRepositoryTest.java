package com.example.videorental.repository;

import com.example.videorental.data.UserData;
import com.example.videorental.model.User;
import com.example.videorental.utilities.SearchSpecification;
import com.example.videorental.utilities.Utility;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;
    int page = 1;
    int limit = 5;

    @Test
    public void addUser() throws Exception{
        String email = Utility.generateRandomString(20) + "@gmail.com";
        User newUser = UserData.newUser("Olorunishola Habeeb", email);
        final User result = userRepository.save(newUser);
        assertThat(result).isNotNull();
        assertThat(result).hasFieldOrPropertyWithValue("email", email);
        userRepository.delete(result);
    }

    @Test
    public void findById() throws Exception{
        final User result = userRepository.findById(1L);
        assertThat(result).isNull();
    }

    @Test
    public void findByEmail() throws Exception{
        String email = Utility.generateRandomString(20) + "@gmail.com";
        User newUser = UserData.newUser("Olorunishola Habeeb", email);
        final User userResult = userRepository.save(newUser);
        final User result = userRepository.findByEmail(email);
        assertThat(result).isNotNull();
        userRepository.delete(userResult);
    }

    @Test
    public void findAll() throws Exception{
        PageRequest pageable = PageRequest.of(page - 1, limit, Sort.by(Sort.Direction.DESC, "createdDate"));
        Page<User> result = userRepository.findAll(
                Specification
                        .where(new SearchSpecification<User>().equal("name", "non-existing")),
                pageable
        );
        assertThat(result.getContent()).isEmpty();
    }

}
