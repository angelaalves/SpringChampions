package com.academyproject.championsacademyleague.services;

import com.academyproject.championsacademyleague.constants.Constants;
import com.academyproject.championsacademyleague.schemas.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.SoapMessage;

import java.util.List;

@Service
public class guildPlayersService extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(guildPlayersService.class);

    Constants cons = new Constants();

    @Autowired
    public Jaxb2Marshaller marshaller;

    public WebServiceTemplate template;

    public List<GuildPlayersOut> getAll (GuildPlayersDataInput request) {
        template = new WebServiceTemplate(marshaller);
        template.setDefaultUri(cons.getGuildPlayersGetAllURL());

        GuildPlayersDataOutput response = (GuildPlayersDataOutput) template
                .marshalSendAndReceive(request, message -> ((SoapMessage)message).setSoapAction(cons.getGuildPlayersSOAPGetAll()));

        return response.getGuildPlayersOut();
    }

    public List<GuildPlayersOut> get (GuildPlayersDataInput request) {
        template = new WebServiceTemplate(marshaller);
        template.setDefaultUri(cons.getGuildPlayersGetURL());

        GuildPlayersDataOutput response = (GuildPlayersDataOutput) template
                .marshalSendAndReceive(request, message -> ((SoapMessage)message).setSoapAction(cons.getGuildPlayersSOAPGet()));

        return response.getGuildPlayersOut();
    }

    public List <GuildPlayersOut> create (GuildPlayersDataInput request) {
        template = new WebServiceTemplate(marshaller);
        template.setDefaultUri(cons.getGuildPlayersCreateURL());

        GuildPlayersDataOutput response = (GuildPlayersDataOutput) template
                .marshalSendAndReceive(request, message -> ((SoapMessage)message).setSoapAction(cons.getGuildPlayersSOAPCreate()));

        return response.getGuildPlayersOut();
    }

    public List<GuildPlayersOut> delete (GuildPlayersDataInput request) {
        template = new WebServiceTemplate(marshaller);
        template.setDefaultUri(cons.getGuildPlayersDeleteURL());

        GuildPlayersDataOutput response = (GuildPlayersDataOutput) template
                .marshalSendAndReceive(request, message -> ((SoapMessage)message).setSoapAction(cons.getGuildPlayersSOAPDelete()));

        return response.getGuildPlayersOut();
    }

    public GuildPlayersOut getGuildPlayersByIDGuildmasterFK(String idGuildMasterFK){
        GuildPlayersIn playerIn=new GuildPlayersIn(idGuildMasterFK, "", "");
        GuildPlayersDataInput request=new GuildPlayersDataInput();
        request.getGuildPlayersIn().add(playerIn);
        List<GuildPlayersOut> player=get(request);
        return player.get(0);
    }

    public GuildPlayersOut getGuildPlayersByIDGuildFK(String idGuildFK){
        GuildPlayersIn playerIn=new GuildPlayersIn("", idGuildFK, "");
        GuildPlayersDataInput request=new GuildPlayersDataInput();
        request.getGuildPlayersIn().add(playerIn);
        List<GuildPlayersOut> player=get(request);
        return player.get(0);
    }

    public GuildPlayersOut getGuildPlayersByIDWarriorFK(String idWarriorFK){
        GuildPlayersIn playerIn=new GuildPlayersIn("", "", idWarriorFK);
        GuildPlayersDataInput request=new GuildPlayersDataInput();
        request.getGuildPlayersIn().add(playerIn);
        List<GuildPlayersOut> player=get(request);
        return player.get(0);
    }
}