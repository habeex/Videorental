package com.example.videorental.repository;

import com.example.videorental.enumType.VideoGenre;
import com.example.videorental.enumType.VideoType;
import com.example.videorental.model.Video;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface to manage {@code Video} instances.
 *
 * @author Olorunishola Habeeb
 */
@Repository
public interface VideoRepository extends CrudRepository<Video, Long> {
    Video findById(long id);
    List<Video> findByTitleAndGenre(String title, VideoGenre genre);
    Page<Video> findAll(Pageable pageable);
    Page<Video> findAll(Specification<Video> spec, Pageable pageable);
    Page<Video> findAllByType(Pageable pageable, VideoType type);
    Page<Video> findAllByGenre(Pageable pageable, VideoGenre genre);
}
