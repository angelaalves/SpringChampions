package com.academyproject.championsacademyleague.accesingdatamysql.closet;

import javax.persistence.*;

@Entity
@Table(name="closet")
public class Closet {
    @EmbeddedId
    private ClosetId id;
    @Column(name="Status")
    private String status;

    public Closet() {
    }

    public Closet(ClosetId id, String status) {
        this.id = id;
        this.status = status;
    }

    public ClosetId getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public void setId(ClosetId id) {
        this.id = id;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}