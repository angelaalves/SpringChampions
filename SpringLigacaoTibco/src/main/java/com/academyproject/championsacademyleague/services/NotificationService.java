package com.academyproject.championsacademyleague.services;

import com.academyproject.championsacademyleague.constants.NotificationView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    @Autowired
    public SessionService sessionService;

    public void send(NotificationView notification){
        String to=notification.getTo();
        //colocar na base de dados e enviar ao player destinatario


    }
}
