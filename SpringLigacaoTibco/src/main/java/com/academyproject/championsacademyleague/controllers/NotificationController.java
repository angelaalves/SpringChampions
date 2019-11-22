package com.academyproject.championsacademyleague.controllers;

import com.academyproject.championsacademyleague.constants.NotificationView;
import com.academyproject.championsacademyleague.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@CrossOrigin
@RestController
@RequestMapping("Notifications")
public class NotificationController {
    @Autowired
    public NotificationService notificationService;

    URL url=new URL("http://localhost:4200");
    HttpURLConnection con=(HttpURLConnection) url.openConnection();

    public NotificationController() throws IOException {
        con.setRequestMethod("GET");
    }

    public void send(NotificationView  notification){

    }


}
