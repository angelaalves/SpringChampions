package com.academyproject.championsacademyleague.controllers;

import com.academyproject.championsacademyleague.schemas.*;
import com.academyproject.championsacademyleague.services.playerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("guildPlayers")
public class guildPlayersController {

    @Autowired
    public com.academyproject.championsacademyleague.services.guildPlayersService guildPlayersService;

    @Autowired
    public com.academyproject.championsacademyleague.services.playerService playerService;


    /**
     * Connection with angular and the exterior
     * @return
     */

    @RequestMapping("getAll")
    public List<GuildPlayersOut> getAllGuildPlayers() {
        GuildPlayersDataInput dataIn= new GuildPlayersDataInput();
        GuildPlayersIn guildPlayersIn= new GuildPlayersIn("","","");
        dataIn.getGuildPlayersIn().add(guildPlayersIn);
        return guildPlayersService.getAll(dataIn);

    }

    @RequestMapping("Create")
    public List<GuildPlayersOut> getCreateGuildPlayers(String idGuildMasterFK, String idGuildFK, String idWarriorFK) {
        GuildPlayersDataInput dataIn= new GuildPlayersDataInput();
        GuildPlayersIn guildPlayersIn= new GuildPlayersIn(idGuildMasterFK, idGuildFK, idWarriorFK);
        dataIn.getGuildPlayersIn().add(guildPlayersIn);
        return guildPlayersService.create(dataIn);

    }
    @RequestMapping("Delete")
    public List<GuildPlayersOut> getDeleteGuildPlayer(String idGuildFK) {
        GuildPlayersDataInput dataIn= new GuildPlayersDataInput();
        GuildPlayersIn guildPlayersIn= new GuildPlayersIn("",idGuildFK,"");
        dataIn.getGuildPlayersIn().add(guildPlayersIn);
        return guildPlayersService.delete(dataIn);

    }

    @RequestMapping("Get")
    public List<GuildPlayersOut> getGetGuildPlayers(String idGuildMasterFK, String idGuildFK, String idWarriorFK) {
        GuildPlayersDataInput dataIn = new GuildPlayersDataInput();
        GuildPlayersIn guildPlayersIn = new GuildPlayersIn(idGuildMasterFK, idGuildFK, idWarriorFK);
        dataIn.getGuildPlayersIn().add(guildPlayersIn);
        return guildPlayersService.get(dataIn);
    }
}
