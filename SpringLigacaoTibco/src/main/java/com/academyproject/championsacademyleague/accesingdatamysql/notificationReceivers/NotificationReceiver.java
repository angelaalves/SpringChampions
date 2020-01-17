package com.academyproject.championsacademyleague.accesingdatamysql.notificationReceivers;

import javax.persistence.*;

@Entity
@Table(name="notification_receivers")
public class NotificationReceiver {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID_Notification_Receivers")
    private Integer IDNotificationReceivers;
    @Column(name="ID_Player_Receiver_FK")
    private Integer IDPlayerReceiverFK;
    @Column(name="ID_Notification_FK")
    private Integer IDNotificationFK;
    @Column(name="ID_Guild_FK")
    private Integer IDGuildFK;
    @Column(name="Notification_Seen")
    private Integer notificationSeen;

    public Integer getIDNotificationReceivers() {
        return IDNotificationReceivers;
    }

    public Integer getIDPlayerReceiverFK() {
        return IDPlayerReceiverFK;
    }

    public Integer getIDNotificationFK() {
        return IDNotificationFK;
    }

    public Integer getIDGuildFK() {
        return IDGuildFK;
    }

    public Integer getNotificationSeen() {
        return notificationSeen;
    }

    public void setIDNotificationReceivers(Integer IDNotificationReceivers) {
        this.IDNotificationReceivers = IDNotificationReceivers;
    }

    public void setIDPlayerReceiverFK(Integer IDPlayerReceiverFK) {
        this.IDPlayerReceiverFK = IDPlayerReceiverFK;
    }

    public void setIDNotificationFK(Integer IDNotificationFK) {
        this.IDNotificationFK = IDNotificationFK;
    }

    public void setIDGuildFK(Integer IDGuildFK) {
        this.IDGuildFK = IDGuildFK;
    }

    public void setNotificationSeen(Integer notificationSeen) {
        this.notificationSeen = notificationSeen;
    }
}
