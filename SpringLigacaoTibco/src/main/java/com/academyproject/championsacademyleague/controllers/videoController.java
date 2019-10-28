package com.academyproject.championsacademyleague.controllers;


import com.academyproject.championsacademyleague.schemas.VideoDataInput;
import com.academyproject.championsacademyleague.schemas.VideoInput;
import com.academyproject.championsacademyleague.schemas.VideoOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public List<VideoOutput> getCreateVideos() {
<<<<<<< HEAD
        /**
         * Create code
         */
=======

>>>>>>> master
    }

    @RequestMapping("Update")
    public List<VideoOutput> getUpdateVideos() {
<<<<<<< HEAD
        /**
         * Update code
         */
=======

>>>>>>> master
    }

    @RequestMapping("Delete")
    public List<VideoOutput> getDeleteVideos() {
<<<<<<< HEAD
        /**
         * Delete code
         */
=======

>>>>>>> master
    }

    @RequestMapping("Get")
    public List<VideoOutput> getGetVideos() {
<<<<<<< HEAD
        /**
         * Get code
        */
=======
        
>>>>>>> master
    }

}