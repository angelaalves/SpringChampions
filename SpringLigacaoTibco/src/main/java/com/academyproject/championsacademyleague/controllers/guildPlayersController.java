package com.academyproject.championsacademyleague.controllers;

import com.academyproject.championsacademyleague.schemas.*;
import com.academyproject.championsacademyleague.services.guildService;
import com.academyproject.championsacademyleague.services.playerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("guildPlayers")
public class guildPlayersController {

    @Autowired
    public com.academyproject.championsacademyleague.services.guildPlayersService guildPlayersService;
    @Autowired
    public guildService guildService;


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

    @RequestMapping("createRecent")
    public void createRecent(String startDate, String guildmaster, String[] players){
        GuildDataInput dataIn= new GuildDataInput();
        GuildIn guildIn= new GuildIn("","",startDate,"","","");
        dataIn.getGuildIn().add(guildIn);
        List<GuildOut> guild=guildService.get(dataIn);
        String idGuild=guild.get(guild.size()-1).getIDGuild();
        for(int i=0; i<players.length;i++){
            getCreateGuildPlayers(guildmaster, idGuild, players[i]);
        }
    }
    @RequestMapping("getGuildMaster")
    public String getGuildMaster(String idGuild){
        List<GuildPlayersOut> playerList=getGetGuildPlayers("", idGuild, "");
        return playerList.get(0).getIDGuildMasterFK();
    }
    @RequestMapping("getMembers")
    public List<String> getMembers(String idGuild){
        List<GuildPlayersOut> playerList=getGetGuildPlayers("", idGuild, "");
        List<String> ids=new ArrayList<>();
        for(GuildPlayersOut id: playerList){
            ids.add(id.getIDWarriorFK());
        }
        return ids;
    }
}
