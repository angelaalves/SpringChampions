package com.academyproject.championsacademyleague.controllers;


import com.academyproject.championsacademyleague.schemas.GuildEventsDataInput;
import com.academyproject.championsacademyleague.schemas.GuildEventsIn;
import com.academyproject.championsacademyleague.schemas.GuildEventsOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.DataInput;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("guildEvents")
public class guildEventsController {

    @Autowired
    public com.academyproject.championsacademyleague.services.GuildEventsService GuildEventsService;

    /**
     * Connection with angular and the exterior
     * @return
     */

    @RequestMapping("getAll")
    public List<GuildEventsOut> getAllEvents() {

        GuildEventsDataInput dataIn= new GuildEventsDataInput();
        GuildEventsIn GuildEventsIn= new GuildEventsIn("","");
        dataIn.getGuildEventsIn().add(GuildEventsIn);
        return GuildEventsService.getAll(dataIn);

    }

    @RequestMapping("Create")
    public List<GuildEventsOut> getCreateEvents() {

    }

    @RequestMapping("Update")
    public List<GuildEventsOut> getUpdateEvents() {

    }

    @RequestMapping("Delete")
    public List<GuildEventsOut> getDeleteEvent() {

    }

    @RequestMapping("Get")
    public List<GuildEventsOut> getGetEvents() {

    }
}
