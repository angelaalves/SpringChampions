package com.academyproject.championsacademyleague.accesingdatamysql.events;

import javax.persistence.*;

@Entity
@Table(name="events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID_Event")
    private int idEvent;
    @Column(name="Eventname")
    private String eventName;
    @Column(name="Eventdate")
    private String eventDate;
    @Column(name="Eventtype")
    private String eventType;

    public Event() {}

    public Event(int idEvent, String eventName, String eventDate, String eventType) {
        this.idEvent = idEvent;
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventType = eventType;
    }

    public int getIDEvent() {
        return idEvent;
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

    public void setIDEvent(int idEvent) {
        this.idEvent = idEvent;
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