package com.academyproject.championsacademyleague.services;

import com.academyproject.championsacademyleague.constants.Constants;
import com.academyproject.championsacademyleague.schemas.NotificationReceiversDataInput;
import com.academyproject.championsacademyleague.schemas.NotificationReceiversDataOutput;
import com.academyproject.championsacademyleague.schemas.NotificationReceiversOut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.SoapMessage;

import java.util.List;

@Service
public class NotificationReceiversService {

    private static final Logger log = LoggerFactory.getLogger(playerService.class);

    Constants cons= new Constants();

    @Autowired
    public SessionService sessionService;

    @Autowired
    public Jaxb2Marshaller marshaller;

    public WebServiceTemplate template;

    public List<NotificationReceiversOut> getAll (NotificationReceiversDataInput request) {
        template = new WebServiceTemplate(marshaller);
        template.setDefaultUri(cons.getNotificationReceiversGetAllURL());

        NotificationReceiversDataOutput response = (NotificationReceiversDataOutput) template
                .marshalSendAndReceive(request, message -> ((SoapMessage)message).setSoapAction(cons.getNotificationReceiversSOAPGetAll()));

        return response.getNotificationReceiversOut();
    }

    public List <NotificationReceiversOut> get (NotificationReceiversDataInput request) {
        template = new WebServiceTemplate(marshaller);
        template.setDefaultUri(cons.getNotificationReceiversGetURL());

        NotificationReceiversDataOutput response = (NotificationReceiversDataOutput) template
                .marshalSendAndReceive(request, message -> ((SoapMessage)message).setSoapAction(cons.getNotificationReceiversSOAPGet()));

        return response.getNotificationReceiversOut();
    }

    public List <NotificationReceiversOut> create (NotificationReceiversDataInput request) {
        template = new WebServiceTemplate(marshaller);
        template.setDefaultUri(cons.getNotificationReceiversCreateURL());

        NotificationReceiversDataOutput response = (NotificationReceiversDataOutput) template
                .marshalSendAndReceive(request, message -> ((SoapMessage)message).setSoapAction(cons.getNotificationReceiversSOAPCreate()));

        return response.getNotificationReceiversOut();
    }

    public List <NotificationReceiversOut> delete (NotificationReceiversDataInput request) {
        template = new WebServiceTemplate(marshaller);
        template.setDefaultUri(cons.getNotificationReceiversDeleteURL());

        NotificationReceiversDataOutput response = (NotificationReceiversDataOutput) template
                .marshalSendAndReceive(request, message -> ((SoapMessage)message).setSoapAction(cons.getNotificationReceiversSOAPDelete()));

        return response.getNotificationReceiversOut();
    }

    public List<NotificationReceiversOut> update(NotificationReceiversDataInput request){
        template = new WebServiceTemplate(marshaller);
        template.setDefaultUri(cons.getNotificationReceiversUpdateURL());

        NotificationReceiversDataOutput response = (NotificationReceiversDataOutput) template
                .marshalSendAndReceive(request, message -> ((SoapMessage)message).setSoapAction(cons.getNotificationReceiversSOAPUpdate()));

        return response.getNotificationReceiversOut();
    }
}