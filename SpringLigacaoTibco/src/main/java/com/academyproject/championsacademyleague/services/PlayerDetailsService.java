package com.academyproject.championsacademyleague.services;

import com.academyproject.championsacademyleague.Configurations.UserPrincipal;
import com.academyproject.championsacademyleague.accesingdatamysql.player.Player;
import com.academyproject.championsacademyleague.accesingdatamysql.player.PlayerController;
import com.academyproject.championsacademyleague.constants.PlayerType;
import com.academyproject.championsacademyleague.constants.Status;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PlayerDetailsService implements UserDetailsService {
    private PlayerController playerController;

    public PlayerDetailsService(PlayerController playerController){
        this.playerController=playerController;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Player playerOut=this.playerController.getPlayerByEmail(s);
        PlayerType player= new PlayerType(playerOut.getUsername(), playerOut.getPassword(), Status.valueOf(playerOut.getStatus()), playerOut.getUsertype(), "");
        UserPrincipal playerPrincipal= new UserPrincipal(player);
        return playerPrincipal;
    }
}
