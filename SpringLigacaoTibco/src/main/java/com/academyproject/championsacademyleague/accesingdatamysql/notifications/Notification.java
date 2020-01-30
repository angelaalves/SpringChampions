package com.academyproject.championsacademyleague.accesingdatamysql.notifications;

import com.academyproject.championsacademyleague.accesingdatamysql.guild.Guild;
import com.academyproject.championsacademyleague.accesingdatamysql.player.Player;

import javax.persistence.*;

@Entity
@Table(name="notifications")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_Notification")
    private int IDNotification;
    @ManyToOne
    @JoinColumn(name = "ID_Player_Sender_FK", referencedColumnName = "ID_Player")
    private Player idplayerSenderFK;
    @ManyToOne
    @JoinColumn(name = "ID_Guild_FK", referencedColumnName = "ID_Guild")
    private Guild idguild;
    @Column(name = "isreward")
    private int isreward;
    @Column(name = "isevent")
    private int isEvent;
    @Column(name = "description")
    private String description;

    public Notification() {
    }

    public Notification(int idNotification, Player idPlayerSenderFK, Guild idGuildFK, int isReward, int isEvent, String description) {
        this.IDNotification = idNotification;
        this.idplayerSenderFK = idPlayerSenderFK;
        this.idguild = idGuildFK;
        this.isreward = isReward;
        this.isEvent = isEvent;
        this.description = description;
    }

    public int getIDNotification() {
        return IDNotification;
    }

    public Player getIDPlayerSenderFK() {
        return idplayerSenderFK;
    }

    public Guild getIDGuildFK() {
        return idguild;
    }

    public int getIsReward() {
        return isreward;
    }

    public int getIsEvent() {
        return isEvent;
    }

    public String getDescription() {
        return description;
    }

    public void setIDNotification(int IDNotification) {
        this.IDNotification = IDNotification;
    }

    public void setIDPlayerSenderFK(Player IDPlayerSenderFK) {
        this.idplayerSenderFK = IDPlayerSenderFK;
    }

    public void setIDGuildFK(Guild IDGuildFK) {
        this.idguild = IDGuildFK;
    }

    public void setIsReward(int isReward) {
        this.isreward = isReward;
    }

    public void setIsEvent(int isEvent) {
        this.isEvent = isEvent;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}