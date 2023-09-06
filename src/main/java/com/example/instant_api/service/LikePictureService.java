package com.example.instant_api.service;

import com.example.instant_api.entity.LikePicture;
import com.example.instant_api.entity.Picture;
import com.example.instant_api.entity.User;
import com.example.instant_api.repository.LikePictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikePictureService {
    private final LikePictureRepository likePictureRepository;
    private final PictureService pictureService;
    private final UserService userService;

    @Autowired
    public LikePictureService(LikePictureRepository LikePictureRepository, PictureService pictureService, UserService userService) {
        this.likePictureRepository = LikePictureRepository;
        this.pictureService = pictureService;
        this.userService = userService;
    }

    public List<LikePicture> getAllLikes() {
        return this.likePictureRepository.findAll();
    }

    public LikePicture getLikeById(Long id) {
        return this.likePictureRepository.findById(id).orElse(null);
    }

    public Long getLikeByPictures(Long id) {
        return this.likePictureRepository.countByPictureId(id);
    }

    public String hasLiked(Long userId, Long pictureId) {
        return this.likePictureRepository.findByUserIdAndPictureId(userId, pictureId);
    }

    public LikePicture createLike(LikePicture likePicture) {
        if (this.hasLiked(likePicture.getUser().getId(), likePicture.getPicture().getId()) != null)
            return this.likePictureRepository.save(likePicture);
        else
            return null;
    }

    public LikePicture createLikeParams(Long userId, Long pictureId) {
        if (this.hasLiked(userId, pictureId) != null) {
            User user = this.userService.getUserById(userId);
            Picture picture = this.pictureService.getPictureById(pictureId);
            LikePicture newLikePicture = new LikePicture(user, picture);
            return this.likePictureRepository.save(newLikePicture);
        }
        else
            return null;
    }

    public LikePicture updateLike(LikePicture LikePicture) {
        return this.likePictureRepository.save(LikePicture);
    }

    public void deleteLike(Long id) {
        this.likePictureRepository.deleteById(id);
    }
}
