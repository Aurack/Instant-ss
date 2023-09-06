package com.example.instant_api.repository;

import com.example.instant_api.entity.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PictureRepository extends JpaRepository<Picture, Long> {
    @Query(nativeQuery = true, value = "Select * from picture p where p.event_id = :event_id")
    List<Picture> findAllByEventId(@Param("event_id") Long eventId);
}
