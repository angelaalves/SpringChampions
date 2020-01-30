package com.academyproject.championsacademyleague.accesingdatamysql.guildPlayers;

import com.academyproject.championsacademyleague.accesingdatamysql.guild.Guild;
import com.academyproject.championsacademyleague.accesingdatamysql.guild.GuildRepository;
import com.academyproject.championsacademyleague.accesingdatamysql.player.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path="guildPlayers")
public class GuildPlayersController {

    @Autowired
    private GuildPlayersRepository guildPlayersRepository;

    @Autowired
    private GuildRepository guildRepository;

    @GetMapping(path="/getall")
    public @ResponseBody Iterable<GuildPlayers> getAllGuildPlayers() {
        // This returns a JSON or XML with the players
        return guildPlayersRepository.findAll();
    }

    @PostMapping(path="/create")
    public @ResponseBody String createGuildPlayers(@RequestParam String idGuildMasterFK, @RequestParam String idGuildFK, @RequestParam String idWarriorFK){
        guildPlayersRepository.save(new GuildPlayers(new GuildPlayersId(new Guild(Integer.parseInt(idGuildMasterFK)), new Player(Integer.parseInt(idGuildFK)), new Player(Integer.parseInt(idWarriorFK)))));
        return "guild player created";
    }

    @PostMapping(path="/delete")
    public @ResponseBody String deleteGuildPlayer(@RequestParam Integer idGuildFK) {
        guildPlayersRepository.deleteGuildPlayer(idGuildFK);
        return "guild player deleted";
    }

    @GetMapping(path="getByGuildId")
    public @ResponseBody List<GuildPlayers> getGuildPlayerByGuildId(@RequestParam String idGuildFK) {
        return guildPlayersRepository.findGuildPlayerByGuildId(idGuildFK);
    }

    @GetMapping(path="getByGuildMaster")
    public @ResponseBody Iterable<GuildPlayers> getGuildPlayerByGuildMaster(@RequestParam Integer idGuildMasterFK) {
        return guildPlayersRepository.findAllById(Collections.singleton(idGuildMasterFK));
    }

    @GetMapping(path="getByWarrior")
    public @ResponseBody Iterable<GuildPlayers> getGuildPlayerByWarrior(@RequestParam Integer idWarriorFK) {
        return guildPlayersRepository.findAllById(Collections.singleton(idWarriorFK));
    }

    @PostMapping(path="createRecent")
    public @ResponseBody String createRecent(@RequestParam String startDate, @RequestParam String guildmaster, @RequestParam String[] players){
        Guild g=null;
        try {
            g = guildRepository.findGuildByStartDate(startDate).get(0);
        }catch(ArrayIndexOutOfBoundsException e){
            System.err.println("No guild found");
        }
        for(int i=0; i<players.length;i++){
            createGuildPlayers(guildmaster, String.valueOf(g.getIDGuild()), players[i]);
        }
        return "create recent";
    }

    @GetMapping(path="getGuildMaster")
    public @ResponseBody List<String> getGuildMaster(@RequestParam String idGuildFK){
        return guildPlayersRepository.findGuildMasterByGuildId(idGuildFK);
    }

    @GetMapping(path="getMembers")
    public @ResponseBody List<String> getMembers(@RequestParam String idGuildFK){
        return guildPlayersRepository.findPlayersByGuildId(idGuildFK);
    }
}