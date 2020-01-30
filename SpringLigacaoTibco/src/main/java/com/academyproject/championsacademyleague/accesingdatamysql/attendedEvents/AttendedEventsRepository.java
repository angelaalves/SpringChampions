package com.academyproject.championsacademyleague.accesingdatamysql.attendedEvents;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AttendedEventsRepository extends CrudRepository<AttendedEvents, Integer>{

    @Query(value = "SELECT ID_Event_FK, ID_Player_FK FROM attendedevents a WHERE a.ID_Event_FK=:idevent AND a.ID_Player_FK=:idplayer", nativeQuery = true)
    AttendedEvents findAttendedEventByIds(@Param("idevent") String idevent, @Param("idplayer") String idplayer);
}