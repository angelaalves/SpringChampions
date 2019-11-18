package com.academyproject.championsacademyleague.controllers;

import com.academyproject.championsacademyleague.constants.Time;
import com.academyproject.championsacademyleague.schemas.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("players")
public class playerController {

    @Autowired
    public com.academyproject.championsacademyleague.services.playerService playerService;
    @Autowired
    public com.academyproject.championsacademyleague.services.rewardsService rewardService;

    /**
     * Connection with angular and the exterior
     * @return
     */

    @RequestMapping("getAll")
    public List<PlayerOut> getAllPlayers() {

        PlayerDataInput dataIn= new PlayerDataInput();
        PlayerIn playerIn= new PlayerIn("","","","","","","","","","","");
        dataIn.getPlayerIn().add(playerIn);
        return playerService.getAll(dataIn);

    }

    @RequestMapping("Create")
        public List<PlayerOut> getCreatePlayers(String idPlayer, String idGuildFK, String userName, String email, String password, String gender, String userType, String xp, String champiesToGive, String myChampies, String status) {

        PlayerDataInput dataIn= new PlayerDataInput();
        PlayerIn playerIn= new PlayerIn(idPlayer, idGuildFK, userName, email, password, gender, userType, xp, champiesToGive, myChampies, status);
        dataIn.getPlayerIn().add(playerIn);
        return playerService.create(dataIn);

    }

    @RequestMapping("Update")
    public List<PlayerOut> getUpdatePlayers(String idPlayer, String idGuildFK, String userName, String email, String password, String gender, String userType, String xp, String champiesToGive, String myChampies, String status) {
        PlayerDataInput dataIn= new PlayerDataInput();
        PlayerIn playerIn= new PlayerIn(idPlayer, idGuildFK, userName, email, password, gender, userType, xp, champiesToGive, myChampies, status);
        dataIn.getPlayerIn().add(playerIn);
        return playerService.update(dataIn);

    }

    @RequestMapping("Get")
    public List<PlayerOut> getGetPlayers(String idPlayer, String idGuildFK, String userName, String email, String password, String gender, String userType, String xp, String champiesToGive, String myChampies, String status) {
        PlayerDataInput dataIn= new PlayerDataInput();
        PlayerIn playerIn= new PlayerIn(idPlayer, idGuildFK, userName, email, password, gender, userType, xp, champiesToGive, myChampies, status);
        dataIn.getPlayerIn().add(playerIn);
        return playerService.get(dataIn);
    }
    @RequestMapping("Login")
    public PlayerOut verifyLogin(@RequestParam String email, @RequestParam String password){
        List<PlayerOut> info=getGetPlayers("", "", email, email, "", "", "", "", "", "", "");
        if(info.get(0).getPassword().equals(password)){
            System.out.println(info.get(0).getPassword());
            return info.get(0);
        }
        return new PlayerOut();
    }

    @RequestMapping("Reward")
    public boolean rewardPlayer(String playerGiver, String playerReceiver, String time){
        rewardService.registry(playerGiver, playerReceiver, Time.valueOf(time));
        return playerService.giveChampies(playerGiver, playerReceiver, Time.valueOf(time));
    }
}