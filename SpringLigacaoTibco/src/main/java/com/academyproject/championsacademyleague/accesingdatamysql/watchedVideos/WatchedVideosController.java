package com.academyproject.championsacademyleague.accesingdatamysql.watchedVideos;

import com.academyproject.championsacademyleague.accesingdatamysql.player.Player;
import com.academyproject.championsacademyleague.accesingdatamysql.video.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/watchedVideos")
public class WatchedVideosController {

    @Autowired
    private WatchedVideosRepository watchedVideosRepository;

    private com.academyproject.championsacademyleague.accesingdatamysql.video.VideoController videoController;
    private com.academyproject.championsacademyleague.accesingdatamysql.player.PlayerController playerController;

    @GetMapping(path="/getall")
    public @ResponseBody Iterable<WatchedVideos> getAllGuildEvents() {
        return watchedVideosRepository.findAll();
    }

    @PostMapping(path="/create")
    public @ResponseBody String create(@RequestParam String idVideoFK, @RequestParam String idPlayerFK){
        Video video = (Video) videoController.getById(idVideoFK);
        Player player = (Player) playerController.getPlayerById(idPlayerFK);
        watchedVideosRepository.save(new WatchedVideos(new WatchedVideosId(video, player)));
        return "watched video created";
    }

    @GetMapping(path="/getVideoId")
    public @ResponseBody Iterable<WatchedVideos> getVideoId(@RequestParam String idVideoFK){
        return watchedVideosRepository.findByVideoId(idVideoFK);
    }

    @GetMapping(path="/getEventId")
    public @ResponseBody Iterable<WatchedVideos> getEventId(@RequestParam String idEventFK){
        return watchedVideosRepository.findByEventId(idEventFK);
    }

    @PostMapping(path="/delete")
    public @ResponseBody String delete(@RequestParam Integer idPlayerFK){
        watchedVideosRepository.deleteById(idPlayerFK);
        return "watched video deleted";
    }
}