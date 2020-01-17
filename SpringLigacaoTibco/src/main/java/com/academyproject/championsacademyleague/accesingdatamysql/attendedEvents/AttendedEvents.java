package com.academyproject.championsacademyleague.accesingdatamysql.attendedEvents;

import javax.persistence.*;

@Entity
@Table(name="attendedevents")

public class AttendedEvents {
    @JoinColumn(name="ID_Event_FK", referencedColumnName = "ID_Event", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Integer IDEventFK;
    @JoinColumn(name="ID_Player_FK", referencedColumnName = "ID_Player", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Integer IDPlayerFK;
}
