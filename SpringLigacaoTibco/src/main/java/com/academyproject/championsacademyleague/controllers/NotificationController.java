package com.academyproject.championsacademyleague.controllers;

import com.academyproject.championsacademyleague.constants.NotificationView;
import com.academyproject.championsacademyleague.constants.PlayerType;
import com.academyproject.championsacademyleague.constants.Post;
import com.academyproject.championsacademyleague.schemas.NotificationsDataInput;
import com.academyproject.championsacademyleague.schemas.NotificationsIn;
import com.academyproject.championsacademyleague.schemas.NotificationsOut;
import com.academyproject.championsacademyleague.services.NotificationService;
import com.academyproject.championsacademyleague.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("notifications")
public class NotificationController {

    @Autowired
    public NotificationService notificationService;
    @Autowired
    public SessionService sessionService;


    URL url=new URL("http://localhost:4200");
    HttpURLConnection con=(HttpURLConnection) url.openConnection();

    private RestTemplate restTemplate = new RestTemplate();

    public Post warn(){
        String url = "http://localhost:4200/";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        Post post = new Post(1, "warning", "");
        HttpEntity<Post> entity = new HttpEntity<>(post, headers);
        return this.restTemplate.postForObject(url, entity, Post.class);
    }

    public NotificationController() throws IOException {
        con.setRequestMethod("GET");
    }

    @RequestMapping("send")
    public void send(NotificationView  notification){
        List<PlayerType> playersLogged = sessionService.getPlayersLogged();
        for(PlayerType p: playersLogged){
            if(p.getUsername().equals(notification.getTo())){
                warn();
            }
        }
    }


    @RequestMapping("getAll")
    public List<NotificationsOut> getAllNotifications() {
        NotificationsDataInput dataIn = new NotificationsDataInput();
        NotificationsIn notificationsIn = new NotificationsIn("","","","","","");
        dataIn.getNotificationsIn().add(notificationsIn);
        return notificationService.getAll(dataIn);
    }

    @RequestMapping("Create")
    public List<NotificationsOut> getCreateNotifications(String idEventFK, String idGuildFK, String ID_Notification, String ID_PlayerSender_FK, String idRewardFK, String description) {
        NotificationsDataInput dataIn= new NotificationsDataInput();
        NotificationsIn notificationsIn= new NotificationsIn(idEventFK,idGuildFK,ID_Notification,ID_PlayerSender_FK,idRewardFK, description);
        dataIn.getNotificationsIn().add(notificationsIn);
        return notificationService.create(dataIn);
    }

    @RequestMapping("Get")
    public List<NotificationsOut> getGetNotifications(String idEventFK, String idGuildFK, String ID_Notification, String ID_PlayerSender_FK, String idRewardFK) {
        NotificationsDataInput dataIn= new NotificationsDataInput();
        NotificationsIn notificationsIn= new NotificationsIn(idEventFK,idGuildFK,ID_Notification,ID_PlayerSender_FK,idRewardFK,"");
        dataIn.getNotificationsIn().add(notificationsIn);
        return notificationService.get(dataIn);
    }

    @RequestMapping("Delete")
    public List<NotificationsOut> getDeleteNotifications(String idEventFK, String idGuildFK, String ID_Notification, String ID_PlayerSender_FK, String idRewardFK) {
        NotificationsDataInput dataIn = new NotificationsDataInput();
        NotificationsIn notificationsIn = new NotificationsIn(idEventFK, idGuildFK, ID_Notification, ID_PlayerSender_FK, "","");
        dataIn.getNotificationsIn().add(notificationsIn);
        return notificationService.delete(dataIn);
    }
}