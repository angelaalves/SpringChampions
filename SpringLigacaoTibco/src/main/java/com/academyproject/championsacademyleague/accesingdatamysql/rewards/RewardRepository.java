package com.academyproject.championsacademyleague.accesingdatamysql.rewards;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RewardRepository extends CrudRepository<Reward, Integer> {
    @Query(value = "SELECT r FROM rewards r WHERE r.Approved=0", nativeQuery = true)
    List<Reward> findRewardsToApprove();

    @Query(value = "SELECT r FROM rewards r WHERE r.ID_PlayerGiver_FK= :idPlayerGiver", nativeQuery = true)
    List<Reward> findByPlayerGiver(@Param("idPlayerGiver") String idPlayerGiver);

    @Query(value = "SELECT r FROM rewards r WHERE r.ID_PlayerReceiver_FK= :idPlayerReceiver", nativeQuery = true)
    List<Reward> findByPlayerReceiver(@Param("idPlayerReceiver") String idPlayerReceiver);

    @Query(value = "SELECT r FROM rewards r WHERE r.DateOfReward= :dateofreward", nativeQuery = true)
    List<Reward> findByDateOfReward(@Param("dateofreward") String dateofreward);

    @Query(value = "SELECT r FROM rewards r WHERE r.ChampiesGiven= :champiesGiven", nativeQuery = true)
    List<Reward> findByChampiesGiven(@Param("champiesGiven") Integer champiesGiven);

    @Query(value = "SELECT r FROM rewards r WHERE r.TimeSpent= :timespent", nativeQuery = true)
    List<Reward> findByTimeSpent(@Param("timespent") Integer timespent);
}