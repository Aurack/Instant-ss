package com.example.instant_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

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

    public Picture(Date date, String pictureUrl, Event event) {
        this.event = event;
        this.date = date;
        this.pictureUrl = pictureUrl;
    }
}
