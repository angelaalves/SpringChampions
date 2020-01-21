package com.academyproject.championsacademyleague.services;

import org.springframework.stereotype.Service;

import javax.sound.sampled.Port;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class ConfigService {
    private String IP;
    private String port;
    private String DBAdmin;
    private String DBPassword;

    public ConfigService() {
        configFileReader("C:/Users/tiago.martins.santos/OneDrive/GitSpring/SpringChampions/SpringLigacaoTibco/configurations.txt");
    }
    public ConfigService(String filePath){
        configFileReader(filePath);
    }
    public String getIP() {
        return IP;
    }

    public String getPort() {
        return port;
    }

    public String getDBAdmin() {
        return DBAdmin;
    }

    public String getDBPassword() {
        return DBPassword;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public void setDBAdmin(String DBAdmin) {
        this.DBAdmin = DBAdmin;
    }

    public void setDBPassword(String DBPassword) {
        this.DBPassword = DBPassword;
    }

    public void saveConfigFile(String filePath, String IP, String port, String DBAdmin, String DBPassword){
        configFileWriter(filePath, IP, port, DBAdmin, DBPassword);
    }

    public List<String> loadBDConfig(){
        List<String> DBconfigDetails=new ArrayList<String>();
        DBconfigDetails.add(DBAdmin);
        DBconfigDetails.add(DBPassword);
        return DBconfigDetails;
    }

    public List<String> loadConfig(){
        List<String> configDetails=new ArrayList<String>();
        configDetails.add(IP);
        configDetails.add(port);
        return configDetails;
    }

    private void configFileReader(String filePath){
        try {
            Scanner eye = new Scanner(new File(filePath));
            while (eye.hasNext()) {
                if (!eye.hasNext("#")) {
                    switch (eye.next()) {
                        case "IP":
                            IP = eye.next();
                            break;
                        case "Port":
                            port = eye.next();
                            break;
                        case "DBAdmin":
                            DBAdmin = eye.next();
                            break;
                        case "DBPassword":
                            DBPassword = eye.next();
                            break;
                        default:
                            break;
                    }
                }
            }
            eye.close();
        }catch(FileNotFoundException f){
            System.err.println("configFileReader Error: File not found");
        }
    }
    private void configFileWriter(String filePath, String IP, String port, String DBAdmin, String DBPassword) {
        try {
            FileWriter magicPen = new FileWriter(new File(filePath), false);
            if (!IP.isEmpty()) {
                magicPen.write("IP " + IP+"\n");
                this.IP=IP;
                magicPen.flush();
            }
            if (!port.isEmpty()) {
                magicPen.write("Port " + port+"\n");
                this.port=port;
                magicPen.flush();
            }
            if (!DBAdmin.isEmpty()) {
                magicPen.write("DBAdmin " + DBAdmin+"\n");
                this.DBAdmin=DBAdmin;
                magicPen.flush();
            }
            if (!DBPassword.isEmpty()) {
                magicPen.write("DBPassword " + DBPassword+"\n");
                this.DBPassword=DBPassword;
                magicPen.flush();
            }
            magicPen.close();
        }catch(IOException e){
            System.err.println("configFileWriter Error: IOException");
        }
    }
}
