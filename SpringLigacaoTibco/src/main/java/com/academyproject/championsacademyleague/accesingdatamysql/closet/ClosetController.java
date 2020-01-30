package com.academyproject.championsacademyleague.accesingdatamysql.closet;

import com.academyproject.championsacademyleague.accesingdatamysql.player.Player;
import com.academyproject.championsacademyleague.accesingdatamysql.skin.Skin;
import com.academyproject.championsacademyleague.accesingdatamysql.skin.SkinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.assertj.core.util.Lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping(path="/closet")
public class ClosetController {

    @Autowired
    private ClosetRepository closetRepository;

    @Autowired
    private SkinRepository skinRepository;

    private com.academyproject.championsacademyleague.accesingdatamysql.skin.SkinController skinController;
    private com.academyproject.championsacademyleague.accesingdatamysql.player.PlayerController playerController;

    @PostMapping(path="/create")
    public @ResponseBody String createCloset(@RequestParam String idskinfk, @RequestParam String idplayerfk, @RequestParam String status){
        Player player = (Player) playerController.getPlayerById(idplayerfk);
        Skin skin = (Skin) skinController.getSkinById(idskinfk);
        closetRepository.save(new Closet((new ClosetId(skin, player)), status));
        return "create closet";
    }

    @PostMapping(path="/update")
    public @ResponseBody String updateCloset(@RequestParam String idskinfk, @RequestParam String idplayerfk, @RequestParam String status){
        Closet result = closetRepository.findSkinByPlayerId(idskinfk, idplayerfk);
        result.setStatus(status);
        closetRepository.save(result);
        return "update closet";
    }

    @PostMapping(path="/deleteByIdPlayer")
    public @ResponseBody String deleteClosetByPlayerID(@RequestParam String idplayerfk){
        closetRepository.deleteById(Integer.parseInt(idplayerfk));
        return "delete closet by player id";
    }

    @PostMapping(path="/deleteByIdSkin")
    public @ResponseBody String deleteClosetBySkinID(@RequestParam String idskinfk){
        closetRepository.deleteById(Integer.parseInt(idskinfk));
        return "delete closet by skin id";
    }

    @PostMapping(path="/delete")
    public @ResponseBody String deleteCloset(@RequestParam String idskinfk, @RequestParam String idplayerfk){
        Closet result=closetRepository.findSkinByPlayerId(idskinfk, idplayerfk);
        closetRepository.delete(result);
        return "delete closet";
    }

    @GetMapping(path="/getByClosetIdSkin")
    public @ResponseBody Iterable<Closet> getClosetBySkinId(@RequestParam String idskinfk){
        return closetRepository.findAllById(Collections.singleton(Integer.parseInt(idskinfk)));
    }

    @GetMapping(path="/getByClosetIdPlayerID")
    public @ResponseBody Iterable<Closet> getClosetByPlayerId(@RequestParam String idplayerfk){
        return closetRepository.findAllById(Collections.singleton(Integer.parseInt(idplayerfk)));
    }

    @GetMapping(path="/getClosetByStatus")
    public @ResponseBody Iterable<Closet> getClosetByStatus(@RequestParam String status){
        return closetRepository.findClosetByStatus(status);
    }

    @GetMapping(path="/getall")
    public @ResponseBody Iterable<Closet> getAllCloset() {
        return closetRepository.findAll();
    }

    @PostMapping(path="/changeStatusSkins")
    public @ResponseBody String changeStatusSkins(@RequestParam String[] idSkins, @RequestParam String idPlayer, @RequestParam  String status){
        for(int i=0; i<idSkins.length; i++){
            Closet closet=closetRepository.findSkinByPlayerId(idSkins[i], idPlayer);
            closet.setStatus(status);
            closetRepository.save(closet);
        }
        return "change status skins";
    }

    @GetMapping(path="activeSkins")
    public @ResponseBody Iterable<String> getActiveSkins(@RequestParam String idplayerfk){
        List<String> activeSkinResults=new ArrayList<String>();
        String hair=null;
        String skinColor=null;
        String top=null;
        String bottom=null;
        String shoes=null;
        String others=null;
        List<Closet> results = Lists.newArrayList(closetRepository.findClosetById(idplayerfk));
        for(int i=0; i<results.size(); i++) {
            if (results.get(i).getStatus().equals("Active")) {
                List<Skin> getAllById = Lists.newArrayList(skinRepository.findAllById((Iterable<Integer>) results.get(i).getId()));
                switch (getAllById.get(i).getSkintype()){
                    case "Hair":
                        hair=getAllById.get(i).getImagepath();
                        break;
                    case "SkinColor":
                        skinColor=getAllById.get(i).getImagepath();
                        break;
                    case "Top":
                        top=getAllById.get(i).getImagepath();
                        break;
                    case "Bottom":
                        bottom=getAllById.get(i).getImagepath();
                        break;
                    case "Shoes":
                        shoes=getAllById.get(i).getImagepath();
                        break;
                    case "Others":
                        others=getAllById.get(i).getImagepath();
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