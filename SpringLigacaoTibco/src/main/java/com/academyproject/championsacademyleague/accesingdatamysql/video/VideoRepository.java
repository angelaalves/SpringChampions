package com.academyproject.championsacademyleague.accesingdatamysql.video;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VideoRepository extends CrudRepository<Video, Integer> {
    @Query(value = "SELECT v FROM video v WHERE v.VideoName= :videoName", nativeQuery = true)
    List<Video> findByVideoName(@Param("videoName") String videoName);

    @Query(value = "SELECT v FROM video v WHERE v.Topic= :topic", nativeQuery = true)
    List<Video> findByTopic(@Param("topic") String topic);
}