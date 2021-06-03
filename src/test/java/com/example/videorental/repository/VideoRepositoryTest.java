package com.example.videorental.repository;

import com.example.videorental.data.VideoData;
import com.example.videorental.enumType.VideoGenre;
import com.example.videorental.enumType.VideoType;
import com.example.videorental.model.Video;
import com.example.videorental.utilities.SearchSpecification;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class VideoRepositoryTest {

    @Autowired
    VideoRepository videoRepository;

    int page = 1;
    int limit = 5;

    @Test
    public void addVideo() throws Exception{
        Video video = VideoData.newVideo("Spiral: From the Book of Saw");
        final Video result = videoRepository.save(video);
        assertThat(result).isNotNull();
        assertThat(result).hasFieldOrPropertyWithValue("title", "Spiral: From the Book of Saw");
        videoRepository.delete(result);
    }

    @Test
    public void findById() throws Exception{
        final Video result = videoRepository.findById(1L);
        assertThat(result).isNull();
    }

    @Test
    public void findAll() throws Exception{
        PageRequest pageable = PageRequest.of(page - 1, limit, Sort.by(Sort.Direction.DESC, "createdDate"));
        Page<Video> result = videoRepository.findAll(
                Specification
                        .where(new SearchSpecification<Video>().equal("title", "Spiral: From the Book of Saw"))
                        .or(new SearchSpecification<Video>().equal("type", VideoType.NewRelease))
                        .or(new SearchSpecification<Video>().equal("genre", VideoGenre.Horror)),
                pageable
        );
        assertThat(result.getContent()).isNotEmpty();
        assertThat(result.getContent()).extracting(Video::getTitle).contains("Spiral: From the Book of Saw");
    }

    @Test
    public void findByTitleAndGenre() throws Exception{
        List<Video> result = videoRepository.findByTitleAndGenre("Spiral: From the Book of Saw", VideoGenre.Horror);
        assertThat(result).isNotEmpty();
        assertThat(result).extracting(Video::getAge).contains(19);
    }

    @Test
    public void findAllByType() throws Exception{
        PageRequest pageable = PageRequest.of(page - 1, limit, Sort.by(Sort.Direction.DESC, "createdDate"));
        Page<Video> result = videoRepository.findAllByType(pageable, VideoType.Regular);
        assertThat(result.getContent()).isNotEmpty();
        assertThat(result.getContent()).extracting(Video::getRate).contains(10.0);
    }

    @Test
    public void findAllByGenre() throws Exception{
        PageRequest pageable = PageRequest.of(page - 1, limit, Sort.by(Sort.Direction.DESC, "createdDate"));
        Page<Video> result = videoRepository.findAllByGenre(pageable, VideoGenre.Romance);
        assertThat(result.getContent()).isNotEmpty();
        assertThat(result.getContent()).extracting(Video::getRate).contains(15.0);
    }

}
