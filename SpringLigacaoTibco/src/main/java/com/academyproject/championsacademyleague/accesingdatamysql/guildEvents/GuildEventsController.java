package com.academyproject.championsacademyleague.accesingdatamysql.guildEvents;

import com.academyproject.championsacademyleague.accesingdatamysql.player.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*@Controller
@RequestMapping(path= "guildEvents")
public class GuildEventsController {

    @Autowired
    private GuildEventsRepository guildEventsRepository;
    @GetMapping(path="/getall")
    public @ResponseBody Iterable<GuildEvents> getAllGuildEvents() {
        // This returns a JSON or XML with the players
        return guildEventsRepository.findAll();
    }
}*/
