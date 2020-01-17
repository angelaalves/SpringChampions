package com.academyproject.championsacademyleague.accesingdatamysql.guild;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



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
}
