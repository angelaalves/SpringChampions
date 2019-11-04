package com.academyproject.championsacademyleague.controllers;

import com.academyproject.championsacademyleague.schemas.*;
import com.academyproject.championsacademyleague.services.guildEventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("guildEvents")
public class guildEventsController {

    @Autowired
    public guildEventsService guildEventsService;

    /**
     * Connection with angular and the exterior
     * @return

**/

    @RequestMapping("Create")
    public List<GuildEventsOut> getCreateGuildEvents(String idGuildFK, String idEventsFK) {
        GuildEventsDataInput dataIn= new GuildEventsDataInput();
        GuildEventsIn eventsIn= new GuildEventsIn(idGuildFK,idEventsFK);
        dataIn.getGuildEventsIn().add(eventsIn);
        return guildEventsService.create(dataIn);
    }


    @RequestMapping("Delete")
    public List<GuildEventsOut> getDeleteGuildEvents(String idGuildFK, String idEventsFK) {
        GuildEventsDataInput dataIn= new GuildEventsDataInput();
        GuildEventsIn eventsIn= new GuildEventsIn(idGuildFK,idEventsFK);
        dataIn.getGuildEventsIn().add(eventsIn);
        return guildEventsService.create(dataIn);
    }

    @RequestMapping("Get")
    public List<GuildEventsOut> getGetGuildEvents(String idGuildFK, String idEventsFK) {
        GuildEventsDataInput dataIn= new GuildEventsDataInput();
        GuildEventsIn eventsIn= new GuildEventsIn(idGuildFK,idEventsFK);
        dataIn.getGuildEventsIn().add(eventsIn);
        return guildEventsService.create(dataIn);
    }


}
