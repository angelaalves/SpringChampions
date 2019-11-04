package com.academyproject.championsacademyleague.controllers;


import com.academyproject.championsacademyleague.schemas.VideoDataInput;
import com.academyproject.championsacademyleague.schemas.VideoInput;
import com.academyproject.championsacademyleague.schemas.VideoOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("videos")
public class videoController {

    @Autowired
    public com.academyproject.championsacademyleague.services.videoService videoService;

    /**
     * Connection with angular and the exterior
     * @return
     */

    @RequestMapping("getAll")
    public List<VideoOutput> getAllVideos() {
        VideoDataInput dataIn= new VideoDataInput();
        VideoInput videoIn= new VideoInput("","","","");
        dataIn.getVideoInput().add(videoIn);
        return videoService.getAll(dataIn);

    }

    @RequestMapping("Create")
    public List<VideoOutput> getCreateVideos(String idVideo, String videoName, String duration, String topic) {
        VideoDataInput dataIn= new VideoDataInput();
        VideoInput videoIn= new VideoInput(idVideo,videoName,duration,topic);
        dataIn.getVideoInput().add(videoIn);
        return videoService.create(dataIn);

    }

    @RequestMapping("Update")
    public List<VideoOutput> getUpdateVideos(String idVideo, String videoName, String duration, String topic) {
        VideoDataInput dataIn= new VideoDataInput();
        VideoInput videoIn= new VideoInput(idVideo,videoName,duration,topic);
        dataIn.getVideoInput().add(videoIn);
        return videoService.update(dataIn);

    }

    @RequestMapping("Delete")
    public List<VideoOutput> getDeleteVideos(String idVideo) {
        VideoDataInput dataIn = new VideoDataInput();
        VideoInput deleteID = new VideoInput(idVideo,"","","");
        dataIn.getVideoInput().add(deleteID);
        return videoService.delete(dataIn);


    }

    @RequestMapping("Get")
    public List<VideoOutput> getGetVideos(String idVideo, String videoName, String topic) {
        VideoDataInput dataIn= new VideoDataInput();
        VideoInput videoIn= new VideoInput(idVideo,videoName, "",topic);
        dataIn.getVideoInput().add(videoIn);
        return videoService.get(dataIn);

    }

}