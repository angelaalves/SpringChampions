package com.academyproject.championsacademyleague.controllers;


import com.academyproject.championsacademyleague.schemas.GuildDataInput;
import com.academyproject.championsacademyleague.schemas.GuildIn;
import com.academyproject.championsacademyleague.schemas.GuildOut;
import com.academyproject.championsacademyleague.services.guildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("guild")
public class guildController {
    @Autowired
    public guildService guildService;

    /**
     * Connection with angular and the exterior
     * @return
     */

    @RequestMapping("getAll")
    public List<GuildOut> getAllGuilds() {
        GuildDataInput dataIn= new GuildDataInput();
        GuildIn guildIn= new GuildIn("","","","","","");
        dataIn.getGuildIn().add(guildIn);
        return guildService.getAll(dataIn);

    }

    @RequestMapping("Create")
    public List<GuildOut> getCreateGuild(String guildName, String startDate, String endDate, String guildFlag,String status) {
        GuildDataInput dataIn= new GuildDataInput();
        GuildIn guildIn= new GuildIn("",guildName,startDate,endDate,guildFlag,status);
        dataIn.getGuildIn().add(guildIn);
        return guildService.create(dataIn);

    }

    @RequestMapping("Update")
    public List<GuildOut> getUpdateGuild(String idGuild, String guildName, String startDate, String endDate, String guildFlag,String status) {
        GuildDataInput dataIn= new GuildDataInput();
        GuildIn guildIn= new GuildIn(idGuild,guildName,startDate,endDate,guildFlag,status);
        dataIn.getGuildIn().add(guildIn);
        return guildService.update(dataIn);

    }

    @RequestMapping("Delete")
    public List<GuildOut> getDeleteGuild(String idGuild) {
        GuildDataInput dataIn= new GuildDataInput();
        GuildIn guildIn= new GuildIn(idGuild,"","","","","");
        dataIn.getGuildIn().add(guildIn);
        return guildService.delete(dataIn);

    }

    @RequestMapping("Get")
    public List<GuildOut> getGetGuild(String idGuild, String guildName, String startDate, String endDate, String guildFlag,String status) {
        GuildDataInput dataIn= new GuildDataInput();
        GuildIn guildIn= new GuildIn(idGuild,guildName,startDate,endDate,guildFlag,status);
        dataIn.getGuildIn().add(guildIn);
        return guildService.get(dataIn);
    }


}