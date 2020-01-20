package com.academyproject.championsacademyleague.accesingdatamysql.guildPlayers;

import com.academyproject.championsacademyleague.accesingdatamysql.player.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*@Controller
@RequestMapping(path="guildPlayers")
public class GuildPlayersController {

    @Autowired
    private GuildPlayersRepository guildPlayersRepository;
    @GetMapping(path="/getall")
    public @ResponseBody Iterable<GuildPlayers> getAllGuildPlayers() {
        // This returns a JSON or XML with the players
        return guildPlayersRepository.findAll();
    }
}*/
