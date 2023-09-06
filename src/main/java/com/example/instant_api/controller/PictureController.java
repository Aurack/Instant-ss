package com.example.instant_api.controller;

import com.example.instant_api.entity.Picture;
import com.example.instant_api.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/pictures")
public class PictureController {

    private final PictureService pictureService;

    @Autowired
    public PictureController(PictureService pictureService) {
        this.pictureService = pictureService;
    }

    @GetMapping
    public ResponseEntity<List<Picture>> getAllPictures() {
        List<Picture> pictures = pictureService.getAllPictures();
        return ResponseEntity.ok(pictures);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Picture> getPictureById(@PathVariable Long id) {
        Picture picture = pictureService.getPictureById(id);
        return ResponseEntity.ok(picture);
    }

    @GetMapping("/event/{eventId}")
    public ResponseEntity<List<Picture>> getPicturesByEvent(@PathVariable Long eventId) {
        List<Picture> pictures = pictureService.getPicturesByEventId(eventId);
        return ResponseEntity.ok(pictures);
    }

    @PostMapping
    public ResponseEntity<Picture> createPicture(@RequestParam("image") MultipartFile picture) throws IOException {
        if (picture != null && !picture.isEmpty()) {
            byte[] imageBytes = picture.getBytes();
            String base64Image = Base64.getEncoder().encodeToString(imageBytes);
            System.out.println(base64Image);
            Picture toCreatePicture = new Picture(new Date(), base64Image);
            Picture createdPicture = pictureService.createPicture(toCreatePicture);
            return ResponseEntity.ok(createdPicture);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Picture> updatePicture(@RequestBody Picture picture) {
        Picture updatedPicture = pictureService.updatePicture(picture);
        return ResponseEntity.ok(updatedPicture);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePicture(@PathVariable Long id) {
        pictureService.deletePicture(id);
        return ResponseEntity.noContent().build();
    }
}
