package com.academyproject.championsacademyleague.services;

import com.academyproject.championsacademyleague.Configurations.timeValue;
import com.academyproject.championsacademyleague.constants.Constants;
import com.academyproject.championsacademyleague.constants.NotificationView;
import com.academyproject.championsacademyleague.constants.Time;
import com.academyproject.championsacademyleague.controllers.watchedVideosController;
import com.academyproject.championsacademyleague.schemas.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.SoapMessage;

import java.util.List;

@Service
public class NotificationService {

    private static final Logger log = LoggerFactory.getLogger(playerService.class);

    Constants cons= new Constants();

    @Autowired
    public SessionService sessionService;

    @Autowired
    public Jaxb2Marshaller marshaller;

    public WebServiceTemplate template;

    public void send(NotificationView notification){
        String to=notification.getTo();
        //colocar na base de dados e enviar ao player destinatario


    }

    public List<NotificationsOut> getAll (NotificationsDataInput request) {
        template = new WebServiceTemplate(marshaller);
        template.setDefaultUri(cons.getNotificationGetAllURL());

        NotificationsDataOutput response = (NotificationsDataOutput) template
                .marshalSendAndReceive(request, message -> ((SoapMessage)message).setSoapAction(cons.getNotificationSOAPGetAll()));

        return response.getNotificationsOut();
    }

    public List <NotificationsOut> get (NotificationsDataInput request) {
        template = new WebServiceTemplate(marshaller);
        template.setDefaultUri(cons.getNotificationGetURL());

        NotificationsDataOutput response = (NotificationsDataOutput) template
                .marshalSendAndReceive(request, message -> ((SoapMessage)message).setSoapAction(cons.getNotificationSOAPGet()));

        return response.getNotificationsOut();
    }

    public List <NotificationsOut> create (NotificationsDataInput request) {
        template = new WebServiceTemplate(marshaller);
        template.setDefaultUri(cons.getNotificationCreateURL());

        NotificationsDataOutput response = (NotificationsDataOutput) template
                .marshalSendAndReceive(request, message -> ((SoapMessage)message).setSoapAction(cons.getNotificationSOAPCreate()));

        return response.getNotificationsOut();
    }

    public List <NotificationsOut> delete (NotificationsDataInput request) {
        template = new WebServiceTemplate(marshaller);
        template.setDefaultUri(cons.getNotificationDeleteURL());

        NotificationsDataOutput response = (NotificationsDataOutput) template
                .marshalSendAndReceive(request, message -> ((SoapMessage)message).setSoapAction(cons.getNotificationSOAPDelete()));

        return response.getNotificationsOut();
    }
}