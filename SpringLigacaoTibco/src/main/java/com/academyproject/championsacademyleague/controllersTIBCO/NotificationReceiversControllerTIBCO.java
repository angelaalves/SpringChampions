package com.academyproject.championsacademyleague.controllersTIBCO;

import com.academyproject.championsacademyleague.schemas.NotificationReceiversDataInput;
import com.academyproject.championsacademyleague.schemas.NotificationReceiversIn;
import com.academyproject.championsacademyleague.schemas.NotificationReceiversOut;
import com.academyproject.championsacademyleague.services.NotificationReceiversService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("notificationreceivers")
public class NotificationReceiversControllerTIBCO {

    @Autowired
    public NotificationReceiversService notificationReceiversService;

    @RequestMapping("getAll")
    public List<NotificationReceiversOut> getAllNotificationReceivers() {
        NotificationReceiversDataInput dataIn = new NotificationReceiversDataInput();
        NotificationReceiversIn notificationReceiversIn = new NotificationReceiversIn("","","","","");
        dataIn.getNotificationReceiversIn().add(notificationReceiversIn);
        return notificationReceiversService.getAll(dataIn);
    }

    @RequestMapping("Create")
    public List<NotificationReceiversOut> getCreateNotificationReceiver(String idNotificationReceiver, String idPlayerReceiverFK, String ID_Notification_FK, String ID_Guild_FK, String notificationSeen) {
        NotificationReceiversDataInput dataIn= new NotificationReceiversDataInput();
        NotificationReceiversIn notificationReceiversIn= new NotificationReceiversIn(ID_Guild_FK,ID_Notification_FK, idNotificationReceiver,idPlayerReceiverFK,notificationSeen);
        dataIn.getNotificationReceiversIn().add(notificationReceiversIn);
        return notificationReceiversService.create(dataIn);
    }

    @RequestMapping("Update")
    public List<NotificationReceiversOut> getUpdateNotificationReceiver(String idNotificationReceiver, String idPlayerReceiverFK, String ID_Notification_FK, String ID_Guild_FK, String notificationSeen) {
        NotificationReceiversDataInput dataIn= new NotificationReceiversDataInput();
        NotificationReceiversIn notificationReceiversIn= new NotificationReceiversIn(ID_Guild_FK,ID_Notification_FK, idNotificationReceiver,idPlayerReceiverFK,notificationSeen);
        dataIn.getNotificationReceiversIn().add(notificationReceiversIn);
        return notificationReceiversService.update(dataIn);
    }

    @RequestMapping("Get")
    public List<NotificationReceiversOut> getGetNotificationReceiver(String idNotificationReceiver, String idPlayerReceiverFK, String ID_Notification_FK, String ID_Guild_FK, String notificationSeen) {
        NotificationReceiversDataInput dataIn= new NotificationReceiversDataInput();
        NotificationReceiversIn notificationReceiversIn= new NotificationReceiversIn(ID_Guild_FK,ID_Notification_FK, idNotificationReceiver,idPlayerReceiverFK,notificationSeen);
        dataIn.getNotificationReceiversIn().add(notificationReceiversIn);
        return notificationReceiversService.get(dataIn);
    }

    @RequestMapping("Delete")
    public List<NotificationReceiversOut> getDeleteNotificationReceiver(String idNotificationReceiver, String idPlayerReceiverFK, String ID_Notification_FK, String ID_Guild_FK) {
        NotificationReceiversDataInput dataIn = new NotificationReceiversDataInput();
        NotificationReceiversIn notificationReceiversIn = new NotificationReceiversIn(ID_Guild_FK,ID_Notification_FK, idNotificationReceiver,idPlayerReceiverFK,"");
        dataIn.getNotificationReceiversIn().add(notificationReceiversIn);
        return notificationReceiversService.delete(dataIn);
    }
}