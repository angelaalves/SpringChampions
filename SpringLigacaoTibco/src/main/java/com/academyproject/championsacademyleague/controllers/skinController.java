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
        SkinIn skinIn= new SkinIn("","","", "", "","");
        dataIn.getSkinIn().add(skinIn);
        return skinService.getAll(dataIn);

    }

    @RequestMapping("Create")
    public List<SkinOut> getCreateSkins(String idSkin, String skinName, String imagePath, String minXP, String champiesCost, String skinType) {

        SkinDataInput dataIn = new SkinDataInput();
        SkinIn createIn = new SkinIn(idSkin, skinName, imagePath, minXP, champiesCost, skinType);
        dataIn.getSkinIn().add(createIn);
        return skinService.create(dataIn);
    }

    @RequestMapping("Create")
    public List<SkinOut> getCreateSkins(String skinName, String imagePath, String minXP, String champiesCost, String skinType) {
        SkinDataInput dataIn=new SkinDataInput();
        SkinIn skinIn=new SkinIn("",skinName, imagePath, minXP, champiesCost, skinType);
        dataIn.getSkinIn().add(skinIn);
        return skinService.create(dataIn);
    }

    @RequestMapping("Update")
    public List<SkinOut> getUpdateSkins(String idSkin, String skinName, String imagePath, String minXP, String champiesCost, String skinType) {
        SkinDataInput dataIn = new SkinDataInput();
        SkinIn updateIn= new SkinIn(idSkin, skinName, imagePath, minXP, champiesCost, skinType);
        dataIn.getSkinIn().add(updateIn);
        return skinService.update(dataIn);

    }

    @RequestMapping("Get")
    public List<SkinOut> getGetSkin(String idSkin, String skinName, String imagePath, String minXP, String champiesCost, String skinType) {
        SkinDataInput dataIn = new SkinDataInput();
        SkinIn getIn= new SkinIn(idSkin, skinName, imagePath, minXP, champiesCost, skinType);
        dataIn.getSkinIn().add(getIn);
        return skinService.get(dataIn);

    }

    @RequestMapping("Delete")
    public List<SkinOut> getDeleteSkin(String idSkin) {
        SkinDataInput dataIn = new SkinDataInput();
        SkinIn deleteIn= new SkinIn(idSkin,"","","","","");
        dataIn.getSkinIn().add(deleteIn);
        return skinService.delete(dataIn);

    }

}
