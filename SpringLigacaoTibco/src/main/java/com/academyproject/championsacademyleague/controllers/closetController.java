package com.academyproject.championsacademyleague.controllers;

import com.academyproject.championsacademyleague.schemas.ClosetDataInput;
import com.academyproject.championsacademyleague.schemas.ClosetIn;
import com.academyproject.championsacademyleague.schemas.ClosetOut;
import com.academyproject.championsacademyleague.services.closetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("closet")

public class closetController {

    @Autowired
    public closetService closetService;

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
    public List<ClosetOut> getCreateCloset(String idSkinFK, String idPlayerFk, String status) {
        ClosetDataInput giving=new ClosetDataInput();
        ClosetIn closetIn=new ClosetIn(idSkinFK, idPlayerFk, status);
        giving.getClosetIn().add(closetIn);
        return closetService.create(giving);
    }
    @RequestMapping("Update")
    public List<ClosetOut> getUpdateCloset(String idSkinFK, String idPlayerFk, String status) {
        ClosetDataInput giving=new ClosetDataInput();
        ClosetIn closetIn=new ClosetIn(idSkinFK, idPlayerFk, status);
        giving.getClosetIn().add(closetIn);
        return closetService.create(giving);
    }

    @RequestMapping("Delete")
    public List<ClosetOut> getDeleteCloset(String idSkinFK, String idPlayerFk) {
        ClosetDataInput giving=new ClosetDataInput();
        ClosetIn closetIn=new ClosetIn(idSkinFK, idPlayerFk, "");
        giving.getClosetIn().add(closetIn);
        return closetService.create(giving);
    }

    @RequestMapping("Get")
    public List<ClosetOut> getGetCloset(String idSkinFK, String idPlayerFk, String status) {
        ClosetDataInput giving=new ClosetDataInput();
        ClosetIn closetIn=new ClosetIn(idSkinFK, idPlayerFk, status);
        giving.getClosetIn().add(closetIn);
        return closetService.create(giving);
    }


}
