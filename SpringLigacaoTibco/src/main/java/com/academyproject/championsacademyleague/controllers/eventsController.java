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

    @RequestMapping("getAll")
    public List<EventsOut> getAllEvents() {

        EventsDataInput dataIn= new EventsDataInput();
        EventsIn eventsIn= new EventsIn("","","","");
        dataIn.getEventsIn().add(eventsIn);
        return EventsService.getAll(dataIn);

    }

    @RequestMapping("create")
    public List<EventsOut> getCreateEvents() {

        EventsDataInput dataIn= new EventsDataInput();
        EventsIn createIn= new EventsIn("","","","");
        dataIn.getEventsIn().add(createIn);
        return EventsService.create(dataIn);

    }

    @RequestMapping("update")
    public List<EventsOut> getUpdateEvents() {

        EventsDataInput dataIn= new EventsDataInput();
        EventsIn updateIn= new EventsIn("","","","");
        dataIn.getEventsIn().add(updateIn);
        return EventsService.update(dataIn);

    }

    @RequestMapping("delete")
    public List<EventsOut> getDeleteEvent() {

        EventsDataInput dataIn= new EventsDataInput();
        EventsIn deleteIn= new EventsIn("","","","");
        dataIn.getEventsIn().add(deleteIn);
        return EventsService.delete(dataIn);

    }

    @RequestMapping("get")
    public List<EventsOut> getGetEvents() {

        EventsDataInput dataIn= new EventsDataInput();
        EventsIn getIn= new EventsIn("","","","");
        dataIn.getEventsIn().add(getIn);
        return EventsService.get(dataIn);

    }

}

