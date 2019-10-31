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
public class GuildService  extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(GuildService.class);

    Constants cons= new Constants();

    @Autowired
    public Jaxb2Marshaller marshaller;

    public WebServiceTemplate template;

    public List<GuildOut> getAll (GuildDataInput request) {
        template = new WebServiceTemplate(marshaller);
        template.setDefaultUri(cons.getGuildGetAllURL());
        GuildDataOutput response = (GuildDataOutput) template
                .marshalSendAndReceive(request, message -> ((SoapMessage)message).setSoapAction(cons.getGuildSOAPGetAll()));

        return response.getGuildOut();
    }

    public List <GuildOut> get (GuildDataInput request) {
        template = new WebServiceTemplate(marshaller);
        template.setDefaultUri(cons.getGuildGetURL());

        GuildDataOutput response = (GuildDataOutput) template
                .marshalSendAndReceive(request, message -> ((SoapMessage)message).setSoapAction(cons.getGuildSOAPGet()));

        return response.getGuildOut();
    }

    public List <GuildOut> update (GuildDataInput request) {
        template = new WebServiceTemplate(marshaller);
        template.setDefaultUri(cons.getGuildUpdateURL());

        GuildDataOutput response = (GuildDataOutput) template
                .marshalSendAndReceive(request, message -> ((SoapMessage)message).setSoapAction(cons.getGuildSOAPUpdate()));

        return response.getGuildOut();
    }

    public List <GuildOut> create (GuildDataInput request) {
        template = new WebServiceTemplate(marshaller);
        template.setDefaultUri(cons.getGuildCreateURL());

        GuildDataOutput response = (GuildDataOutput) template
                .marshalSendAndReceive(request, message -> ((SoapMessage)message).setSoapAction(cons.getGuildSOAPCreate()));

        return response.getGuildOut();
    }

    public List <GuildOut> delete (GuildDataInput request) {
        template = new WebServiceTemplate(marshaller);
        template.setDefaultUri(cons.getGuildDeleteURL());

        GuildDataOutput response = (GuildDataOutput) template
                .marshalSendAndReceive(request, message -> ((SoapMessage)message).setSoapAction(cons.getGuildSOAPDelete()));

        return response.getGuildOut();
    }
}
