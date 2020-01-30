package com.academyproject.championsacademyleague.accesingdatamysql.guild;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Optional;

@Controller
@RequestMapping(path="/guilds")
public class GuildController {

    @Autowired
    private GuildRepository guildRepository;

    @GetMapping(path="/getall")
    public @ResponseBody Iterable<Guild> getAllGuilds() {
        // This returns a JSON or XML with the players
        return guildRepository.findAll();
    }

    @PostMapping(path="/create")
    public @ResponseBody String createGuild(@RequestParam String idguild,@RequestParam String guildname, @RequestParam String startdate, @RequestParam String enddate, @RequestParam String guildflag, @RequestParam String status){
        guildRepository.save(new Guild(Integer.valueOf(idguild), guildname, startdate, enddate, guildflag, status));
        return "guild created";
    }

    @PostMapping(path="/update")
    public @ResponseBody String updateGuild(@RequestParam String idguild, @RequestParam String guildname, @RequestParam String startdate, @RequestParam String enddate, @RequestParam String guildflag, @RequestParam String status){
        Optional<Guild> guild =
                guildRepository.findById(Integer.parseInt(idguild));
        guild.get().setGuildName(guildname);
        guild.get().setStartDate(startdate);
        guild.get().setEndDate(enddate);
        guild.get().setGuildFlag(guildflag);
        guild.get().setStatus(status);
        guildRepository.save(guild.get());
        return "guild updated";
    }

    @PostMapping(path="/delete")
    public @ResponseBody String deleteGuild(@RequestParam Integer idguild){
        guildRepository.deleteById(idguild);
        return "guild deleted";
    }

    @GetMapping(path="/getGuildByID")
    public @ResponseBody Guild getGuildById(@RequestParam String idguild){
      return guildRepository.findGuildByID(idguild);
    }

    @GetMapping(path="/getGuildByName")
    public @ResponseBody Iterable<Guild> getGuildByName(@RequestParam String guildname){
        return guildRepository.findGuildByName(guildname);
    }

    @GetMapping(path="/getGuildByStartDate")
    public @ResponseBody Iterable<Guild> getGuildByStartDate(@RequestParam String startdate){
        return guildRepository.findGuildByStartDate(startdate);
    }

    @GetMapping(path="/getGuildByEndDate")
    public @ResponseBody Iterable<Guild> getGuildByEndDate(@RequestParam String enddate){
        return guildRepository.findGuildByEndDate(enddate);
    }

    @GetMapping(path="/getGuildByFlag")
    public @ResponseBody Iterable<Guild> getGuildByFlag(@RequestParam String guildflag){
        return guildRepository.findGuildByFlag(guildflag);
    }

    @GetMapping(path="/getGuildByStatus")
    public @ResponseBody Iterable<Guild> getGuildByStatus(@RequestParam String status){
        return guildRepository.findGuildByStatus(status);
    }
}