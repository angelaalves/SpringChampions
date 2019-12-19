package com.academyproject.championsacademyleague.Configurations;

import com.academyproject.championsacademyleague.constants.PlayerType;
import com.academyproject.championsacademyleague.constants.Status;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

    public class UserPrincipal implements UserDetails {
        private PlayerType player;

        public UserPrincipal(PlayerType player){
            this.player = player;
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            List<GrantedAuthority> authorities = new ArrayList<>();

            // Extract list of permissions (name)
            this.player.getPermissionList().forEach(p -> {
                GrantedAuthority authority = new SimpleGrantedAuthority(p);
                authorities.add(authority);
            });

            // Extract list of roles (ROLE_name)
            this.player.getRoleList().forEach(r -> {
                GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + r);
                authorities.add(authority);
            });

            return authorities;
        }

        @Override
        public String getPassword() {
            return this.player.getPassword();
        }

        @Override
        public String getUsername() {
            return this.player.getUsername();
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return this.player.getActive() == Status.Active;
        }
        public PlayerType getPlayer(){
            return player;
        }
    }
