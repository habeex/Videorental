package com.example.videorental.service;

import com.example.videorental.dto.ServerResponse;
import org.springframework.stereotype.Service;

/**
 * Interface for actions on {@code PriceDto}.
 *
 * @author Olorunishola Habeeb
 */
@Service
public interface PriceService {
    /**
     * Returns {@code PriceDto}.
     *
     * @param userId the id of the user
     * @param videoId the id of the video
     * @param rentDays the number of rent days
     * @return the PriceDto
     */
    ServerResponse calculatePrice(long userId, long videoId, int rentDays);
}
