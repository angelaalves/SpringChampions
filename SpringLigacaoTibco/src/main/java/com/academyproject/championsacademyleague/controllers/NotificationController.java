package com.academyproject.championsacademyleague.controllers;

import com.academyproject.championsacademyleague.constants.NotificationView;
import com.academyproject.championsacademyleague.constants.Post;
import com.academyproject.championsacademyleague.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.management.Notification;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("Notifications")
public class NotificationController {
    @Autowired
    public NotificationService notificationService;


    public NotificationController() throws IOException {

    }

    @RequestMapping("send")
    public void send(@RequestParam String from, @RequestParam String to){
        NotificationView notification=new NotificationView(from, to);
        notificationService.send(notification);
    }

}