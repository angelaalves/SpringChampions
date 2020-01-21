package com.academyproject.championsacademyleague.accesingdatamysql.skin;

import com.academyproject.championsacademyleague.accesingdatamysql.player.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "skin")
public class SkinController {

    @Autowired
    private SkinRepository skinRepository;

    @GetMapping(path="/getall")
    public @ResponseBody Iterable<Skin> getAllUsers() {
        // This returns a JSON or XML with the players
        return skinRepository.findAll();
    }
}
