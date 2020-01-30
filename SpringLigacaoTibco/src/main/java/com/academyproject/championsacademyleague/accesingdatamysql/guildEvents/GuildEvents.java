package com.academyproject.championsacademyleague.accesingdatamysql.guildEvents;

import javax.persistence.*;

@Entity
@Table(name="guildevents")
public class GuildEvents {
    @EmbeddedId
    private GuildEventsId id;

    public GuildEvents() {
    }

    public GuildEvents(GuildEventsId id) {
        this.id = id;
    }

    public GuildEventsId getId() {
        return id;
    }

    public void setId(GuildEventsId id) {
        this.id = id;
    }
}
