package com.academyproject.championsacademyleague.controllers;

import com.academyproject.championsacademyleague.schemas.AttendedEventsDataInput;
import com.academyproject.championsacademyleague.schemas.AttendedEventsIn;
import com.academyproject.championsacademyleague.schemas.AttendedEventsOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.DataInput;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("attendedEvents")

public class attendedEventsController {

    @Autowired
    public com.academyproject.championsacademyleague.services.attendedEventsService attendedEventsService;

    /**
     * Connection with angular and the exterior
     * @return
     */

    @RequestMapping("getAll")
    public List<AttendedEventsOut> getAllAttendedEvents() {

        AttendedEventsDataInput dataIn= new AttendedEventsDataInput();
        AttendedEventsIn attendedEventsIn= new AttendedEventsIn("","");
        dataIn.getAttendedEventsIn().add(attendedEventsIn);
        return attendedEventsService.getAll(dataIn);

    }

    @RequestMapping("Create")
    public List<AttendedEventsOut> getCreateAttendedEvents() {

    }

    @RequestMapping("Update")
    public List<AttendedEventsOut> getUpdateAttendedEvents() {

    }

    @RequestMapping("Delete")
    public List<AttendedEventsOut> getDeleteAttendedEvents() {

    }

    @RequestMapping("Get")
    public List<AttendedEventsOut> getGetAttendedEvents() {

    }

}
