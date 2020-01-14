package com.academyproject.championsacademyleague.controllers;


import com.academyproject.championsacademyleague.schemas.EventsDataInput;
import com.academyproject.championsacademyleague.schemas.EventsIn;
import com.academyproject.championsacademyleague.schemas.EventsOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("events")
public class eventsController {

    @Autowired
    public com.academyproject.championsacademyleague.services.eventsService eventsService;

    /**
     * Connection with angular and the exterior
     * @return
     */

    @RequestMapping("getAll")
    public List<EventsOut> getAllEvents() {
        EventsDataInput dataIn= new EventsDataInput();
        EventsIn eventsIn= new EventsIn("","","","");
        dataIn.getEventsIn().add(eventsIn);
        return eventsService.getAll(dataIn);
    }

    @RequestMapping("update")
    public List<EventsOut> getUpdateEvents(String idEvent, String eventName, String eventDate, String eventType){
        EventsDataInput dataIn= new EventsDataInput();
        EventsIn eventsIn= new EventsIn(idEvent,eventName,eventDate,eventType);
        dataIn.getEventsIn().add(eventsIn);
        return eventsService.update(dataIn);
    }

    @RequestMapping("Create")
    public List<EventsOut> getCreateEvents(String idEvent, String eventName, String eventDate, String eventType) {
        EventsDataInput dataIn=new EventsDataInput();
        EventsIn eventsIn= new EventsIn(idEvent,eventName,eventDate,eventType);
        dataIn.getEventsIn().add(eventsIn);
        System.out.println(dataIn.toString());
        return eventsService.create(dataIn);
    }

    @RequestMapping("delete")
    public List<EventsOut> getDeleteEvent(String idEvent) {
        EventsDataInput dataIn= new EventsDataInput();
        EventsIn eventsIn= new EventsIn(idEvent,"","","");
        dataIn.getEventsIn().add(eventsIn);
        return eventsService.delete(dataIn);
    }

    @RequestMapping("get")
    public List<EventsOut> getGetEvents(String idEvent, String eventName, String eventDate, String eventType) {
        EventsDataInput dataIn= new EventsDataInput();
        EventsIn eventsIn= new EventsIn(idEvent,eventName,eventDate,eventType);
        dataIn.getEventsIn().add(eventsIn);
        return eventsService.get(dataIn);
    }
}