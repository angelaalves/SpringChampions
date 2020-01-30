package com.academyproject.championsacademyleague.accesingdatamysql.guildPlayers;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GuildPlayersRepository extends CrudRepository<GuildPlayers, Integer> {

    @Query(value = "DELETE FROM guildplayers g WHERE g.ID_Guild_FK= :idguild", nativeQuery = true)
    List<GuildPlayers> deleteGuildPlayer(@Param("idguild") Integer idguild);

    @Query(value = "SELECT g FROM guildplayers g WHERE g.id_warrior_fk= :idplayer or g.id_guildmaster_fk= :idplayer", nativeQuery = true)
    List<GuildPlayers> findByIdPlayer(@Param("idplayer") Integer idplayer);

    @Query(value = "SELECT g FROM guildplayers g WHERE g.StartDate= :startdate", nativeQuery = true)
    List<GuildPlayers> findByStartDate(@Param("startdate") String startdate);

    @Query(value="SELECT g FROM guildplayers g WHERE g.ID_Guild_FK= :idguildfk", nativeQuery = true)
    List<GuildPlayers> findGuildPlayerByGuildId(@Param("idguildfk") String idguildfk);

    @Query(value="SELECT ID_GuildMaster_FK, ID_Warrior_FK FROM guildplayers g WHERE g.ID_Guild_FK= :idguildfk", nativeQuery = true)
    List<String> findPlayersByGuildId(@Param("idguildfk") String idguildfk);

    @Query(value = "SELECT ID_GuildMaster_FK FROM guildplayers g WHERE g.ID_Guild_FK= :idguildfk", nativeQuery = true)
    List<String> findGuildMasterByGuildId(@Param("idguildfk") String idguildfk);
}