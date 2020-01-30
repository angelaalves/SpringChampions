package com.academyproject.championsacademyleague.accesingdatamysql.notificationReceivers;

import com.academyproject.championsacademyleague.accesingdatamysql.guild.Guild;
import com.academyproject.championsacademyleague.accesingdatamysql.guild.GuildController;
import com.academyproject.championsacademyleague.accesingdatamysql.guild.GuildRepository;
import com.academyproject.championsacademyleague.accesingdatamysql.guildPlayers.GuildPlayers;
import com.academyproject.championsacademyleague.accesingdatamysql.guildPlayers.GuildPlayersRepository;
import com.academyproject.championsacademyleague.accesingdatamysql.notifications.Notification;
import com.academyproject.championsacademyleague.accesingdatamysql.notifications.NotificationRepository;
import com.academyproject.championsacademyleague.accesingdatamysql.player.Player;
import com.academyproject.championsacademyleague.accesingdatamysql.player.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping(path="notificationReceivers")
public class NotificationReceiverController {
    @Autowired
    private NotificationReceiverRepository notificationReceiverRepository;
    @Autowired
    private GuildPlayersRepository guildPlayersRepository;
    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private NotificationRepository notificationRepository;
    @Autowired
    private GuildRepository guildRepository;

    @GetMapping(path="/getall")
    public @ResponseBody Iterable<NotificationReceiver> getAllNotificationReceivers() {
        // This returns a JSON or XML with the players
        return notificationReceiverRepository.findAll();
    }

    @PostMapping(path="/create")
    public @ResponseBody String create(@RequestParam String idNotificationReceiver, @RequestParam String idPlayerReceiverFK, @RequestParam String idNotificationFK, @RequestParam String idGuildFK, @RequestParam String notificationSeen) {
        Player receiver = playerRepository.findByIdCustom(idPlayerReceiverFK);
        Notification notification = notificationRepository.findNotificationById(idNotificationFK);
        Guild guild = guildRepository.findGuildByID(idGuildFK);
        notificationReceiverRepository.save(new NotificationReceiver(Integer.parseInt(idNotificationReceiver), receiver, notification, guild, 0));
        return "notification receiver created";
    }

    @PostMapping(path="update")
    public @ResponseBody String update(@RequestParam String idNotificationReceiver, @RequestParam String idPlayerReceiverFK, @RequestParam String idNotificationFK, @RequestParam String idGuildFK, @RequestParam int notificationSeen){
        NotificationReceiver nr = (NotificationReceiver) notificationReceiverRepository.find(idNotificationReceiver, idPlayerReceiverFK, idNotificationFK, idGuildFK);
        nr.setNotificationSeen(notificationSeen);
        notificationReceiverRepository.save(nr);
        return "notification receiver updated";
    }

    @GetMapping(path="/getNotificationReceiverByReceiverID")
    public @ResponseBody Iterable<NotificationReceiver> getNotificationReceiverByReceiverId(@RequestParam String idNotificationReceiver) {
        return notificationReceiverRepository.findAllById(Collections.singleton(Integer.parseInt(idNotificationReceiver)));
    }

    @GetMapping(path="/getNotificationReceiverByPlayerReceiver")
    public @ResponseBody Iterable<NotificationReceiver> getNotificationReceiverByPlayerReceiver(@RequestParam String idPlayerReceiverFK) {
        return notificationReceiverRepository.findAllById(Collections.singleton(Integer.parseInt(idPlayerReceiverFK)));
    }

    @GetMapping(path="/getNotificationReceiverByNotificationId")
    public @ResponseBody Iterable<NotificationReceiver> getNotificationReceiverByNotificationId(@RequestParam String idNotificationFK) {
        return notificationReceiverRepository.findAllById(Collections.singleton(Integer.parseInt(idNotificationFK)));
    }

    @GetMapping(path="/getNotificationReceiverByGuildId")
    public @ResponseBody Iterable<NotificationReceiver> getNotificationReceiverByGuildId(@RequestParam String idGuildFK) {
        return notificationReceiverRepository.findAllById(Collections.singleton(Integer.parseInt(idGuildFK)));
    }

    @PostMapping(path="/delete")
    public @ResponseBody String deleteNotificationReceiver(@RequestParam String idNotificationReceiver) {
        notificationReceiverRepository.deleteById(Integer.parseInt(idNotificationReceiver));
        return "notification receiver deleted";
    }

