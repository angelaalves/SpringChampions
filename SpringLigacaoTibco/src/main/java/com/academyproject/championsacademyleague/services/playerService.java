package com.academyproject.championsacademyleague.services;

import com.academyproject.championsacademyleague.constants.Constants;

import com.academyproject.championsacademyleague.schemas.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.SoapMessage;

import java.util.List;

@Service
public class playerService  extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(playerService.class);

    Constants cons= new Constants();

    @Autowired
    public Jaxb2Marshaller marshaller;

    public WebServiceTemplate template;



    public List<PlayerOut> getAll (PlayerDataInput request) {
        template = new WebServiceTemplate(marshaller);
        template.setDefaultUri(cons.getPlayerGetAllURL());

        PlayerDataOutput response = (PlayerDataOutput) template
                .marshalSendAndReceive(request, message -> ((SoapMessage)message).setSoapAction(cons.getPlayerSOAPGetAll()));

        return response.getPlayerOut();
    }

    public List<PlayerOut> get (PlayerDataInput request) {
        template = new WebServiceTemplate(marshaller);
        template.setDefaultUri(cons.getPlayerGetURL());

        PlayerDataOutput response = (PlayerDataOutput) template
                .marshalSendAndReceive(request, message -> ((SoapMessage)message).setSoapAction(cons.getPlayerSOAPGet()));

        return response.getPlayerOut();
    }

    public List <PlayerOut> update (PlayerDataInput request) {
        template = new WebServiceTemplate(marshaller);
        template.setDefaultUri(cons.getPlayerUpdateURL());

        PlayerDataOutput response = (PlayerDataOutput) template
                .marshalSendAndReceive(request, message -> ((SoapMessage)message).setSoapAction(cons.getPlayerSOAPUpdate()));

        return response.getPlayerOut();
    }

    public List <PlayerOut> create (PlayerDataInput request) {
        template = new WebServiceTemplate(marshaller);
        template.setDefaultUri(cons.getPlayerCreateURL());

        PlayerDataOutput response = (PlayerDataOutput) template
                .marshalSendAndReceive(request, message -> ((SoapMessage)message).setSoapAction(cons.getPlayerSOAPCreate()));

        return response.getPlayerOut();
    }

}
