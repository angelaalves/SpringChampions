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
import java.util.Random;

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

    PasswordEncoder passwordEncoder(){return new BCryptPasswordEncoder();}

    @RequestMapping("verifyPassword")
    public boolean verifyPassword(@RequestParam String email, @RequestParam String password){
        List<PlayerOut> players = getAllPlayers();
        for(PlayerOut player: players){
            if(email.equals(player.getEmail())){
                if(passwordEncoder().matches(password, player.getPassword())) {
                    return true;
                }
            }else{
                return false;
            }
        }
        return false;
    }

    @RequestMapping("forgotPassword")
    public String forgotPassword(@RequestParam String email){
        String randomPass="";
        Random randomizer=new Random();
        for(int i=0; i<10;i++){
            int j=(randomizer.nextInt(10));
            randomPass=randomPass+(String.valueOf(randomizer.nextInt(10)));
        }
        PlayerDataInput dataInGet= new PlayerDataInput();
        PlayerIn playerInGet= new PlayerIn("", "", email, "", "", "", "", "", "", "");
        dataInGet.getPlayerIn().add(playerInGet);
        List<PlayerOut> player=playerService.get(dataInGet);

        PlayerDataInput dataInUpdate= new PlayerDataInput();
        PlayerIn playerInUpdate=new PlayerIn(player.get(0).getIDPlayer(), player.get(0).getUserName(), player.get(0).getEmail(), passwordEncoder().encode(randomPass), player.get(0).getGender(), player.get(0).getUserType(), player.get(0).getXP(), player.get(0).getChampiesToGive(), player.get(0).getMyChampies(), player.get(0).getStatus());
        dataInUpdate.getPlayerIn().add(playerInUpdate);
        playerService.update(dataInUpdate);

        EmailSenders forgotPass=new EmailSenders();
        forgotPass.forgotPasswordMail(email, randomPass);

        return randomPass;
    }

    @RequestMapping("CreateNewPlayer")
    public void createNewPlayer(String idPlayer, String userName, String email, String gender, String userType){
        String randomPass="";
        Random randomizer=new Random();
        for(int i=0; i<10;i++){
            int j=(randomizer.nextInt(10));
            randomPass=randomPass+(String.valueOf(randomizer.nextInt(10)));
        }
        PlayerDataInput dataIn= new PlayerDataInput();
        PlayerIn playerIn;
        if(userType.equals("warrior")){
            playerIn= new PlayerIn(idPlayer,userName, email, passwordEncoder().encode(randomPass), gender, userType, "0", "20", "0", "Active");
        }else{
            playerIn= new PlayerIn(idPlayer,userName, email, passwordEncoder().encode(randomPass), gender, userType, "1000", "10000", "10000", "Active");
        }

        dataIn.getPlayerIn().add(playerIn);
        playerService.create(dataIn);
        EmailSenders sender=new EmailSenders();
        sender.sendEmail(email, randomPass);
    }

    @RequestMapping("AlertPassword")
    public void alertPassword(@RequestParam String email) {
        EmailSenders sender = new EmailSenders();
        sender.changedPasswordMail(email);
    }
}
