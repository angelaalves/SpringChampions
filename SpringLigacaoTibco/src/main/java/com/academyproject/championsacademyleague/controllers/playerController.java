package com.academyproject.championsacademyleague.controllers;


import com.academyproject.championsacademyleague.schemas.*;
import com.academyproject.championsacademyleague.services.playerService;
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
    public List<PlayerOut> getCreatePlayers() {

    }

    @RequestMapping("Update")
    public List<PlayerOut> getUpdatePlayers() {

    }

    @RequestMapping("Get")
    public List<PlayerOut> getGetPlayers() {

    }

}
