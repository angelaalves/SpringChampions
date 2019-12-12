package com.academyproject.championsacademyleague.services;

import com.academyproject.championsacademyleague.constants.Constants;
import com.academyproject.championsacademyleague.schemas.EventsDataInput;
import com.academyproject.championsacademyleague.schemas.EventsDataOutput;
import com.academyproject.championsacademyleague.schemas.EventsOut;
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
public class eventsService extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(eventsService.class);

    Constants cons= new Constants();

    @Autowired
    public Jaxb2Marshaller marshaller;

    public WebServiceTemplate template;

    public List<EventsOut> getAll (EventsDataInput request) {
        template = new WebServiceTemplate(marshaller);
        template.setDefaultUri(cons.getEventsGetAllURL());
        EventsDataOutput response = (EventsDataOutput) template
                .marshalSendAndReceive(request, message -> ((SoapMessage)message).setSoapAction(cons.getEventsSOAPGetAll()));

        return response.getEventsOut();
    }

    public List<EventsOut> get (EventsDataInput request) {
        template = new WebServiceTemplate(marshaller);
        template.setDefaultUri(cons.getEventsGetURL());
        EventsDataOutput response = (EventsDataOutput) template
                .marshalSendAndReceive(request, message -> ((SoapMessage)message).setSoapAction(cons.getEventsSOAPGet()));

        return response.getEventsOut();
    }

    public List<EventsOut> update (EventsDataInput request) {
        template = new WebServiceTemplate(marshaller);
        template.setDefaultUri(cons.getEventsUpdateURL());

        EventsDataOutput response = (EventsDataOutput) template
                .marshalSendAndReceive(request, message -> ((SoapMessage)message).setSoapAction(cons.getEventsSOAPUpdate()));

        return response.getEventsOut();
    }

    public List<EventsOut> create (EventsDataInput request) {
        template = new WebServiceTemplate(marshaller);
        template.setDefaultUri(cons.getEventsCreateURL());

        EventsDataOutput response = (EventsDataOutput) template
                .marshalSendAndReceive(request, message -> ((SoapMessage)message).setSoapAction(cons.getEventsSOAPCreate()));

        return response.getEventsOut();
    }

    public List<EventsOut> delete (EventsDataInput request) {
        template = new WebServiceTemplate(marshaller);
        template.setDefaultUri(cons.getEventsDeleteURL());

        EventsDataOutput response = (EventsDataOutput) template
                .marshalSendAndReceive(request, message -> ((SoapMessage)message).setSoapAction(cons.getEventsSOAPDelete()));

        return response.getEventsOut();
    }

}