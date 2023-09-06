package com.example.instant_api.service;

import com.example.instant_api.entity.Picture;
import com.example.instant_api.repository.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PictureService {

    private final PictureRepository pictureRepository;

    @Autowired
    public PictureService(PictureRepository pictureRepository) {
        this.pictureRepository = pictureRepository;
    }

    public List<Picture> getAllPictures() {
        return this.pictureRepository.findAll();
    }

    public Picture getPictureById(Long id) {
        return this.pictureRepository.findById(id).orElse(null);
    }

    public Picture createPicture(Picture picture) {
        return this.pictureRepository.save(picture);
    }

    public Picture updatePicture(Picture picture) {
        return this.pictureRepository.save(picture);
    }

    public void deletePicture(Long id) {
        this.pictureRepository.deleteById(id);
    }

    public List<Picture> getPicturesByEventId(Long eventId) {
        return this.pictureRepository.findAllByEventId(eventId);
    }
}