    /*@PostMapping(path="/createNotificationsByID")
    public @ResponseBody void createNotificationsByID(@RequestParam String SenderID, @RequestParam String ReceiverID, @RequestParam String description, @RequestParam String isEvent, @RequestParam String isReward){
        Player sender = playerRepository.findByIdCustom(SenderID);
        List<GuildPlayers> guildplayer = guildPlayersRepository.findByIdPlayer(sender.getIdPlayer());
        Iterable<NotificationReceiver> notificationPlayer = notificationReceiverRepository.findByPlayerReceiver(String.valueOf(sender.getIdPlayer()));
        ArrayList<Notification> notificationsList = new ArrayList();
        for(NotificationReceiver n: notificationPlayer) {
            notificationsList.add(notificationRepository.findNotificationById(String.valueOf(n.getIdnotification().getIDNotification())));
        }

        String notificationID="";
        if(!notificationsList.get(0).getIDPlayerSenderFK().equals("Not Found")){
            boolean found=false;
            for(int i=0;i<notificationsList.size();i++){
                if(notificationsList.get(i).getDescription().equals(description)){
                    found=true;
                    notificationID=String.valueOf(notificationsList.get(i).getIDNotification());
                    break;
                }
            }
            if(!found){
                Guild guild = guildRepository.findGuildByID(String.valueOf(guildplayer..getIDGuildFK().getIDGuild()));

                Notification notification = new Notification(0, sender, guild, Integer.parseInt(isReward), Integer.valueOf(isEvent), description);
                notificationRepository.create("", String.valueOf(sender.getIdPlayer()), String.valueOf(guild.getIDGuild()), isReward, isEvent, description);

                notificationsList = (ArrayList<Notification>) notificationController.getNotificationByPlayerSenderId(String.valueOf(sender.getIdPlayer()));

                boolean foundAfter=false;
                for(int i=0;i<notificationsList.size();i++){
                    if(notificationsList.get(i).getDescription().equals(description)){
                        found=true;
                        notificationID=String.valueOf(notificationsList.get(i).getIDNotification());
                        break;
                    }
                }
            }
        }
        create("", ReceiverID, notificationID, String.valueOf(guildplayer.getGuildPlayersId().getIDGuildFK().getIDGuild()), "0");
    }!!!ERROR!!!

    /*@PostMapping(path="/createNotificationsByUsername")
    public @ResponseBody void createNotificationsByUserName(@RequestParam String senderUserName,@RequestParam String receiverUserName, @RequestParam String justification, @RequestParam String isEvent, @RequestParam String isReward){
        Player sender = playerRepository.getPlayerByUsername(senderUserName);
        Player receiver = playerController.getPlayerByUsername(receiverUserName);
        GuildPlayers guildplayer = (GuildPlayers) guildPlayersRepository.findByIdPlayer(sender.getIdPlayer());
        Iterable<Notification>  notifications= notificationController.getNotificationById(String.valueOf(sender.getIdPlayer()));
        ArrayList<Notification> notificationList = new ArrayList<>();
        for(Notification n: notificationList){
            notificationList.add((Notification) notificationController.getNotificationById(String.valueOf(n.getIDNotification())));
        }
        String notificationID="";

        if(!notificationList.get(0).getIDPlayerSenderFK().equals("Not Found")){
            boolean found=false;
            for(int i=0;i<notificationList.size();i++){
                if(notificationList.get(i).getDescription().equals(justification)){
                    found=true;
                    notificationID=String.valueOf(notificationList.get(i).getIDNotification());
                    break;
                }
            }
            if(!found){
                notificationList= (ArrayList<Notification>) notificationController.getNotificationByPlayerSenderId(String.valueOf(sender.getIdPlayer()));
                boolean foundAfter=false;
                for(int i=0;i<notificationList.size();i++){
                    if(notificationList.get(i).getDescription().equals(justification)){
                        found=true;
                        notificationID=String.valueOf(notificationList.get(i).getIDNotification());
                        break;
                    }
                }
            }
        }
        create("0", String.valueOf(receiver.getIdPlayer()), notificationID, String.valueOf(guildplayer.getGuildPlayersId().getIDGuildFK().getIDGuild()), "0");
    }!!!ERROR!!!*/
}