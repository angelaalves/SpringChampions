package com.academyproject.championsacademyleague.accesingdatamysql.notifications;

import com.academyproject.championsacademyleague.accesingdatamysql.guild.Guild;
import com.academyproject.championsacademyleague.accesingdatamysql.player.Player;
import com.academyproject.championsacademyleague.constants.NotificationView;
import com.academyproject.championsacademyleague.constants.PlayerType;
import com.academyproject.championsacademyleague.constants.Post;
import com.academyproject.championsacademyleague.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping(path = "notifications")
public class NotificationController {
    @Autowired
    private NotificationRepository notificationRepository;
    @Autowired
    private SessionService sessionService;

    private com.academyproject.championsacademyleague.accesingdatamysql.player.PlayerController playerController;
    private com.academyproject.championsacademyleague.accesingdatamysql.guild.GuildController guildController;

    URL url=new URL("http://192.168.0.84:4200");
    HttpURLConnection con=(HttpURLConnection) url.openConnection();

    private RestTemplate restTemplate = new RestTemplate();

    public NotificationController() throws IOException {
        con.setRequestMethod("GET");
    }

    public Post warn(){
        String url = "http://192.168.0.84:4200/";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        Post post = new Post(1, "warning", "");
        HttpEntity<Post> entity = new HttpEntity<>(post, headers);
        return this.restTemplate.postForObject(url, entity, Post.class);
    }

    @PostMapping(path="send")
    public @ResponseBody void send(NotificationView notification){
        List<PlayerType> playersLogged = sessionService.getPlayersLogged();
        for(PlayerType p: playersLogged){
            if(p.getUsername().equals(notification.getTo())){
                warn();
            }
        }
    }

    @GetMapping(path="/getall")
    public @ResponseBody Iterable<Notification> getAllNotificationReceivers() {
        return notificationRepository.findAll();
    }

    @PostMapping(path="/create")
    public @ResponseBody String create(@RequestParam String idNotification, @RequestParam String idPlayerSenderFK, @RequestParam String idGuildFK, @RequestParam String isreward, @RequestParam String isevent, @RequestParam String description){
        Player sender = (Player) playerController.getPlayerById(idPlayerSenderFK.toString());
        Guild guild = (Guild) guildController.getGuildById(idGuildFK);
        notificationRepository.save(new Notification(Integer.valueOf(idNotification), sender, guild, Integer.valueOf(isreward), Integer.valueOf(isevent), description));
        return "notification created";
    }

    @GetMapping(path="/getNotificationById")
    public @ResponseBody Notification getNotificationById(@RequestParam String idNotification){
        return notificationRepository.findNotificationById(idNotification);
    }

    @GetMapping(path="/getNotificationByPlayerSender")
    public @ResponseBody List<Notification> getNotificationByPlayerSenderId(@RequestParam String idPlayerSender){
        return notificationRepository.findNotificationByPlayerSenderId(idPlayerSender);
    }

    @GetMapping(path="/getNotificationByGuild")
    public @ResponseBody List<Notification> getNotificationByIdGuild(@RequestParam String idGuildFK){
        return notificationRepository.findNotificationByGuildId(idGuildFK);
    }

    @GetMapping(path="/getNotificationByReward")
    public @ResponseBody Iterable<Notification> getNotificationByIdReward(@RequestParam String idRewardFK){
        return notificationRepository.findNotificationByReward(idRewardFK);
    }

    @GetMapping(path="/getNotificationByEvent")
    public @ResponseBody Iterable<Notification> getNotificationByIdEvent(@RequestParam String idEventFK){
        return notificationRepository.findNotificationByEvent(idEventFK);
    }

    @PostMapping(path="/delete")
    public @ResponseBody String delete(@RequestParam Integer idNotification){
        notificationRepository.deleteById(idNotification);
        return "notification deleted";
    }
}