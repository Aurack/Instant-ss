package com.example.instant_api.controller;

import com.example.instant_api.entity.LikePicture;
import com.example.instant_api.service.LikePictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/likes")
public class LikePictureController {
    private final LikePictureService likePictureService;

    @Autowired
    public LikePictureController(LikePictureService likePictureService) {
        this.likePictureService = likePictureService;
    }

    @GetMapping
    public ResponseEntity<List<LikePicture>> getAllLikes() {
        List<LikePicture> likePicture = likePictureService.getAllLikes();
        return ResponseEntity.ok(likePicture);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LikePicture> getLikeById(@PathVariable Long id) {
        LikePicture likePicture = likePictureService.getLikeById(id);
        return ResponseEntity.ok(likePicture);
    }

    @GetMapping("/picture/{id}")
    public ResponseEntity<Long> getLikeByPictureId(@PathVariable Long id) {
        Long count = likePictureService.getLikeByPictures(id);
        return ResponseEntity.ok(count);
    }

    @GetMapping("/liked")
    public ResponseEntity<Boolean> hasLiked(@RequestParam Long userId, @RequestParam Long pictureId) {
        boolean liked = this.likePictureService.hasLiked(userId, pictureId);
        return ResponseEntity.ok(liked);
    }

    @PostMapping
    public ResponseEntity<LikePicture> createLike(@RequestBody LikePicture likePicture) {
        LikePicture createdLikePicture = likePictureService.createLike(likePicture);
        return ResponseEntity.ok(createdLikePicture);
    }

    @PostMapping("/params")
    ResponseEntity<LikePicture> createLikeParams(@RequestParam Long userId, @RequestParam Long pictureId) {
        LikePicture createLikeParamsPicture = likePictureService.createLikeParams(userId, pictureId);
        return ResponseEntity.ok(createLikeParamsPicture);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LikePicture> updateLike(@RequestBody LikePicture likePicture) {
        LikePicture updatedLikePicture = likePictureService.updateLike(likePicture);
        return ResponseEntity.ok(updatedLikePicture);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLike(@PathVariable Long id) {
        likePictureService.deleteLike(id);
        return ResponseEntity.noContent().build();
    }
}
