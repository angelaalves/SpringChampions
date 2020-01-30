package com.academyproject.championsacademyleague.accesingdatamysql.guildEvents;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GuildEventsRepository extends CrudRepository<GuildEvents, Integer> {
    @Query(value = "DELETE * FROM guildevents g WHERE g.ID_Guild_FK= :idguild AND g.ID_Event_FK= :idevent", nativeQuery = true)
    List<GuildEvents> deleteGuildEvent(@Param("idguild") String idguild, @Param("idevent") String idevent);

    @Query(value = "SELECT g FROM guildevents g WHERE g.ID_Guild_FK= :idGuildFK", nativeQuery = true)
    List<GuildEvents> findGuildEventByGuildId(@Param("idGuildFK") String idGuildFK);

    @Query(value = "SELECT g FROM guildevents g WHERE g.ID_Event_FK= :idEventFK", nativeQuery = true)
    List<GuildEvents> findGuildEventByEventId(@Param("idEventFK") String idEventFK);

    @Query(value="SELECT ID_Guild_FK, ID_Event_FK FROM guildevents g WHERE g.ID_Guild_FK= :idguild and g.ID_Event_FK= :idevent", nativeQuery = true)
    GuildEvents findGuildEvent(@Param("idguild") String idguild, @Param("idevent") String idevent);
}