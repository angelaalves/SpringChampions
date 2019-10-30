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
public class watchedVideosService  extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(watchedVideosService.class);

    Constants cons= new Constants();

    @Autowired
    public Jaxb2Marshaller marshaller;

    public WebServiceTemplate template;



    public List<WatchedVideosOut> getAll (WatchedVideosDataInput request) {
        template = new WebServiceTemplate(marshaller);
        template.setDefaultUri(cons.getWatchedVideosGetAllURL());

        WatchedVideosDataOutput response = (WatchedVideosDataOutput) template
                .marshalSendAndReceive(request, message -> ((SoapMessage)message).setSoapAction(cons.getWatchedVideosSOAPGetAll()));

        return response.getWatchedVideosOut();
    }

    public List <WatchedVideosOut> get (WatchedVideosDataInput request) {
        template = new WebServiceTemplate(marshaller);
        template.setDefaultUri(cons.getWatchedVideosGetURL());

        WatchedVideosDataOutput response = (WatchedVideosDataOutput) template
                .marshalSendAndReceive(request, message -> ((SoapMessage)message).setSoapAction(cons.getWatchedVideosSOAPGet()));

        return response.getWatchedVideosOut();
    }


    public List <WatchedVideosOut> create (WatchedVideosDataInput request) {
        template = new WebServiceTemplate(marshaller);
        template.setDefaultUri(cons.getWatchedVideosCreateURL());

        WatchedVideosDataOutput response = (WatchedVideosDataOutput) template
                .marshalSendAndReceive(request, message -> ((SoapMessage)message).setSoapAction(cons.getWatchedVideosSOAPCreate()));

        return response.getWatchedVideosOut();
    }

    public List <WatchedVideosOut> delete (WatchedVideosDataInput request) {
        template = new WebServiceTemplate(marshaller);
        template.setDefaultUri(cons.getWatchedVideosDeleteURL());

        WatchedVideosDataOutput response = (WatchedVideosDataOutput) template
                .marshalSendAndReceive(request, message -> ((SoapMessage)message).setSoapAction(cons.getWatchedVideosSOAPDelete()));

        return response.getWatchedVideosOut();
    }

}
