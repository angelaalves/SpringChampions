package com.academyproject.championsacademyleague.accesingdatamysql.events;

import javax.persistence.*;

@Entity
@Table(name="events")
public class Events {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID_Event")
    private Integer IDEvent;
    @Column(name="Eventname")
    private String eventName;
    @Column(name="Eventdate")
    private String eventDate;
    @Column(name="Eventtype")
    private String eventType;

    public Integer getIDEvent() {
        return IDEvent;
    }

    public String getEventName() {
        return eventName;
    }

    public String getEventDate() {
        return eventDate;
    }

    public String getEventType() {
        return eventType;
    }

    public void setIDEvent(Integer IDEvent) {
        this.IDEvent = IDEvent;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }
}
