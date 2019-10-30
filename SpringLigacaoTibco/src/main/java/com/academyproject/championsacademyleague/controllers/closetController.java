package com.academyproject.championsacademyleague.controllers;

import com.academyproject.championsacademyleague.schemas.ClosetDataInput;
import com.academyproject.championsacademyleague.schemas.ClosetIn;
import com.academyproject.championsacademyleague.schemas.ClosetOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public List<ClosetOut> getAllCloset() {

        ClosetDataInput dataIn= new ClosetDataInput();
        ClosetIn closetIn= new ClosetIn("","","");
        dataIn.getClosetIn().add(closetIn);
        return closetService.getAll(dataIn);

    }

    @RequestMapping("Create")
    public List<ClosetOut> getCreateCloset() {
        ClosetDataInput giving=new ClosetDataInput();
        ClosetIn closetIn=new ClosetIn("", "", "");
        giving.getClosetIn().add(closetIn);
        return closetService.create(giving);
    }

    @RequestMapping("Update")
    public List<ClosetOut> getUpdateCloset() {

    }

    @RequestMapping("Delete")
    public List<ClosetOut> getDeleteCloset() {

    }

    @RequestMapping("Get")
    public List<ClosetOut> getGetCloset() {

    }
}
