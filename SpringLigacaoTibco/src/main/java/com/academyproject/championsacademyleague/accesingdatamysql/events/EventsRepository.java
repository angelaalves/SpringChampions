package com.academyproject.championsacademyleague.accesingdatamysql.events;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EventsRepository extends CrudRepository<Event, Integer> {

    @Query(value = "SELECT * FROM events e WHERE e.ID_Event= :id", nativeQuery = true)
    Event findEventById(@Param("id") String id);

    @Query(value = "SELECT * FROM events e WHERE e.Eventname= :name", nativeQuery = true)
    List<Event> findEventByEventName(@Param("name") String name);

    @Query(value = "SELECT * FROM events e WHERE e.Eventdate= :date", nativeQuery = true)
    List<Event> findEventByEventDate(@Param("date") String date);

    @Query(value = "SELECT * FROM events e WHERE e.Eventtype= :type", nativeQuery = true)
    List<Event> findEventByEventType(@Param("type") String type);
}