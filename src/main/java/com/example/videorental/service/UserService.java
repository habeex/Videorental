package com.example.videorental.service;

import com.example.videorental.dto.ServerResponse;
import com.example.videorental.dto.UserDto;
import org.springframework.stereotype.Service;

/**
 * Interface for actions on {@code User}.
 *
 * @author Olorunishola Habeeb
 */
@Service
public interface UserService {

    /**
     * Creates new {@code User} based on given values.
     *
     * @param request  UserDto
     * @return the ServerResponse
     */
    ServerResponse create(UserDto request);

    /**
     * Returns {@code User} with given {@code email}.
     *
     * @param email the email
     * @return the user
     */
    ServerResponse getUserByEmail(String email);

    /**
     * Returns list of {@code User} for given {@code query} .
     *
     * @param query the user name
     * @param limit the items limit
     * @param page the page number
     * @return the paginated list of all {@code User} if {@code query} is {@code null}
     */
    ServerResponse searchForUser(String query, int limit, int page);
}
