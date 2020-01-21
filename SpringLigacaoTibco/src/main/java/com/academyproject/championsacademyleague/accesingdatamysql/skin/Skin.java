package com.academyproject.championsacademyleague.accesingdatamysql.skin;

import javax.persistence.*;

@Entity
@Table(name = "Skin")
public class Skin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID_Skin")
    private Integer IDSkin;
    @Column(name="Skinname")
    private String SkinName;
    @Column(name = "Imagepath")
    private String ImagePath;
    @Column(name = "Minxp")
    private Integer MinXP;
    @Column(name = "Champiescost")
    private Integer ChampiesCost;
    @Column(name = "Skintype")
    private String SkinType;

    public Integer getIDSkin() {
        return IDSkin;
    }

    public String getSkinName() {
        return SkinName;
    }

    public String getImagePath() {
        return ImagePath;
    }

    public Integer getMinXP() {
        return MinXP;
    }

    public Integer getChampiesCost() {
        return ChampiesCost;
    }

    public String getSkinType() {
        return SkinType;
    }

    public void setIDSkin(Integer IDSkin) {
        this.IDSkin = IDSkin;
    }

    public void setSkinName(String skinName) {
        SkinName = skinName;
    }

    public void setImagePath(String imagePath) {
        ImagePath = imagePath;
    }

    public void setMinXP(Integer minXP) {
        MinXP = minXP;
    }

    public void setChampiesCost(Integer champiesCost) {
        ChampiesCost = champiesCost;
    }

    public void setSkinType(String skinType) {
        SkinType = skinType;
    }
}
