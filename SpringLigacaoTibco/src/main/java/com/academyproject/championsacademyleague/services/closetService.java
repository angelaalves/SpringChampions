package com.academyproject.championsacademyleague.services;

import com.academyproject.championsacademyleague.constants.Constants;
import com.academyproject.championsacademyleague.schemas.ClosetDataInput;
import com.academyproject.championsacademyleague.schemas.ClosetDataOutput;
import com.academyproject.championsacademyleague.schemas.ClosetOut;
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
public class closetService  extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(closetService.class);

    Constants cons= new Constants();

    @Autowired
    public Jaxb2Marshaller marshaller;
    public WebServiceTemplate template;

    public List<ClosetOut> getAll (ClosetDataInput request) {
        template = new WebServiceTemplate(marshaller);
        template.setDefaultUri(cons.getClosetGetAllURL());
        ClosetDataOutput response = (ClosetDataOutput) template
                .marshalSendAndReceive(request, message -> ((SoapMessage)message).setSoapAction(cons.getClosetSOAPGetAll()));

        return response.getClosetOut();
    }

    public List <ClosetOut> get (ClosetDataInput request) {
        template = new WebServiceTemplate(marshaller);
        template.setDefaultUri(cons.getClosetGetURL());

        ClosetDataOutput response = (ClosetDataOutput) template
                .marshalSendAndReceive(request, message -> ((SoapMessage)message).setSoapAction(cons.getClosetSOAPGet()));

        return response.getClosetOut();
    }

    public List <ClosetOut> update (ClosetDataInput request) {
        template = new WebServiceTemplate(marshaller);
        template.setDefaultUri(cons.getClosetUpdateURL());

        ClosetDataOutput response = (ClosetDataOutput) template
                .marshalSendAndReceive(request, message -> ((SoapMessage)message).setSoapAction(cons.getClosetSOAPUpdate()));

        return response.getClosetOut();
    }

    public List <ClosetOut> create (ClosetDataInput request) {
        template = new WebServiceTemplate(marshaller);
        template.setDefaultUri(cons.getClosetCreateURL());

        ClosetDataOutput response = (ClosetDataOutput) template
                .marshalSendAndReceive(request, message -> ((SoapMessage)message).setSoapAction(cons.getClosetSOAPCreate()));

        return response.getClosetOut();
    }

    public List <ClosetOut> delete (ClosetDataInput request) {
        template = new WebServiceTemplate(marshaller);
        template.setDefaultUri(cons.getClosetDeleteURL());

        ClosetDataOutput response = (ClosetDataOutput) template
                .marshalSendAndReceive(request, message -> ((SoapMessage)message).setSoapAction(cons.getClosetSOAPDelete()));

        return response.getClosetOut();
    }

}

