package com.academyproject.championsacademyleague.accesingdatamysql.notifications;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NotificationRepository extends CrudRepository<Notification, Integer> {

    @Query(value = "SELECT n FROM notification n WHERE n.ID_Notification= :idnotification", nativeQuery = true)
    Notification findNotificationById(@Param("idnotification") String idnotification);

    @Query(value = "SELECT n FROM notification n WHERE n.ID_Player_Sender_FK= :idplayersenderfk", nativeQuery = true)
    List<Notification> findNotificationByPlayerSenderId(@Param("idplayersenderfk") String idplayersenderfk);

    @Query(value = "SELECT n FROM notification n WHERE n.ID_Guild_FK= :idguildfk", nativeQuery = true)
    List<Notification> findNotificationByGuildId(@Param("idguildfk") String idguildfk);

    @Query(value = "SELECT n FROM notification n WHERE n.isReward= :isreward", nativeQuery = true)
    List<Notification> findNotificationByReward(@Param("isreward") String isreward);

    @Query(value = "SELECT n FROM notification n WHERE n.isEvent= :isevent", nativeQuery = true)
    List<Notification> findNotificationByEvent(@Param("isevent") String isevent);

}