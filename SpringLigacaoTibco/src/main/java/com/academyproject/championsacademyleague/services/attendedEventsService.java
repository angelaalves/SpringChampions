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
public class attendedEventsService extends WebServiceGatewaySupport {
    private static final Logger log = LoggerFactory.getLogger(attendedEventsService.class);

    Constants cons= new Constants();

    @Autowired
    public Jaxb2Marshaller marshaller;
    public WebServiceTemplate template;

    public List <AttendedEventsOut> get (AttendedEventsDataInput request) {
        template = new WebServiceTemplate(marshaller);
        template.setDefaultUri(cons.getAttendedEventsGetURL());

        AttendedEventsDataOutput response = (AttendedEventsDataOutput) template
                .marshalSendAndReceive(request, message -> ((SoapMessage)message).setSoapAction(cons.getAttendedEventsSOAPGet()));

        return response.getAttendedEventsOut();
    }


    public List <AttendedEventsOut> create (AttendedEventsDataInput request) {
        template = new WebServiceTemplate(marshaller);
        template.setDefaultUri(cons.getAttendedEventsCreateURL());

        AttendedEventsDataOutput response = (AttendedEventsDataOutput) template
                .marshalSendAndReceive(request, message -> ((SoapMessage)message).setSoapAction(cons.getAttendedEventsSOAPCreate()));

        return response.getAttendedEventsOut();
    }

    public List <AttendedEventsOut> delete (AttendedEventsDataInput request) {
        template = new WebServiceTemplate(marshaller);
        template.setDefaultUri(cons.getAttendedEventsDeleteURL());

        AttendedEventsDataOutput response = (AttendedEventsDataOutput) template
                .marshalSendAndReceive(request, message -> ((SoapMessage)message).setSoapAction(cons.getAttendedEventsSOAPDelete()));

        return response.getAttendedEventsOut();
    }

}
