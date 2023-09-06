package com.example.instant_api.repository;

import com.example.instant_api.entity.LikePicture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LikePictureRepository extends JpaRepository<LikePicture, Long> {
    @Query(nativeQuery = true, value = "Select count(id) from like_picture where picture_id = :id")
    Long countByPictureId(@Param("id") Long id);

    @Query(nativeQuery = true, value = "Select count(id) from like_picture where picture_id = :pictureId and user_id = :userId")
    Long existsByPictureIdAndUserId(@Param("userId") Long userId, @Param("pictureId") Long pictureId);
}
