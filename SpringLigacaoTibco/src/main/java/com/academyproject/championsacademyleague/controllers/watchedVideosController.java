package com.academyproject.championsacademyleague.controllers;

import com.academyproject.championsacademyleague.schemas.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("watchedVideos")
public class watchedVideosController {

    @Autowired
    public com.academyproject.championsacademyleague.services.watchedVideosService watchedVideosService;

    /**
     * Connection with angular and the exterior
     * @return
     */

    @RequestMapping("getAll")
    public List<WatchedVideosOut> getAllWatchedVideos() {

        WatchedVideosDataInput dataIn= new WatchedVideosDataInput();
        WatchedVideosIn watchedVideosIn= new WatchedVideosIn("","");
        dataIn.getWatchedVideosIn().add(watchedVideosIn);
        return watchedVideosService.getAll(dataIn);

    }
/**
    @RequestMapping("Create")
    public List<WatchedVideosOut> getCreateWatchedVideos() {

    }

    @RequestMapping("Get")
    public List<WatchedVideosOut> getGetWatchedVideos() {

    }

    @RequestMapping("Delete")
    public List<WatchedVideosOut> getDeleteWatchedVideos() {

    }
**/

}
