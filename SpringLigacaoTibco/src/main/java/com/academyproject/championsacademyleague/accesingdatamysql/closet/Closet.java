package com.academyproject.championsacademyleague.accesingdatamysql.closet;

import javax.persistence.*;

@Entity
@Table(name="closet")
public class Closet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID_Skin_FK")
    private Integer IDSkinFK;
    @Column(name="ID_Player_FK")
    private Integer IDPlayerFK;
    @Column(name="Status")
    private String status;

    public Integer getIDSkinFK() {
        return IDSkinFK;
    }

    public Integer getIDPlayerFK() {
        return IDPlayerFK;
    }

    public String getStatus() {
        return status;
    }

    public void setIDSkinFK(Integer IDSkinFK) {
        this.IDSkinFK = IDSkinFK;
    }

    public void setIDPlayerFK(Integer IDPlayerFK) {
        this.IDPlayerFK = IDPlayerFK;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
