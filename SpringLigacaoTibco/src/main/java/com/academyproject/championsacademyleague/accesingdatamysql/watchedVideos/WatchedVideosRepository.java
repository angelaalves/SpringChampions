package com.academyproject.championsacademyleague.accesingdatamysql.watchedVideos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WatchedVideosRepository extends CrudRepository<WatchedVideos, Integer> {
    @Query(value = "SELECT w FROM watchedvideos w WHERE w.ID_Video_FK= :idVideo", nativeQuery = true)
    List<WatchedVideos> findByVideoId(@Param("idVideo") String idVideo);

    @Query(value = "SELECT w FROM watchedvideos w WHERE w.ID_Event_FK= :idEvent", nativeQuery = true)
    List<WatchedVideos> findByEventId(@Param("idEvent") String idEvent);
}