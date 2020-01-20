package com.academyproject.championsacademyleague.controllersTIBCO;

import com.academyproject.championsacademyleague.schemas.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("attendedEvents")
public class attendedEventsControllerTIBCO {

    @Autowired
    public com.academyproject.championsacademyleague.services.attendedEventsService attendedEventsService;

    /**
     * Connection with angular and the exterior
     * @return
     */

    @RequestMapping("Create")
    public List<AttendedEventsOut> getCreateAttendedEvents(String idEventsFK, String idPlayerFK) {
        AttendedEventsDataInput dataIn= new AttendedEventsDataInput();
        AttendedEventsIn attendedEventsIn= new AttendedEventsIn(idEventsFK, idPlayerFK);
        dataIn.getAttendedEventsIn().add(attendedEventsIn);
        return attendedEventsService.create(dataIn);
    }

    @RequestMapping("Delete")
    public List<AttendedEventsOut> getDeleteAttendedEvents(String idEventsFK, String idPlayerFK) {
        AttendedEventsDataInput dataIn= new AttendedEventsDataInput();
        AttendedEventsIn attendedEventsIn= new AttendedEventsIn(idEventsFK,idPlayerFK);
        dataIn.getAttendedEventsIn().add(attendedEventsIn);
        return attendedEventsService.delete(dataIn);
    }

    @RequestMapping("Get")
        public List<AttendedEventsOut> getGetAttendedEvents(String idEventsFK, String idPlayerFK) {
        AttendedEventsDataInput dataIn= new AttendedEventsDataInput();
        AttendedEventsIn attendedEventsIn= new AttendedEventsIn(idEventsFK,idPlayerFK);
        dataIn.getAttendedEventsIn().add(attendedEventsIn);
        return attendedEventsService.get(dataIn);
    }
}