package com.academyproject.championsacademyleague.accesingdatamysql.watchedVideos;

import com.academyproject.championsacademyleague.accesingdatamysql.player.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "watchedVideos")
public class WatchedVideosController {

    @Autowired
    private WatchedVideosRepository watchedVideosRepository;

    @GetMapping(path="/getall")
    public @ResponseBody
    Iterable<WatchedVideos> getAllUsers() {
        // This returns a JSON or XML with the players
        return watchedVideosRepository.findAll();
    }
}
