package com.academyproject.championsacademyleague.accesingdatamysql.watchedVideos;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "watchedvideos")
public class WatchedVideos {
    @EmbeddedId
    private WatchedVideosId id;

    public WatchedVideosId getId() {
        return id;
    }

    public void setId(WatchedVideosId id) {
        this.id = id;
    }
}
