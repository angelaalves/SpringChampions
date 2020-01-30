package com.academyproject.championsacademyleague.accesingdatamysql.player;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
@Table(name="player")
public class Player {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ID_Player")
    private int idplayer;
    @Column(name="Username")
    private String username;
    @Column(name="Email")
    private String email;
    @Column(name="Password")
    private String password;
    @Column(name="Gender")
    private String gender;
    @Column(name="Usertype")
    private String usertype;
    @Column(name="XP")
    private int xp;
    @Column(name="Champiestogive")
    private int champiestogive;
    @Column(name="Mychampies")
    private int mychampies;
    @Column(name="Status")
    private String status;

    public Player() {}

    public Player(Integer idPlayer) {
        this.idplayer = idPlayer;
    }

    public Player(Integer idPlayer, String username, String email, String password, String gender, String usertype, int xp, int champiesToGive, int myChampies, String status) {
        this.idplayer = idPlayer;
        this.username = username;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.usertype = usertype;
        this.xp = xp;
        this.champiestogive = champiesToGive;
        this.mychampies = myChampies;
        this.status = status;
    }

    public int getIdPlayer() {
        return idplayer;
    }

    public void setIdPlayer(int idPlayer) {
        this.idplayer = idPlayer;
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

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getChampiesToGive() {
        return champiestogive;
    }

    public void setChampiesToGive(int champiesToGive) {
        this.champiestogive = champiesToGive;
    }

    public int getMyChampies() {
        return mychampies;
    }

    public void setMyChampies(int myChampies) {
        this.mychampies = myChampies;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}