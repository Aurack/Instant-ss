package com.example.instant_api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "picture")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Picture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date date;

    private String pictureUrl;

    @JoinColumn(name = "event_id")
    @ManyToOne
    private Event event;
    @OneToMany
    @JsonIgnore
    private List<LikePicture> likePictures;

    public Picture(Date date, String pictureUrl) {
        this.date = date;
        this.pictureUrl = pictureUrl;
    }
}
