package com.academyproject.championsacademyleague.accesingdatamysql.notificationReceivers;

import com.academyproject.championsacademyleague.accesingdatamysql.guild.Guild;
import com.academyproject.championsacademyleague.accesingdatamysql.notifications.Notification;
import com.academyproject.championsacademyleague.accesingdatamysql.player.Player;

import javax.persistence.*;

@Entity
@Table(name="notification_receivers")
public class NotificationReceiver {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID_Notification_Receivers")
    private Integer IDNotificationReceivers;
    @ManyToOne
    @JoinColumn(name="ID_Player_Receiver_FK", referencedColumnName = "ID_Player")
    private Player IDPlayerReceiverFK;
    @ManyToOne
    @JoinColumn(name="ID_Notification_FK", referencedColumnName = "ID_Notification")
    private Notification IDNotificationFK;
    @ManyToOne
    @JoinColumn(name="ID_Guild_FK", referencedColumnName = "ID_Guild")
    private Guild IDGuildFK;
    @Column(name="Notification_Seen")
    private Integer notificationSeen;

    public Integer getIDNotificationReceivers() {
        return IDNotificationReceivers;
    }

    public Player getIDPlayerReceiverFK() {
        return IDPlayerReceiverFK;
    }

    public Notification getIDNotificationFK() {
        return IDNotificationFK;
    }

    public Guild getIDGuildFK() {
        return IDGuildFK;
    }

    public Integer getNotificationSeen() {
        return notificationSeen;
    }

    public void setIDNotificationReceivers(Integer IDNotificationReceivers) {
        this.IDNotificationReceivers = IDNotificationReceivers;
    }

    public void setIDPlayerReceiverFK(Player IDPlayerReceiverFK) {
        this.IDPlayerReceiverFK = IDPlayerReceiverFK;
    }

    public void setIDNotificationFK(Notification IDNotificationFK) {
        this.IDNotificationFK = IDNotificationFK;
    }

    public void setIDGuildFK(Guild IDGuildFK) {
        this.IDGuildFK = IDGuildFK;
    }

    public void setNotificationSeen(Integer notificationSeen) {
        this.notificationSeen = notificationSeen;
    }
}
