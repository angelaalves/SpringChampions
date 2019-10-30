package com.academyproject.championsacademyleague.controllers;

import com.academyproject.championsacademyleague.schemas.GuildEventsOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


    @RequestMapping("Create")
    public List<GuildEventsOut> getCreateEvents() {

    }


    @RequestMapping("Delete")
    public List<GuildEventsOut> getDeleteEvent() {

    }

    @RequestMapping("Get")
    public List<GuildEventsOut> getGetEvents() {

    }
}
