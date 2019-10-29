package com.academyproject.championsacademyleague.controllers;


import com.academyproject.championsacademyleague.schemas.GuildDataInput;
import com.academyproject.championsacademyleague.schemas.GuildIn;
import com.academyproject.championsacademyleague.schemas.GuildOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.DataInput;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("guild")
public class guildController {
    @Autowired
    public com.academyproject.championsacademyleague.services.GuildService GuildService;

    /**
     * Connection with angular and the exterior
     * @return
     */

    @RequestMapping("getAll")
    public List<GuildOut> getAllCloset() {

        GuildDataInput dataIn= new GuildDataInput();
        GuildIn guildIn= new GuildIn("","","","","","");
        dataIn.getGuildIn().add(guildIn);
        return GuildService.getAll(dataIn);

    }

    @RequestMapping("Create")
    public List<GuildOut> getCreateGuild() {

    }

    @RequestMapping("Update")
    public List<GuildOut> getUpdateGuild() {

    }

    @RequestMapping("Delete")
    public List<GuildOut> getDeleteGuild() {

    }

    @RequestMapping("Get")
    public List<GuildOut> getGetGuild() {

    }
}
