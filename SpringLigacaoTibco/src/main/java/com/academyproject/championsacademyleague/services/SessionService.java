package com.academyproject.championsacademyleague.services;

import com.academyproject.championsacademyleague.constants.PlayerType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SessionService {
    private List<PlayerType> playersLogged= new ArrayList<>();

    public boolean loggingPlayer(PlayerType player){
        playersLogged.add(player);
        return true;
    }
    public boolean removingPlayer(String email){
        for (PlayerType player: playersLogged){
            if(player.getUsername().equals(email)){
                playersLogged.remove(player);
                return true;
            }
        }
        return false;
    }
    public PlayerType getPlayerByEmail(String email){
        for (PlayerType player: playersLogged){
            if(player.getUsername().equals(email)){
                return player;
            }
        }
        return null;
    }
    public List<PlayerType> getPlayersLogged(){
        return playersLogged;
    }
}
