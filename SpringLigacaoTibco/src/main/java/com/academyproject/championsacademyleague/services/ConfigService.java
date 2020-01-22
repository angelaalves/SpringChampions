package com.academyproject.championsacademyleague.services;

import org.springframework.stereotype.Service;

import javax.sound.sampled.Port;
import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
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

    public void iCanReadProperties() throws FileNotFoundException {
        Scanner eye=new Scanner(new File("C:/Users/tiago.martins.santos/OneDrive/GitSpring/SpringChampions/SpringLigacaoTibco/src/main/resources/application.properties"));
        while(eye.hasNext()){
            System.out.println(eye.next());
        }
    }

    public String saveConfigFile(String IP, String port, String DBip, String DBport, String DBAdmin, String DBPassword) throws IOException {
        configFileWriter(IP, port, DBip, DBport, DBAdmin, DBPassword);
        return "Saved";
    }

    public List<String> loadConfig(){
        List<String> configDetails=new ArrayList<String>();
        configDetails.add(IP);
        configDetails.add(port);
        configDetails.add(DBAdmin);
        configDetails.add(DBPassword);
        return configDetails;
    }

    public void getServerIP() throws UnknownHostException {
        String ip= InetAddress.getLocalHost().toString();
        System.out.println(ip);
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
    private void configFileWriter(String IP, String port, String DBip, String DBport, String DBAdmin, String DBPassword) throws IOException {
            FileWriter magicPen = new FileWriter(new File("C:/Users/tiago.martins.santos/OneDrive/GitSpring/SpringChampions/SpringLigacaoTibco/src/main/resources/application.properties"), false);
            this.IP=IP;
            if (!IP.isEmpty()) {
                magicPen.write("server.port=" +port+"\n");
                this.port=port;
                magicPen.flush();
            }
            magicPen.write("logging.level.org.springframework.web=DEBUG\n");
            magicPen.flush();
            magicPen.write("spring.jpa.hibernate.ddl-auto=update\n");
            magicPen.flush();
            if (!port.isEmpty()) {
                magicPen.write("spring.datasource.url=jdbc:mysql://"+DBip+":"+DBport+"/academyleague?useTimezone=true&serverTimezone=GMT\n");
                this.port=port;
                magicPen.flush();
            }
            if (!DBAdmin.isEmpty()) {
                magicPen.write("spring.datasource.username=" + DBAdmin+"\n");
                this.DBAdmin=DBAdmin;
                magicPen.flush();
            }
            if (!DBPassword.isEmpty()) {
                magicPen.write("spring.datasource.password=" + DBPassword+"\n");
                this.DBPassword=DBPassword;
                magicPen.flush();
            }
            magicPen.write("main.allow-bean-definition-overriding=true");
            magicPen.flush();
            magicPen.close();
    }
}
