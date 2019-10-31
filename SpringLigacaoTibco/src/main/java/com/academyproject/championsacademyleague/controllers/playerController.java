package com.academyproject.championsacademyleague.controllers;

import com.academyproject.championsacademyleague.schemas.PlayerDataInput;
import com.academyproject.championsacademyleague.schemas.PlayerIn;
import com.academyproject.championsacademyleague.schemas.PlayerOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("players")
public class playerController {

    @Autowired
    public com.academyproject.championsacademyleague.services.playerService playerService;

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

}
