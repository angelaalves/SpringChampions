package com.academyproject.championsacademyleague.accesingdatamysql.rewards;

import com.academyproject.championsacademyleague.accesingdatamysql.player.Player;

import javax.persistence.*;

@Entity
@Table(name="rewards")
public class Reward {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_Reward")
    private int IDReward;
    @ManyToOne
    @JoinColumn(name = "ID_Playergiver_FK", referencedColumnName = "ID_Player")
    private Player IDPlayerGiverFK;
    @ManyToOne
    @JoinColumn(name="ID_Playerreceiver_FK", referencedColumnName = "ID_Player")
    private Player IDPlayerReceiverFK;
    @Column(name = "Champiesgiven")
    private int ChampiesGiven;
    @Column(name = "Dateofreward")
    private String DateOfReward;
    @Column(name = "Approved")
    private int approved;
    @Column(name = "TimeSpent")
    private String timeSpent;
    @Column(name = "Justification")
    private String justification;

    public Reward() {}

    public Reward(int IDReward, Player IDPlayerGiverFK, Player IDPlayerReceiverFK, int champiesGiven, String dateOfReward, int approved, String timeSpent, String justification) {
        this.IDReward = IDReward;
        this.IDPlayerGiverFK = IDPlayerGiverFK;
        this.IDPlayerReceiverFK = IDPlayerReceiverFK;
        ChampiesGiven = champiesGiven;
        DateOfReward = dateOfReward;
        this.approved = approved;
        this.timeSpent = timeSpent;
        this.justification = justification;
    }

    public int getIDReward() {
        return IDReward;
    }

    public Player getIDPlayerGiverFK() {
        return IDPlayerGiverFK;
    }

    public Player getIDPlayerReceiverFK() {
        return IDPlayerReceiverFK;
    }

    public int getChampiesGiven() {
        return ChampiesGiven;
    }

    public String getDateOfReward() {
        return DateOfReward;
    }

    public int getApproved() {
        return approved;
    }

    public String getTimeSpent() {
        return timeSpent;
    }

    public String getJustification() {
        return justification;
    }

    public void setIDReward(int IDReward) {
        this.IDReward = IDReward;
    }

    public void setIDPlayerGiverFK(Player IDPlayerGiverFK) {
        this.IDPlayerGiverFK = IDPlayerGiverFK;
    }

    public void setIDPlayerReceiverFK(Player IDPlayerReceiverFK) {
        this.IDPlayerReceiverFK = IDPlayerReceiverFK;
    }

    public void setChampiesGiven(int champiesGiven) {
        ChampiesGiven = champiesGiven;
    }

    public void setDateOfReward(String dateOfReward) {
        DateOfReward = dateOfReward;
    }

    public void setApproved(int approved) {
        this.approved = approved;
    }

    public void setTimeSpent(String timeSpent) {
        this.timeSpent = timeSpent;
    }

    public void setJustification(String justification) {
        this.justification = justification;
    }
}