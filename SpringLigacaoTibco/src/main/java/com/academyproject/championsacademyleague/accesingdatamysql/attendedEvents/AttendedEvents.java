package com.academyproject.championsacademyleague.accesingdatamysql.attendedEvents;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="attendedevents")
public class AttendedEvents {
    @EmbeddedId
    private AttendedEventsId id;

    public AttendedEvents(AttendedEventsId id) {
        this.id = id;
    }

    public AttendedEvents() {
    }

    public AttendedEventsId getId() {
        return id;
    }

    public void setId(AttendedEventsId id) {
        this.id = id;
    }
}
