package com.academyproject.championsacademyleague.accesingdatamysql.guild;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GuildRepository extends CrudRepository<Guild, Integer> {
    @Query(value = "SELECT ID_Guild, GuildName, StartDate, EndDate, GuildFlag, Status FROM guild g WHERE g.ID_Guild= :idguild", nativeQuery = true)
    Guild findGuildByID(@Param("idguild") String idguild);

    @Query(value = "SELECT ID_Guild, GuildName, StartDate, EndDate, GuildFlag, Status FROM guild g WHERE g.GuildName= :guildname", nativeQuery = true)
    List<Guild> findGuildByName(@Param("guildname") String guildname);

    @Query(value = "SELECT ID_Guild, GuildName, StartDate, EndDate, GuildFlag, Status FROM guild g WHERE g.StartDate= :startdate", nativeQuery = true)
    List<Guild> findGuildByStartDate(@Param("startdate") String startdate);

    @Query(value = "SELECT ID_Guild, GuildName, StartDate, EndDate, GuildFlag, Status FROM guild g WHERE g.EndDate= :enddate", nativeQuery = true)
    List<Guild> findGuildByEndDate(@Param("enddate") String enddate);

    @Query(value = "SELECT ID_Guild, GuildName, StartDate, EndDate, GuildFlag, Status FROM guild g WHERE g.GuildFlag= :flag", nativeQuery = true)
    List<Guild> findGuildByFlag(@Param("flag") String flag);

    @Query(value = "SELECT ID_Guild, GuildName, StartDate, EndDate, GuildFlag, Status FROM guild g WHERE g.Status= :status", nativeQuery = true)
    List<Guild> findGuildByStatus(@Param("status") String status);
}