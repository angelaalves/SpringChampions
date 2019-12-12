package com.academyproject.championsacademyleague.controllers;

import com.academyproject.championsacademyleague.schemas.*;
import com.academyproject.championsacademyleague.services.closetService;
import com.academyproject.championsacademyleague.services.skinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.MediaSize;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("closet")

public class closetController {

    @Autowired
    public closetService closetService;
    @Autowired
    public skinService skinService;


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
        return closetService.update(giving);
    }

    @RequestMapping("Delete")
    public List<ClosetOut> getDeleteCloset(String idSkinFK, String idPlayerFk) {
        ClosetDataInput giving=new ClosetDataInput();
        ClosetIn closetIn=new ClosetIn(idSkinFK, idPlayerFk, "");
        giving.getClosetIn().add(closetIn);
        return closetService.delete(giving);
    }

    @RequestMapping("Get")
    public List<ClosetOut> getGetCloset(String idSkinFK, String idPlayerFk, String status) {
        ClosetDataInput giving=new ClosetDataInput();
        ClosetIn closetIn=new ClosetIn(idSkinFK, idPlayerFk, status);
        giving.getClosetIn().add(closetIn);
        return closetService.get(giving);
    }

    @RequestMapping("activeSkins")
    public List<String> getActiveSkin(String idPlayerFK){
        List<String> activeSkinResults=new ArrayList<String>();
        String hair=null;
        String skinColor=null;
        String top=null;
        String bottom=null;
        String shoes=null;
        String others=null;
        ClosetDataInput search=new ClosetDataInput();
        ClosetIn closetIn=new ClosetIn("", idPlayerFK, "");
        search.getClosetIn().add(closetIn);
        List<ClosetOut> results=closetService.get(search);
        for(int i=0; i<results.size(); i++){
            if(results.get(i).getStatus().equals("Active")) {
                SkinDataInput searchSkin = new SkinDataInput();
                SkinIn skinIn = new SkinIn(results.get(i).getIDSkinFK(), "", "", "", "", "");
                searchSkin.getSkinIn().add(skinIn);
                switch (skinService.get(searchSkin).get(0).getSkinType()){
                    case "Hair":
                        hair=skinService.get(searchSkin).get(0).getImagePath();
                        break;
                    case "SkinColor":
                        skinColor=skinService.get(searchSkin).get(0).getImagePath();
                        break;
                    case "Top":
                        top=skinService.get(searchSkin).get(0).getImagePath();
                        break;
                    case "Bottom":
                        bottom=skinService.get(searchSkin).get(0).getImagePath();
                        break;
                    case "Shoes":
                        shoes=skinService.get(searchSkin).get(0).getImagePath();
                        break;
                    case "Others":
                        others=skinService.get(searchSkin).get(0).getImagePath();
                        break;
                    default:
                        break;
                }
            }
        }
        activeSkinResults.add(hair);
        activeSkinResults.add(skinColor);
        activeSkinResults.add(top);
        activeSkinResults.add(bottom);
        activeSkinResults.add(shoes);
        activeSkinResults.add(others);
        return activeSkinResults;
    }
}