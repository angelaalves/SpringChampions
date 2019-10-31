package com.academyproject.championsacademyleague.controllers;


import com.academyproject.championsacademyleague.schemas.EventsDataInput;
import com.academyproject.championsacademyleague.schemas.EventsIn;
import com.academyproject.championsacademyleague.schemas.EventsOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("events")
public class eventsController {

    @Autowired
    public com.academyproject.championsacademyleague.services.EventsService EventsService;

    /**
     * Connection with angular and the exterior
     * @return
     */

/**
    @RequestMapping("getAll")
    public List<EventsOut> getAllEvents() {

    }
**/
    @RequestMapping("update")
    public List<EventsOut> getUpdateEvents(){
        EventsDataInput dataIn= new EventsDataInput();
        EventsIn eventsIn= new EventsIn("","","","");
        dataIn.getEventsIn().add(eventsIn);
        return EventsService.getAll(dataIn);

    }

    @RequestMapping("Create")
    public List<EventsOut> getCreateEvents() {
        EventsDataInput dataIn=new EventsDataInput();
        EventsIn eventsIn= new EventsIn("","","","");
        dataIn.getEventsIn().add(eventsIn);
        System.out.println(dataIn.toString());
        return EventsService.create(dataIn);
    }
/**
    @RequestMapping("delete")
    public List<EventsOut> getDeleteEvent() {


    }

    @RequestMapping("get")
    public List<EventsOut> getGetEvents() {


    }
**/
}

