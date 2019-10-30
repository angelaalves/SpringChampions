package com.academyproject.championsacademyleague.controllers;

import com.academyproject.championsacademyleague.schemas.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("skins")
public class skinController {

    @Autowired
    public com.academyproject.championsacademyleague.services.skinService skinService;

    /**
     * Connection with angular and the exterior
     * @return
     */

    @RequestMapping("getAll")
    public List<SkinOut> getAllSkins() {

        SkinDataInput dataIn= new SkinDataInput();
        SkinIn skinIn= new SkinIn("","","","","","");
        dataIn.getSkinIn().add(skinIn);
        return skinService.getAll(dataIn);

    }

    @RequestMapping("Create")
    public List<SkinOut> getCreateSkins() {

    }

    @RequestMapping("Update")
    public List<SkinOut> getUpdateSkins() {

    }

    @RequestMapping("Get")
    public List<SkinOut> getGetSkin() {

    }

    @RequestMapping("Delete")
    public List<SkinOut> getDeleteSkin() {

    }


}
