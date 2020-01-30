package com.academyproject.championsacademyleague.accesingdatamysql.closet;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ClosetRepository extends CrudRepository<Closet, Integer> {

    @Query(value = "SELECT ID_Skin_FK, ID_Player_FK, Status  FROM closet c WHERE c.ID_Skin_FK= :id", nativeQuery = true)
    Iterable<Closet> findClosetById(@Param("id") String id);

    @Query(value="SELECT ID_Skin_FK, ID_Player_FK, Status FROM closet c WHERE c.ID_Skin_FK= :idskin AND c.ID_Player_FK= :idplayer", nativeQuery = true)
    Closet findSkinByPlayerId(@Param("idskin") String idskin, @Param("idplayer") String idplayer);

    @Query(value="SELECT ID_Skin_FK, ID_Player_FK, Status FROM closet c WHERE c.Status= :status", nativeQuery = true)
    Iterable<Closet> findClosetByStatus(@Param("status") String status);

    @Query(value="DELETE * FROM closet c WHERE c.ID_Skin_FK= :idskin AND c.ID_Player_FK= :idplayer", nativeQuery = true)
    Closet deleteCloset(@Param("idskin") String idskin, @Param("idplayer") String idplayer);
}