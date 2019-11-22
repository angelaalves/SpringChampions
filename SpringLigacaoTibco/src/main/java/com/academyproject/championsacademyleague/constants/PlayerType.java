package com.academyproject.championsacademyleague.constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayerType {

    private String username;
    private String password;
    private Status active;
    private String roles="";
    private String permissions="";

    public PlayerType(String username, String password, Status active, String roles, String permissions) {
        this.username = username;
        this.password = password;
        this.active = active;
        this.roles = roles;
        this.permissions = permissions;
    }

    protected PlayerType(){}

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Status getActive() {
        return active;
    }

    public String getRoles() {
        return roles;
    }

    public String getPermissions() {
        return permissions;
    }

    public List<String> getRoleList(){
        if(this.roles.length()>0){
            return Arrays.asList(this.permissions.split(","));
        }
        return new ArrayList<>();
    }

    public List<String> getPermissionList(){
        if(this.permissions.length()>0){
            return Arrays.asList(this.permissions.split(","));
        }
        return new ArrayList<>();
    }
}
