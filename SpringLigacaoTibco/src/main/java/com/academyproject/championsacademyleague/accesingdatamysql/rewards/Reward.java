package com.academyproject.championsacademyleague.accesingdatamysql.rewards;

import com.academyproject.championsacademyleague.accesingdatamysql.player.Player;

import javax.persistence.*;

@Entity
@Table(name="rewards")
public class Reward {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_Reward")
    private Integer IDReward;
    @ManyToOne
    @JoinColumn(name = "ID_Playergiver_FK", referencedColumnName = "ID_Player")
    private Player IDPlayerGiverFK;
    @ManyToOne
    @JoinColumn(name="ID_Playerreceiver_FK", referencedColumnName = "ID_Player")
    private Player IDPlayerReceiverFK;
    @Column(name = "Champiesgiven")
    private Integer ChampiesGiven;
    @Column(name = "Dateofreward")
    private String DateOfReward;
    @Column(name = "Approved")
    private Integer Approved;
    @Column(name = "Timespent")
    private String TimeSpent;
    @Column(name = "Justification")
    private String Justification;

    public Integer getIDReward() {
        return IDReward;
    }

    public Player getIdplayergiverfk() {
        return IDPlayerGiverFK;
    }

    public Player getIdplayerreceiverfk() {
        return IDPlayerReceiverFK;
    }

    public Integer getChampiesGiven() {
        return ChampiesGiven;
    }

    public String getDateOfReward() {
        return DateOfReward;
    }

    public Integer getApproved() {
        return Approved;
    }

    public String getTimeSpent() {
        return TimeSpent;
    }

    public String getJustification() {
        return Justification;
    }

    public void setIDReward(Integer IDReward) {
        this.IDReward = IDReward;
    }

    public void setIdplayergiverfk(Player idplayergiverfk) {
        this.IDPlayerGiverFK = idplayergiverfk;
    }

    public void setIdplayerreceiverfk(Player idplayerreceiverfk) {
        this.IDPlayerReceiverFK = idplayerreceiverfk;
    }

    public void setChampiesGiven(Integer champiesGiven) {
        ChampiesGiven = champiesGiven;
    }

    public void setDateOfReward(String dateOfReward) {
        DateOfReward = dateOfReward;
    }

    public void setApproved(Integer approved) {
        Approved = approved;
    }

    public void setTimeSpent(String timeSpent) {
        TimeSpent = timeSpent;
    }

    public void setJustification(String justification) {
        Justification = justification;
    }
}
