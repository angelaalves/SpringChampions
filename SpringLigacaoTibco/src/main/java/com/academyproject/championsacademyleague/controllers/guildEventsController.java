package com.academyproject.championsacademyleague.controllers;

import com.academyproject.championsacademyleague.schemas.GuildDataInput;
import com.academyproject.championsacademyleague.schemas.GuildEventsOut;
import com.academyproject.championsacademyleague.schemas.GuildIn;
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
    public List<GuildEventsOut> getCreateEvents() {
        GuildDataInput dataIn= new GuildDataInput();
        GuildIn guildIn= new GuildIn("","","","","","");
        dataIn.getGuildIn().add(guildIn);
        return GuildService.getAll(dataIn);
    }


    @RequestMapping("Delete")
    public List<GuildEventsOut> getDeleteEvent() {

    }

    @RequestMapping("Get")
    public List<GuildEventsOut> getGetEvents() {


    }


}
