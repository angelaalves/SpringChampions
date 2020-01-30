package com.academyproject.championsacademyleague.accesingdatamysql.notificationReceivers;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NotificationReceiverRepository extends CrudRepository<NotificationReceiver, Integer> {
    @Query(value = "SELECT n FROM notification_receivers n WHERE n.IDNotificationReceiver= :idnotificationreceiver and n.ID_Player_Receiver_FK= :idplayerreceiver and n.ID_Notification_FK= :idnotification and n.ID_Guild_FK= :idguild", nativeQuery = true)
    List<NotificationReceiver> find(@Param("idnotificationreceiver") String idnotificationreceiver,
                                    @Param("idplayerreceiver") String idplayerreceiver,
                                    @Param("idnotification") String idnotification,
                                    @Param("idguild") String idguild);

    @Query(value = "SELECT n FROM notification_receivers n n.IDPlayerReceiver= :idplayerreceiver", nativeQuery = true)
    List<NotificationReceiver> findByPlayerReceiver(@Param("idplayerreceiver") String idplayerreceiver);
}