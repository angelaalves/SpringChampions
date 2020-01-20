package com.academyproject.championsacademyleague.accesingdatamysql.attendedEvents;

import javax.persistence.*;

@Entity
@Table(name="attendedevents")

public class AttendedEvents {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_Event_FK")
    private Integer IDEventFK;
    @Column(name = "ID_Player_FK")
    private Integer IDPlayerFK;
}
