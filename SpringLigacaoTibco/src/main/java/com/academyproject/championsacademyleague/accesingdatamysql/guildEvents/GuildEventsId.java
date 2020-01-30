package com.academyproject.championsacademyleague.accesingdatamysql.guildEvents;

import com.academyproject.championsacademyleague.accesingdatamysql.events.Event;
import com.academyproject.championsacademyleague.accesingdatamysql.guild.Guild;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class GuildEventsId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "ID_Guild_FK", referencedColumnName = "ID_Guild")
    private Guild IDGuildFK;
    @ManyToOne
    @JoinColumn(name="ID_Event_FK", referencedColumnName = "ID_Event")
    private Event IDEventFK;

    public GuildEventsId() {
    }

    public GuildEventsId(Guild IDGuildFK) {
        this.IDGuildFK = IDGuildFK;
    }

    public GuildEventsId(Guild IDGuildFK, Event IDEventFK) {
        this.IDGuildFK = IDGuildFK;
        this.IDEventFK = IDEventFK;
    }

    public Guild getIDGuildFK() {
        return IDGuildFK;
    }

    public Event getIDEventFK() {
        return IDEventFK;
    }

    public void setIDGuildFK(Guild IDGuildFK) {
        this.IDGuildFK = IDGuildFK;
    }

    public void setIDEventFK(Event IDEventFK) {
        this.IDEventFK = IDEventFK;
    }
}