package com.academyproject.championsacademyleague.accesingdatamysql.skin;

import javax.persistence.*;

@Entity
@Table(name = "skin")
public class Skin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID_Skin")
    private int IDSkin;
    @Column(name="Skinname")
    private String Skinname;
    @Column(name = "Imagepath")
    private String Imagepath;
    @Column(name = "Minxp")
    private int Minxp;
    @Column(name = "Champiescost")
    private int Champiescost;
    @Column(name = "Skintype")
    private String Skintype;

    public Skin() {
    }

    public Skin(int IDSkin) {
        this.IDSkin = IDSkin;
    }

    public Skin(int IDSkin, String skinname, String imagepath, int minXP, int champiecCost, String skintype) {
        this.IDSkin = IDSkin;
        this.Skinname = Skinname;
        this.Imagepath = Imagepath;
        this.Minxp = Minxp;
        this.Champiescost = Champiescost;
        this.Skintype = Skintype;
    }

    public int getIDSkin() {
        return IDSkin;
    }

    public String getSkinname() {
        return Skinname;
    }

    public String getImagepath() {
        return Imagepath;
    }

    public int getMinxp() {
        return Minxp;
    }

    public int getChampiescost() {
        return Champiescost;
    }

    public String getSkintype() {
        return Skintype;
    }

    public void setIDSkin(int IDSkin) {
        this.IDSkin = IDSkin;
    }

    public void setSkinname(String skinname) {
        Skinname = skinname;
    }

    public void setImagepath(String imagepath) {
        Imagepath = imagepath;
    }

    public void setMinxp(int minxp) {
        Minxp = minxp;
    }

    public void setChampiescost(int champiescost) {
        Champiescost = champiescost;
    }

    public void setSkintype(String skintype) {
        Skintype = skintype;
    }
}