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

import java.util.Date;
import java.util.List;

@Service

public class guildEventsService extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(guildEventsService.class);

    Constants cons= new Constants();

    @Autowired
    private guildService guildService;
    @Autowired
    private eventsService eventsService;

    @Autowired
    public Jaxb2Marshaller marshaller;

    public WebServiceTemplate template;

    public List <GuildEventsOut> get (GuildEventsDataInput request) {
        template = new WebServiceTemplate(marshaller);
        template.setDefaultUri(cons.getGuildEventsGetURL());

        GuildEventsDataOutput response = (GuildEventsDataOutput) template
                .marshalSendAndReceive(request, message -> ((SoapMessage)message).setSoapAction(cons.getGuildEventsSOAPGet()));

        return response.getGuildEventsOut();
    }


    public List <GuildEventsOut> create (GuildEventsDataInput request) {
        template = new WebServiceTemplate(marshaller);
        template.setDefaultUri(cons.getGuildEventsCreateURL());

        GuildEventsDataOutput response = (GuildEventsDataOutput) template
                .marshalSendAndReceive(request, message -> ((SoapMessage)message).setSoapAction(cons.getGuildEventsSOAPCreate()));

        return response.getGuildEventsOut();
    }

    public List <GuildEventsOut> delete (GuildEventsDataInput request) {
        template = new WebServiceTemplate(marshaller);
        template.setDefaultUri(cons.getGuildEventsDeleteURL());

        GuildEventsDataOutput response = (GuildEventsDataOutput) template
                .marshalSendAndReceive(request, message -> ((SoapMessage)message).setSoapAction(cons.getGuildEventsSOAPDelete()));

        return response.getGuildEventsOut();
    }

    public List<GuildEventsOut> createGuildEventsList(String guildName, String startDate) {
        GuildDataInput dataIn= new GuildDataInput();
        GuildIn guildIn= new GuildIn("",guildName,"","","","");
        dataIn.getGuildIn().add(guildIn);
        for(GuildOut guild: guildService.get(dataIn)){
            if(guild.getStartDate().equals(startDate)){
                EventsDataInput eventsDataIn= new EventsDataInput();
                EventsIn eventsIn= new EventsIn("","","","");
                eventsDataIn.getEventsIn().add(eventsIn);
                List<EventsOut> eventsList=eventsService.getAll(eventsDataIn);
                for(EventsOut event: eventsList) {
                    if(Date.parse(guild.getStartDate())<Date.parse(event.getEventDate())&& Date.parse(guild.getEndDate())>Date.parse(event.getEventDate())) {
                        GuildEventsDataInput infoIn = new GuildEventsDataInput();
                        GuildEventsIn guildEventsIn = new GuildEventsIn(guild.getIDGuild(), event.getIDEvent());
                        infoIn.getGuildEventsIn().add(guildEventsIn);
                        return create(infoIn);
                    }
                }
            }
        }
        return null;
    }
}
