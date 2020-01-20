package com.academyproject.championsacademyleague.accesingdatamysql.rewards;

import com.sun.tools.javac.comp.Resolve;

import javax.persistence.*;

@Entity
@Table(name="rewards")
public class Reward {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_Reward")
    private Integer IDReward;
    @Column(name = "ID_Playergiver_FK")
    private Integer IDPlayerGiverFK;
    @Column(name = "ID_PlayerReceiver_FK")
    private Integer IDPlayerReceiverFK;
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

    public Integer getIDPlayerGiverFK() {
        return IDPlayerGiverFK;
    }

    public Integer getIDPlayerReceiverFK() {
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

    public void setIDPlayerGiverFK(Integer IDPlayerGiverFK) {
        this.IDPlayerGiverFK = IDPlayerGiverFK;
    }

    public void setIDPlayerReceiverFK(Integer IDPlayerReceiverFK) {
        this.IDPlayerReceiverFK = IDPlayerReceiverFK;
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
