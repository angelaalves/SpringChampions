package com.academyproject.championsacademyleague.accesingdatamysql.notifications;

import com.academyproject.championsacademyleague.accesingdatamysql.events.Events;
import com.academyproject.championsacademyleague.accesingdatamysql.guild.Guild;
import com.academyproject.championsacademyleague.accesingdatamysql.player.Player;
import com.academyproject.championsacademyleague.accesingdatamysql.rewards.Reward;

import javax.persistence.*;

@Entity
@Table(name="notifications")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_Notification")
    private Integer IDNotification;
    @ManyToOne
    @JoinColumn(name = "ID_Player_Sender_FK", referencedColumnName = "ID_Player")
    private Player IDPlayerSenderFK;
    @ManyToOne
    @JoinColumn(name = "ID_Guild_FK", referencedColumnName = "ID_Guild")
    private Guild IDGuildFK;
    @Column(name = "isreward")
    private Integer isReward;
    @Column(name = "isrvent")
    private Integer isEvent;
    @Column(name = "Description")
    private String Description;

    public Integer getIDNotification() {
        return IDNotification;
    }

    public Player getIDPlayerSenderFK() {
        return IDPlayerSenderFK;
    }

    public Guild getIDGuildFK() {
        return IDGuildFK;
    }

    public Integer getIsReward() {
        return isReward;
    }

    public Integer getIsEvent() {
        return isEvent;
    }

    public String getDescription() {
        return Description;
    }

    public void setIDNotification(Integer IDNotification) {
        this.IDNotification = IDNotification;
    }

    public void setIDPlayerSenderFK(Player IDPlayerSenderFK) {
        this.IDPlayerSenderFK = IDPlayerSenderFK;
    }

    public void setIDGuildFK(Guild IDGuildFK) {
        this.IDGuildFK = IDGuildFK;
    }

    public void setIsReward(Integer isReward) {
        this.isReward = isReward;
    }

    public void setIsEvent(Integer isEvent) {
        this.isEvent = isEvent;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
