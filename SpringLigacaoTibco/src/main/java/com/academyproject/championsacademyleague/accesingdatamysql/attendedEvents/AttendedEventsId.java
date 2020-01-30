package com.academyproject.championsacademyleague.accesingdatamysql.attendedEvents;

import com.academyproject.championsacademyleague.accesingdatamysql.events.Event;
import com.academyproject.championsacademyleague.accesingdatamysql.player.Player;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AttendedEventsId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "ID_Event_FK", referencedColumnName = "ID_Event")
    private Event IDEventFK;

    @ManyToOne
    @JoinColumn(name="ID_Player_FK", referencedColumnName = "ID_Player")
    private Player IDPlayerFK;

    public AttendedEventsId() {
    }

    public AttendedEventsId(Event IDEventFK, Player IDPlayerFK) {
        this.IDEventFK = IDEventFK;
        this.IDPlayerFK = IDPlayerFK;
    }

    public Event getIDEventFK() {
        return IDEventFK;
    }

    public Player getIDPlayerFK() {
        return IDPlayerFK;
    }

    public void setIDEventFK(Event IDEventFK) {
        this.IDEventFK = IDEventFK;
    }

    public void setIDPlayerFK(Player IDPlayerFK) {
        this.IDPlayerFK = IDPlayerFK;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (!(o instanceof AttendedEventsId)) return false;
        AttendedEventsId that = (AttendedEventsId) o;
        return Objects.equals(getIDEventFK(), that.getIDEventFK()) &&
                Objects.equals(getIDPlayerFK(), that.getIDPlayerFK());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIDEventFK(), getIDPlayerFK());
    }
}
