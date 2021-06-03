package com.example.videorental.model;

import com.example.videorental.enumType.VideoGenre;
import com.example.videorental.enumType.VideoType;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Video entity.
 *
 * @author Olorunishola Habeeb
 */
@Data
@Entity
@Table(name = "video")
public class Video implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "video_id", nullable = false, unique = true)
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description", length = 1024)
    private String description;

    @Column(name = "rate", columnDefinition="Decimal default '0.0'")
    private double rate;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private VideoType type;

    @Enumerated(EnumType.STRING)
    @Column(name = "genre")
    private VideoGenre genre;

    @Column(name = "age")
    private Integer age;

    @Column(name = "released_year")
    private Integer releasedYear;

    @Column(name = "created_date", nullable = false, insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

}
