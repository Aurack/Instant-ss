package com.example.instant_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "like_picture")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LikePicture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "picture_id")
    private Picture picture;

    public LikePicture(User user, Picture picture) {
        this.user = user;
        this.picture = picture;
    }
}
