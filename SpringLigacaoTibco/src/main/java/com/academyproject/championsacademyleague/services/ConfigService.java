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
    private String DBport;
    private String DBAdmin;
    private String DBPassword;

    public ConfigService() {
        configFileReader();

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

    public String saveConfigFile(String IP, String port, String DBport, String DBAdmin, String DBPassword) throws IOException {
        configFileWriter(IP, port, DBport, DBAdmin, DBPassword);
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

    private void configFileReader(){
        try {
            Scanner eye = new Scanner(new File("C:/Users/tiago.martins.santos/OneDrive/GitSpring/SpringChampions/SpringLigacaoTibco/src/main/resources/application.properties"));
            while (eye.hasNext()) {
                if (!eye.hasNext("#")) {
                    String[] line=eye.next().split("=");
                    switch (line[0]) {
                        case "//IP":
                            IP=line[1];
                            break;
                        case "server.port":
                            port = line[1];
                            break;
                        case "//DBport":
                            DBport=line[1];
                            break;
                        case "spring.datasource.username":
                            DBAdmin = line[1];
                            break;
                        case "spring.datasource.password":
                            DBPassword = line[1];
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
    private void configFileWriter(String IP, String port, String DBport, String DBAdmin, String DBPassword) throws IOException {
            FileWriter magicPen = new FileWriter(new File("C:/Users/tiago.martins.santos/OneDrive/GitSpring/SpringChampions/SpringLigacaoTibco/src/main/resources/application.properties"), false);
            if(!IP.isEmpty()){
                this.IP=IP;
                magicPen.write("//IP="+IP+"\n");
            }else{
                magicPen.write("//IP="+this.IP+"\n");
            }
            magicPen.flush();

            if (!port.isEmpty()) {
                magicPen.write("server.port=" +port+"\n");
                this.port=port;
            }else{
                magicPen.write("server.port=" +this.port+"\n");
            }
            magicPen.flush();
            magicPen.write("server.ssl.enable=true\n" +
                    "server.ssl.key-store:src/main/resources/polaCertificate.p12\n" +
                    "server.ssl.key-store-password:Pol@Rocks\n" +
                    "server.ssl.keyStoreType:PKCS12\n" +
                    "server.ssl.keyAlias:polaCertificate");
            magicPen.flush();
            magicPen.write("logging.level.org.springframework.web=DEBUG\n");
            magicPen.flush();
            magicPen.write("spring.jpa.hibernate.ddl-auto=update\n");
            magicPen.flush();
            if (!DBport.isEmpty()) {
                magicPen.write("//DBport="+DBport+"\n"+"spring.datasource.url=jdbc:mysql://localhost:"+DBport+"/academyleague?useTimezone=true&serverTimezone=GMT\n");
                this.port=port;
                magicPen.flush();
            }else{
                magicPen.write("//DBport="+this.DBport+"\n"+"spring.datasource.url=jdbc:mysql://localhost:"+this.DBport+"/academyleague?useTimezone=true&serverTimezone=GMT\n");
                magicPen.flush();
            }
            if (!DBAdmin.isEmpty()) {
                magicPen.write("spring.datasource.username=" + DBAdmin+"\n");
                this.DBAdmin=DBAdmin;
                magicPen.flush();
            }else{
                magicPen.write("spring.datasource.username=" + this.DBAdmin+"\n");
                magicPen.flush();
            }
            if (!DBPassword.isEmpty()) {
                magicPen.write("spring.datasource.password=" + DBPassword+"\n");
                this.DBPassword=DBPassword;
                magicPen.flush();
            }else{
                magicPen.write("spring.datasource.password=" + this.DBPassword+"\n");
                magicPen.flush();
            }
            magicPen.write("main.allow-bean-definition-overriding=true");
            magicPen.flush();
            magicPen.close();
    }
}
