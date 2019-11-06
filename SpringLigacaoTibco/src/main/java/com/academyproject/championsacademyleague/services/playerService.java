package com.academyproject.championsacademyleague.services;

import com.academyproject.championsacademyleague.constants.Constants;

import com.academyproject.championsacademyleague.constants.Time;
import com.academyproject.championsacademyleague.schemas.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.SoapMessage;

import java.util.ArrayList;
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

    public boolean giveChampies(String playerGiver, String playerReceiver, Time time){
        List<PlayerOut> playersList=getAll(new PlayerDataInput());
        PlayerOut giver=new PlayerOut();
        PlayerOut receiver=new PlayerOut();
        int value=new timeValue().timeToValue(time);
        for(int i=0; i< playersList.size(); i++){
            if(playersList.get(i).getUserName().equals(playerGiver)){
                giver=playersList.get(i);
            }else if(playersList.get(i).getUserName().equals(playerReceiver)){
                receiver=playersList.get(i);
            }
        }
        System.out.println(giver.toString());
        System.out.println(receiver.getChampiesToGive());
        if((Integer.valueOf(giver.getChampiesToGive())-value)<0 || giver.getChampiesToGive()==null || receiver.getChampiesToGive()==null){
            return false;
        }else{
            giver.setChampiesToGive(String.valueOf(Integer.valueOf(giver.getChampiesToGive())-value));
            PlayerIn giverIn=new PlayerIn(giver.getIDPlayer(), giver.getIDGuildFK(), giver.getUserName(), giver.getEmail(), giver.getPassword(), giver.getGender(), giver.getUserType(), giver.getXP(), giver.getChampiesToGive(), giver.getMyChampies(), giver.getStatus());
            PlayerDataInput inputGiver=new PlayerDataInput();
            inputGiver.getPlayerIn().add(giverIn);
            update(inputGiver);

            receiver.setMyChampies(String.valueOf(Integer.valueOf(receiver.getMyChampies())+value));
            PlayerIn receiverIn=new PlayerIn(receiver.getIDPlayer(), receiver.getIDGuildFK(), receiver.getUserName(), receiver.getEmail(), receiver.getPassword(), receiver.getGender(), receiver.getUserType(), receiver.getXP(), receiver.getChampiesToGive(), receiver.getMyChampies(), receiver.getStatus());
            PlayerDataInput inputReceiver=new PlayerDataInput();
            inputReceiver.getPlayerIn().add(receiverIn);
            update(inputReceiver);

            return true;
        }
    }
}
