package com.academyproject.championsacademyleague.services;

import com.academyproject.championsacademyleague.constants.Constants;
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
public class NotificationReceiversService {

    private static final Logger log = LoggerFactory.getLogger(playerService.class);

    Constants cons= new Constants();

    @Autowired
    public com.academyproject.championsacademyleague.services.playerService playerService;
    @Autowired
    public com.academyproject.championsacademyleague.services.guildPlayersService guildPlayersService;
    @Autowired
    public com.academyproject.championsacademyleague.services.NotificationService notificationService;

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

    public void createNotificationsByID(String SenderID,String ReceiverID, String justification, String isEvent, String isReward){
        PlayerDataInput dataIn= new PlayerDataInput();
        PlayerIn playerIn= new PlayerIn(SenderID, "", "", "", "", "", "", "", "", "");
        dataIn.getPlayerIn().add(playerIn);
        List<PlayerOut> senderList=playerService.get(dataIn);

        GuildPlayersDataInput GPInput=new GuildPlayersDataInput();
        GuildPlayersIn GPIn=new GuildPlayersIn(senderList.get(0).getIDPlayer(), "",senderList.get(0).getIDPlayer());
        GPInput.getGuildPlayersIn().add(GPIn);
        List<GuildPlayersOut> GPList=guildPlayersService.get(GPInput);

        NotificationsDataInput searchNotifications=new NotificationsDataInput();
        NotificationsIn notificationdata=new NotificationsIn("", "","",senderList.get(0).getIDPlayer(), "", "");
        searchNotifications.getNotificationsIn().add(notificationdata);
        List<NotificationsOut> notificationList=notificationService.get(searchNotifications);

        String notificationID="";
        if(!notificationList.get(0).getIDPlayerSenderFK().equals("Not Found")){
            boolean found=false;
            for(int i=0;i<notificationList.size();i++){
                if(notificationList.get(i).getDescription().equals(justification)){
                    found=true;
                    notificationID=notificationList.get(i).getIDNotification();
                    break;
                }
            }
            if(!found){
                NotificationsDataInput Notifications=new NotificationsDataInput();
                NotificationsIn notification=new NotificationsIn(isEvent, GPList.get(0).getIDGuildFK(), "0", senderList.get(0).getIDPlayer(), isReward, justification);
                Notifications.getNotificationsIn().add(notification);
                notificationService.create(Notifications);

                NotificationsDataInput SearchNotifications=new NotificationsDataInput();
                NotificationsIn searchnotification=new NotificationsIn("", "", "", senderList.get(0).getIDPlayer(), "", "");
                SearchNotifications.getNotificationsIn().add(searchnotification);
                notificationList=notificationService.get(SearchNotifications);
                boolean foundAfter=false;
                for(int i=0;i<notificationList.size();i++){
                    if(notificationList.get(i).getDescription().equals(justification)){
                        found=true;
                        notificationID=notificationList.get(i).getIDNotification();
                        break;
                    }
                }
            }
        }

        NotificationReceiversDataInput notificationReceiver=new NotificationReceiversDataInput();
        NotificationReceiversIn receiversIn=new NotificationReceiversIn(GPList.get(0).getIDGuildFK(), notificationID, "0", ReceiverID, "0");
        notificationReceiver.getNotificationReceiversIn().add(receiversIn);
        create(notificationReceiver);
    }
    public void createNotificationsByUserName(String senderUserName,String receiverUserName, String justification, String isEvent, String isReward){
        PlayerDataInput senderDataIn= new PlayerDataInput();
        PlayerIn senderIn= new PlayerIn("", senderUserName, "", "", "", "", "", "", "", "");
        senderDataIn.getPlayerIn().add(senderIn);
        List<PlayerOut> senderList=playerService.get(senderDataIn);

        PlayerDataInput receiverDataIn= new PlayerDataInput();
        PlayerIn receiverIn= new PlayerIn("", receiverUserName, "", "", "", "", "", "", "", "");
        receiverDataIn.getPlayerIn().add(senderIn);
        List<PlayerOut> receiverList=playerService.get(receiverDataIn);

        GuildPlayersDataInput GPInput=new GuildPlayersDataInput();
        GuildPlayersIn GPIn=new GuildPlayersIn( senderList.get(0).getIDPlayer(),"",senderList.get(0).getIDPlayer());
        GPInput.getGuildPlayersIn().add(GPIn);
        List<GuildPlayersOut> GPList=guildPlayersService.get(GPInput);

        NotificationsDataInput searchNotifications=new NotificationsDataInput();
        NotificationsIn notificationdata=new NotificationsIn("", "","",senderList.get(0).getIDPlayer(), "", "");
        searchNotifications.getNotificationsIn().add(notificationdata);
        List<NotificationsOut> notificationList=notificationService.get(searchNotifications);

        String notificationID="";
        if(!notificationList.get(0).getIDPlayerSenderFK().equals("Not Found")){
            boolean found=false;
            for(int i=0;i<notificationList.size();i++){
                if(notificationList.get(i).getDescription().equals(justification)){
                    found=true;
                    notificationID=notificationList.get(i).getIDNotification();
                    break;
                }
            }
            if(!found){
                NotificationsDataInput Notifications=new NotificationsDataInput();
                NotificationsIn notification=new NotificationsIn(isEvent, GPList.get(0).getIDGuildFK(), "0", senderList.get(0).getIDPlayer(), isReward, justification);
                Notifications.getNotificationsIn().add(notification);
                notificationService.create(Notifications);

                NotificationsDataInput SearchNotifications=new NotificationsDataInput();
                NotificationsIn searchnotification=new NotificationsIn("", "", "", senderList.get(0).getIDPlayer(), "", "");
                SearchNotifications.getNotificationsIn().add(searchnotification);
                notificationList=notificationService.get(SearchNotifications);
                boolean foundAfter=false;
                for(int i=0;i<notificationList.size();i++){
                    if(notificationList.get(i).getDescription().equals(justification)){
                        found=true;
                        notificationID=notificationList.get(i).getIDNotification();
                        break;
                    }
                }
            }
        }

        NotificationReceiversDataInput notificationReceiver=new NotificationReceiversDataInput();
        NotificationReceiversIn receiversIn=new NotificationReceiversIn(GPList.get(0).getIDGuildFK(), notificationID, "0", receiverList.get(0).getIDPlayer(), "0");
        notificationReceiver.getNotificationReceiversIn().add(receiversIn);
        create(notificationReceiver);
    }
}