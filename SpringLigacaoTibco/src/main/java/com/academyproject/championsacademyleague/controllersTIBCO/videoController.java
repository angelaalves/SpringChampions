package com.academyproject.championsacademyleague.controllersTIBCO;


import com.academyproject.championsacademyleague.schemas.VideoDataInput;
import com.academyproject.championsacademyleague.schemas.videoInput;
import com.academyproject.championsacademyleague.schemas.videoOutput;
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
    public List<videoOutput> getAllVideos() {
        VideoDataInput dataIn= new VideoDataInput();
        videoInput videoIn= new videoInput("","","","");
        dataIn.getVideoInput().add(videoIn);
        return videoService.getAll(dataIn);

    }

    @RequestMapping("Create")
    public List<videoOutput> getCreateVideos(String idVideo, String videoName, String duration, String topic) {
        VideoDataInput dataIn= new VideoDataInput();
        videoInput videoIn= new videoInput(idVideo,videoName,duration,topic);
        dataIn.getVideoInput().add(videoIn);
        return videoService.create(dataIn);

    }

    @RequestMapping("Update")
    public List<videoOutput> getUpdateVideos(String idVideo, String videoName, String duration, String topic) {
        VideoDataInput dataIn= new VideoDataInput();
        videoInput videoIn= new videoInput(idVideo,videoName,duration,topic);
        dataIn.getVideoInput().add(videoIn);
        return videoService.update(dataIn);

    }

    @RequestMapping("Delete")
    public List<videoOutput> getDeleteVideos(String idVideo) {
        VideoDataInput dataIn = new VideoDataInput();
        videoInput deleteID = new videoInput(idVideo,"","","");
        dataIn.getVideoInput().add(deleteID);
        return videoService.delete(dataIn);


    }

    @RequestMapping("Get")
    public List<videoOutput> getGetVideos(String idVideo, String videoName, String topic) {
        VideoDataInput dataIn= new VideoDataInput();
        videoInput videoIn= new videoInput(idVideo,videoName, "",topic);
        dataIn.getVideoInput().add(videoIn);
        return videoService.get(dataIn);

    }

}