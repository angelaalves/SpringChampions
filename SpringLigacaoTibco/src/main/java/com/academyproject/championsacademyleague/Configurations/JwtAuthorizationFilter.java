package com.academyproject.championsacademyleague.Configurations;

import com.academyproject.championsacademyleague.accesingdatamysql.player.Player;
import com.academyproject.championsacademyleague.accesingdatamysql.player.PlayerController;
import com.academyproject.championsacademyleague.constants.PlayerType;
import com.academyproject.championsacademyleague.constants.Status;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;


import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthorizationFilter extends BasicAuthenticationFilter {
    private PlayerController playerService;

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager, AuthenticationEntryPoint authenticationEntryPoint, PlayerController playerService) {
        super(authenticationManager, authenticationEntryPoint);
        this.playerService=playerService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String header= request.getHeader(JwtProperties.HEADER_STRING);
        if(header==null||!header.startsWith(JwtProperties.TOKEN_PREFIX)){
            chain.doFilter(request, response);
            return;
        }
        Authentication authentication=getUsernamePasswordAuthentication(request);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        chain.doFilter(request, response);
    }

    private Authentication getUsernamePasswordAuthentication(HttpServletRequest request){
        String token = request.getHeader(JwtProperties.HEADER_STRING);
        if(token!=null){
            String email= JWT.require(Algorithm.HMAC512(JwtProperties.SECRET.getBytes()))
                    .build()
                    .verify(token.replace(JwtProperties.TOKEN_PREFIX, ""))
                    .getSubject();
            if(email!=null){
                Player playerOut=this.playerService.getPlayerByEmail(email);
                PlayerType player=new PlayerType(playerOut.getUsername(), playerOut.getPassword(), Status.valueOf(playerOut.getStatus()), playerOut.getUsertype(),"");
                UserPrincipal principal= new UserPrincipal(player);
                UsernamePasswordAuthenticationToken auth= new UsernamePasswordAuthenticationToken(email, null, principal.getAuthorities());
                return auth;
            }
        }
        return null;

    }
}
