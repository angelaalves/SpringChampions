package com.academyproject.championsacademyleague.controllers;

import com.academyproject.championsacademyleague.schemas.ClosetDataInput;
import com.academyproject.championsacademyleague.schemas.ClosetIn;
import com.academyproject.championsacademyleague.schemas.ClosetOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.DataInput;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("closet")

public class closetController {

    @Autowired
    public com.academyproject.championsacademyleague.services.closetService closetService;

    /**
     * Connection with angular and the exterior
     * @return
     */

    @RequestMapping("getAll")
    public List<ClosetOut> getAllVideos() {

        ClosetDataInput dataIn= new ClosetDataInput();
        ClosetIn closetIn= new ClosetIn("","","");
        dataIn.getClosetIn().add(closetIn);
        return closetService.getAll(dataIn);

    }

    @RequestMapping("Create")
    public List<ClosetOut> getCreateVideos() {

    }

    @RequestMapping("Update")
    public List<ClosetOut> getUpdateVideos() {

    }

    @RequestMapping("Delete")
    public List<ClosetOut> getDeleteVideos() {

    }

    @RequestMapping("Get")
    public List<ClosetOut> getGetVideos() {

    }
}
