package com.academyproject.championsacademyleague.accesingdatamysql.video;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@Controller
@RequestMapping(path="/video")
public class VideoController {
    @Autowired
    private VideoRepository videoRepository;

    @GetMapping(path="/getall")
    public @ResponseBody
    Iterable<Video> getAllGuildEvents() {
        return videoRepository.findAll();
    }

    @PostMapping(path="/create")
    public @ResponseBody String create(@RequestParam String idVideo, @RequestParam String videoName, @RequestParam String duration, @RequestParam String topic){
        videoRepository.save(new Video(Integer.parseInt(idVideo), videoName, Integer.parseInt(duration), topic));
        return "video created";
    }

    @PostMapping(path="/update")
    public @ResponseBody String update(@RequestParam String idVideo, @RequestParam String videoName, @RequestParam String duration, @RequestParam String topic){
        Video video = (Video) videoRepository.findAllById(Collections.singleton(Integer.parseInt(idVideo)));
        video.setVideoName(videoName);
        video.setDuration(Integer.parseInt(duration));
        video.setTopic(topic);
        videoRepository.save(video);
        return "video updated";
    }

    @PostMapping(path="/delete")
    public @ResponseBody String delete(@RequestParam String idVideo){
        videoRepository.delete((Video) videoRepository.findAllById(Collections.singleton(Integer.parseInt(idVideo))));
        return "video deleted";
    }

    @GetMapping(path="/getById")
    public @ResponseBody Iterable<Video> getById(@RequestParam String idVideo){
        return videoRepository.findAllById(Collections.singleton(Integer.parseInt(idVideo)));
    }

    @GetMapping(path="/getByVideoName")
    public @ResponseBody Iterable<Video> getByVideoName(@RequestParam String videoName){
        return videoRepository.findByVideoName(videoName);
    }

    @GetMapping(path="/getByTopic")
    public @ResponseBody Iterable<Video> getByTopic(@RequestParam String topic){
        return videoRepository.findByTopic(topic);
    }
}