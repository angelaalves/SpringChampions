package com.academyproject.championsacademyleague.accesingdatamysql.skin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/skin")
public class SkinController {

    @Autowired
    private SkinRepository skinRepository;

    @GetMapping(path="/getall")
    public @ResponseBody Iterable<Skin> getAllNotificationReceivers() {
        return skinRepository.findAll();
    }

    @PostMapping(path="/create")
    public @ResponseBody String create(@RequestParam(value = "skinname") String skinname, @RequestParam(value="imagepath") String imagepath, @RequestParam(value="minxp") String minxp, @RequestParam(value="champiescost") String champiescost, @RequestParam(value="skintype") String skintype){
        skinRepository.save(new Skin(1, skinname, imagepath,Integer.parseInt(minxp), Integer.parseInt(champiescost), skintype));
        return "skin created";
    }

    @PostMapping(path="/update")
    public @ResponseBody String update(@RequestParam String idSkin, @RequestParam String skinName, @RequestParam String imagePath, @RequestParam String minXP, @RequestParam String champiesCost, @RequestParam String skinType){
        Skin skin = skinRepository.findSkinById(Integer.parseInt(idSkin));
        skin.setSkinname(skinName);
        skin.setImagepath(imagePath);
        skin.setMinxp(Integer.parseInt(minXP));
        skin.setChampiescost(Integer.parseInt(champiesCost));
        skin.setSkintype(skinType);
        skinRepository.save(skin);
        return "skin updated";
    }

    @GetMapping(path="/getById")
    public @ResponseBody Skin getSkinById(@RequestParam String idSkin){
        return skinRepository.findSkinById(Integer.parseInt(idSkin));
    }

    @GetMapping(path="/getBySkinName")
    public @ResponseBody Iterable<Skin> getSkinByName(@RequestParam String skinName){
        return skinRepository.findSkinByName(skinName);
    }

    @GetMapping(path="/getByImagePath")
    public @ResponseBody Iterable<Skin> getSkinByImagePath(@RequestParam String imagePath){
        return skinRepository.findSkinByImagePath(imagePath);
    }

    @GetMapping(path="/getByMinXp")
    public @ResponseBody Iterable<Skin> getSkinByMinXp(@RequestParam String minXp){
        return skinRepository.findSkinByMinXp(minXp);
    }

    @GetMapping(path="/getByChampiesCost")
    public @ResponseBody Iterable<Skin> getSkinByChampiesCost(@RequestParam String champiesCost){
        return skinRepository.findSkinByChampiesCost(champiesCost);
    }

    @GetMapping(path="/getBySkinType")
    public @ResponseBody Iterable<Skin> getSkinBySkinType(@RequestParam String skinType){
        return skinRepository.findSkinBySkinType(skinType);
    }

    @PostMapping(path="/delete")
    public @ResponseBody String delete(@RequestParam String idSkin){
        skinRepository.deleteById(Integer.parseInt(idSkin));
        return "skin deleted";
    }

    @GetMapping(path="getSkinList")
    public @ResponseBody Iterable<Skin> getSkinList(@RequestParam String[] skinsIds){
        List<Skin> skinList = new ArrayList<>();
        for(int i=0; i<=skinsIds.length-1; i++){
            Skin skin = (Skin) skinRepository.findSkinById(Integer.parseInt(skinsIds[i]));
            skinList.add(skin);
        }
        return skinList;
    }
}