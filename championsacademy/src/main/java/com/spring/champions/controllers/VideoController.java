package com.spring.champions.controllers;

import com.spring.champions.schemas.DataInput;
import com.spring.champions.schemas.VideoIn;
import com.spring.champions.schemas.VideoOut;
import com.spring.champions.services.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("videos")
public class VideoController {
    @Autowired
    public VideoService videoService;

    /**
     * Connection with angular and the exterior
     * @return
     */

    @RequestMapping("getAll")
     public List<VideoOut> getAllVideos() {

        DataInput datain= new DataInput();
        VideoIn videoin= new VideoIn("1","","","");
       List<VideoIn> videoInSchema=  datain.getVideoIn();
       videoInSchema.add(videoin);
        return videoService.getAll(datain);

    }

}
