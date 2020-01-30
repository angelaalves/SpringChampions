package com.academyproject.championsacademyleague.accesingdatamysql.skin;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SkinRepository extends CrudRepository<Skin, Integer> {

    @Query(value = "SELECT s FROM skin s WHERE s.ID_Skin= :idSkin", nativeQuery = true)
    Skin findSkinById(@Param("idSkin") Integer idSkin);

    @Query(value = "SELECT s FROM skin s WHERE s.SkinName= :skinName", nativeQuery = true)
    List<Skin> findSkinByName(@Param("skinName") String skinName);

    @Query(value = "SELECT s FROM skin s WHERE s.ImagePath= :imagePath", nativeQuery = true)
    List<Skin> findSkinByImagePath(@Param("imagePath") String imagePath);

    @Query(value = "SELECT s FROM skin s WHERE s.MinXP= :minXp", nativeQuery = true)
    List<Skin> findSkinByMinXp(@Param("minXp") String minXp);

    @Query(value = "SELECT s FROM skin s WHERE s.ChampiesCost= :champiesCost", nativeQuery = true)
    List<Skin> findSkinByChampiesCost(@Param("champiesCost") String champiesCost);

    @Query(value = "SELECT s FROM skin s WHERE s.SkinType= :skinType", nativeQuery = true)
    List<Skin> findSkinBySkinType(@Param("skinType") String skinType);
}