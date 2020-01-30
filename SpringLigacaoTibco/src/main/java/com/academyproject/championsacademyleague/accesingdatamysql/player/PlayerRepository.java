package com.academyproject.championsacademyleague.accesingdatamysql.player;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlayerRepository extends CrudRepository<Player, Integer> {

    @Query(value = "SELECT * FROM player p WHERE p.ID_Player= :idplayer", nativeQuery = true)
    Player findByIdCustom(@Param("idplayer") String idplayer);

    @Query(value = "SELECT * FROM player p WHERE p.Email= :email", nativeQuery = true)
    Player findByEmail(@Param("email") String email);

    @Query(value = "SELECT * FROM player p WHERE p.Username= :username", nativeQuery = true)
    Player findByUsername(@Param("username") String username);

    @Query(value = "SELECT * FROM player p WHERE p.Gender= :gender", nativeQuery = true)
    List<Player> findByGender(@Param("gender") String gender);

    @Query(value = "SELECT * FROM player p WHERE p.Usertype= :usertype", nativeQuery = true)
    List<Player> findByUsertype(@Param("usertype") String usertype);

    @Query(value = "SELECT * FROM player p WHERE p.Status= :status", nativeQuery = true)
    List<Player> findByStatus(@Param("status") String status);
}