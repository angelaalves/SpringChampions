package com.academyproject.championsacademyleague.accesingdatamysql.attendedEvents;

import com.academyproject.championsacademyleague.accesingdatamysql.events.Events;
import com.academyproject.championsacademyleague.accesingdatamysql.player.Player;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.Objects;

/*@Embeddable
public class AttendedEventsId implements Serializable {

    @ManyToMany(targetEntity = Events.class)
    @JoinColumn(name = "ID_Event_FK")
    private Events IDEventFK;

    @ManyToMany(targetEntity = Player.class)
    @JoinColumn(name="ID_Player_FK")
    private Player IDPlayerFK;

    public Events getIDEventFK() {
        return IDEventFK;
    }

    public Player getIDPlayerFK() {
        return IDPlayerFK;
    }

    public void setIDEventFK(Events IDEventFK) {
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
}*/
