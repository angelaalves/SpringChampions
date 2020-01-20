package com.academyproject.championsacademyleague.accesingdatamysql.notificationReceivers;

import com.academyproject.championsacademyleague.accesingdatamysql.player.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*@Controller
@RequestMapping(path="notificationReceivers")
public class NotificationReceiverController {
    @Autowired
    private NotificationReceiverRepository notificationReceiverRepository;

    @GetMapping(path="/getall")
    public @ResponseBody Iterable<NotificationReceiver> getAllNotificationReceivers() {
        // This returns a JSON or XML with the players
        return notificationReceiverRepository.findAll();
    }
}*/
