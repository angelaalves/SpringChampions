package com.academyproject.championsacademyleague.controllers;

import com.academyproject.championsacademyleague.Configurations.JwtAuthenticationFilter;
import com.academyproject.championsacademyleague.constants.Time;
import com.academyproject.championsacademyleague.schemas.*;
import com.academyproject.championsacademyleague.services.EmailSenders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
        PlayerIn playerIn= new PlayerIn("","","","","","","","","","");
        dataIn.getPlayerIn().add(playerIn);
        return playerService.getAll(dataIn);

    }

    @RequestMapping("Create")
        public List<PlayerOut> getCreatePlayers(String idPlayer, String userName, String email, String password, String gender, String userType, String xp, String champiesToGive, String myChampies, String status) {

        PlayerDataInput dataIn= new PlayerDataInput();
        PlayerIn playerIn= new PlayerIn(idPlayer, userName, email, passwordEncoder().encode(password), gender, userType, xp, champiesToGive, myChampies, status);
        dataIn.getPlayerIn().add(playerIn);
        return playerService.create(dataIn);

    }

    @RequestMapping("Update")
    public List<PlayerOut> getUpdatePlayers(String idPlayer, String userName, String email, String password, String gender, String userType, String xp, String champiesToGive, String myChampies, String status) {
        PlayerDataInput dataIn= new PlayerDataInput();
        PlayerIn playerIn;
        if(password.contains("$2a$")){
            playerIn= new PlayerIn(idPlayer, userName, email, password, gender, userType, xp, champiesToGive, myChampies, status);
        }else{
            playerIn = new PlayerIn(idPlayer, userName, email, passwordEncoder().encode(password), gender, userType, xp, champiesToGive, myChampies, status);
        }
        dataIn.getPlayerIn().add(playerIn);
        return playerService.update(dataIn);

    }

    @RequestMapping("Get")
    public List<PlayerOut> getGetPlayers(String idPlayer, String userName, String email, String password, String gender, String userType, String xp, String champiesToGive, String myChampies, String status) {
        PlayerDataInput dataIn= new PlayerDataInput();
        PlayerIn playerIn= new PlayerIn(idPlayer, userName, email, password, gender, userType, xp, champiesToGive, myChampies, status);
        dataIn.getPlayerIn().add(playerIn);
        return playerService.get(dataIn);
    }

    @RequestMapping("SendEmail")
    public boolean TestMail(String playerEmail){
        EmailSenders email=new EmailSenders();
        return email.sendEmail(playerEmail);
    }

    PasswordEncoder passwordEncoder(){return new BCryptPasswordEncoder();}

    @RequestMapping("verifyPassword")
    public boolean verifyPassword(@RequestParam String email, @RequestParam String password){
        List<PlayerOut> players = getAllPlayers();
        for(PlayerOut player: players){
            if(email.equals(player.getEmail()) & passwordEncoder().matches(password, player.getPassword())){
                return true;
            }else{
                return false;
            }
        }
        return false;
    }
}
