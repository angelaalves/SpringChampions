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

    @RequestMapping("create")
    public List<EventsOut> getCreateEvents() {


    }

    @RequestMapping("update")
    public List<EventsOut> getUpdateEvents() {


    }

    @RequestMapping("delete")
    public List<EventsOut> getDeleteEvent() {


    }

    @RequestMapping("get")
    public List<EventsOut> getGetEvents() {


    }
**/
}

