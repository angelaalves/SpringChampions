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
    @Column(name = "ID_Notification_Receivers")
    private int idnotificationreceivers;
    @ManyToOne
    @JoinColumn(name = "ID_Player_Receiver_FK", referencedColumnName = "ID_Player")
    private Player idplayerreceiver;
    @ManyToOne
    @JoinColumn(name = "ID_Notification_FK", referencedColumnName = "ID_Notification")
    private Notification idnotification;
    @ManyToOne
    @JoinColumn(name = "ID_Guild_FK", referencedColumnName = "ID_Guild")
    private Guild idguild;
    @Column(name = "Notification_Seen")
    private int notificationseen;

    public NotificationReceiver() {
    }

    public NotificationReceiver(int idnotificationReceivers, Player idplayerreceiver, Notification idnotification, Guild idguild, int notificationSeen) {
        this.idnotificationreceivers = idnotificationReceivers;
        this.idplayerreceiver = idplayerreceiver;
        this.idnotification = idnotification;
        this.idguild = idguild;
        this.notificationseen = notificationSeen;
    }

    public int getIdnotificationReceivers() {
        return idnotificationreceivers;
    }

    public Player getIdplayerreceiver() {
        return idplayerreceiver;
    }

    public Notification getIdnotification() {
        return idnotification;
    }

    public Guild getIdguild() {
        return idguild;
    }

    public int getNotificationSeen() {
        return notificationseen;
    }

    public void setIdnotificationReceivers(int idnotificationReceivers) {
        this.idnotificationreceivers = idnotificationReceivers;
    }

    public void setIdplayerreceiver(Player idplayerreceiver) {
        this.idplayerreceiver = idplayerreceiver;
    }

    public void setIdnotification(Notification idnotification) {
        this.idnotification = idnotification;
    }

    public void setIdguild(Guild idguild) {
        this.idguild = idguild;
    }

    public void setNotificationSeen(int notificationSeen) {
        this.notificationseen = notificationSeen;
    }
}