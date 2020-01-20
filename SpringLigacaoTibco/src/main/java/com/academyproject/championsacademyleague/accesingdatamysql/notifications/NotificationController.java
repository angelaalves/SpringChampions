package com.academyproject.championsacademyleague.accesingdatamysql.notifications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "notifications")
public class NotificationController {
    @Autowired
    private NotificationRepository notificationRepository;

    @GetMapping(path="/getall")
    public @ResponseBody Iterable<Notification> getAllNotificationReceivers() {
        // This returns a JSON or XML with the players
        return notificationRepository.findAll();
    }
}
