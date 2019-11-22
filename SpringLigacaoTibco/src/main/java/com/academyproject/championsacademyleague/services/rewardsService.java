package com.academyproject.championsacademyleague.services;

import com.academyproject.championsacademyleague.Configurations.timeValue;
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

import java.util.List;

@Service
public class rewardsService  extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(rewardsService.class);

    Constants cons= new Constants();

    @Autowired
    public Jaxb2Marshaller marshaller;
    @Autowired
    public com.academyproject.championsacademyleague.services.playerService playerService;
    public WebServiceTemplate template;



    public List<RewardsOut> getAll (RewardsDataInput request) {
        template = new WebServiceTemplate(marshaller);
        template.setDefaultUri(cons.getRewardsGetAllURL());

        RewardsDataOutput response = (RewardsDataOutput) template
                .marshalSendAndReceive(request, message -> ((SoapMessage)message).setSoapAction(cons.getRewardsSOAPGetAll()));

        return response.getRewardsOut();
    }

    public List <RewardsOut> get (RewardsDataInput request) {
        template = new WebServiceTemplate(marshaller);
        template.setDefaultUri(cons.getRewardsGetURL());

        RewardsDataOutput response = (RewardsDataOutput) template
                .marshalSendAndReceive(request, message -> ((SoapMessage)message).setSoapAction(cons.getRewardsSOAPGet()));

        return response.getRewardsOut();
    }

    public List <RewardsOut> update (RewardsDataInput request) {
        template = new WebServiceTemplate(marshaller);
        template.setDefaultUri(cons.getRewardsUpdateURL());

        RewardsDataOutput response = (RewardsDataOutput) template
                .marshalSendAndReceive(request, message -> ((SoapMessage)message).setSoapAction(cons.getRewardsSOAPUpdate()));

        return response.getRewardsOut();
    }

    public List <RewardsOut> create (RewardsDataInput request) {
        template = new WebServiceTemplate(marshaller);
        template.setDefaultUri(cons.getRewardsCreateURL());

        RewardsDataOutput response = (RewardsDataOutput) template
                .marshalSendAndReceive(request, message -> ((SoapMessage)message).setSoapAction(cons.getRewardsSOAPCreate()));

        return response.getRewardsOut();
    }

    public List <RewardsOut> delete (RewardsDataInput request) {
        template = new WebServiceTemplate(marshaller);
        template.setDefaultUri(cons.getRewardsDeleteURL());

        RewardsDataOutput response = (RewardsDataOutput) template
                .marshalSendAndReceive(request, message -> ((SoapMessage)message).setSoapAction(cons.getRewardsSOAPDelete()));

        return response.getRewardsOut();
    }

    public boolean registry(String playerGiver, String playerReceiver, Time time){
        List<PlayerOut> playersList=playerService.getAll(new PlayerDataInput());
        RewardsDataInput registry=new RewardsDataInput();
        PlayerOut giver=new PlayerOut();
        PlayerOut receiver=new PlayerOut();
        int value=new timeValue().timeToValue(time);
        for (int i=0; i<playersList.size(); i++){
            if(playersList.get(i).getUserName().equals(playerGiver)){
                giver = playersList.get(i);
            }else if(playersList.get(i).getUserName().equals(playerReceiver)){
                receiver=playersList.get(i);
            }
        }
        if(giver.getIDPlayer()==null || receiver.getIDPlayer()==null)
            return false;
        RewardsIn registryInfo=new RewardsIn("", giver.getIDPlayer(), receiver.getIDPlayer(), String.valueOf(value), new dateFormatter().DateFormatter(), String.valueOf(1), String.valueOf(time));
        registry.getRewardsIn().add(registryInfo);
        create(registry);
        return true;
    }
}
