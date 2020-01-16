package com.academyproject.championsacademyleague.accesingdatamysql;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
@Table(name="player")
public class player {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ID_Player")
    private Integer idPlayer;
    @Column(name="UserName")
    private String username;
    @Column(name="Email")
    private String email;
    @Column(name="password")
    private String password;
    @Column(name="Gender")
    private String gender;
    @Column(name="UserType")
    private String usertype;
    @Column(name="XP")
    private Integer xp;
    @Column(name="ChampiesToGive")
    private Integer champiesToGive;
    @Column(name="MyChampies")
    private Integer myChampies;
    @Column(name="Status")
    private String status;

    public Integer getIdPlayer() {
        return idPlayer;
    }

    public void setIdPlayer(Integer idPlayer) {
        this.idPlayer = idPlayer;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public Integer getXp() {
        return xp;
    }

    public void setXp(Integer xp) {
        this.xp = xp;
    }

    public Integer getChampiesToGive() {
        return champiesToGive;
    }

    public void setChampiesToGive(Integer champiesToGive) {
        this.champiesToGive = champiesToGive;
    }

    public Integer getMyChampies() {
        return myChampies;
    }

    public void setMyChampies(Integer myChampies) {
        this.myChampies = myChampies;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}