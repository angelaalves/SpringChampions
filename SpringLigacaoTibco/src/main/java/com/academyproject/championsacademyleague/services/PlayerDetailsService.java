package com.academyproject.championsacademyleague.services;

import com.academyproject.championsacademyleague.Configurations.UserPrincipal;
import com.academyproject.championsacademyleague.constants.PlayerType;
import com.academyproject.championsacademyleague.constants.Status;
import com.academyproject.championsacademyleague.schemas.PlayerOut;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PlayerDetailsService implements UserDetailsService {
    private playerService playerService;

    public PlayerDetailsService(playerService playerService){
        this.playerService=playerService;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        PlayerOut playerOut=this.playerService.getPlayerByEmail(s);
        PlayerType player= new PlayerType(playerOut.getUserName(), playerOut.getPassword(), Status.valueOf(playerOut.getStatus()), "", "");
        UserPrincipal playerPrincipal= new UserPrincipal(player);
        return playerPrincipal;

    }
}
