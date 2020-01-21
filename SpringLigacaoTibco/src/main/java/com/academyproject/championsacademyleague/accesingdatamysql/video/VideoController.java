package com.academyproject.championsacademyleague.accesingdatamysql.video;

import com.academyproject.championsacademyleague.accesingdatamysql.player.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "video")
public class VideoController {

    @Autowired
    private VideoRepository videoRepository;

    @GetMapping(path="/getall")
    public @ResponseBody Iterable<Video> getAllUsers() {
        // This returns a JSON or XML with the players
        return videoRepository.findAll();
    }
}
