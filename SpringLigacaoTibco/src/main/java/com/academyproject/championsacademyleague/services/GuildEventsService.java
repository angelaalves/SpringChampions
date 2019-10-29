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

import java.io.DataInput;
import java.io.DataOutput;
import java.util.List;

@Service
public class GuildEventsService {
    private static final Logger log = LoggerFactory.getLogger(GuildEventsService.class);

    Constants cons= new Constants();

    @Autowired
    public Jaxb2Marshaller marshaller;

    public WebServiceTemplate template;



    /**
     public List<VideoOut> getAll (DataInput request) {

     System.out.println("service  getall  Inicio");
     System.out.println(request.toString());
     template = new WebServiceTemplate(marshaller);
     System.out.println("criei o template \n");
     template.setDefaultUri(cons.getGetAllURL());
     System.out.println("já busquei o url \n");




     DataOutput response = (DataOutput) template
     .marshalSendAndReceive(request, message -> ((SoapMessage)message).setSoapAction(cons.getSOAPURL()));



     System.out.println("service  getall  Fim");

     return response.getVideoOut();
     }**/
    public List<GuildEventsOut> getAll (GuildEventsDataInput request) {
        template = new WebServiceTemplate(marshaller);
        template.setDefaultUri(cons.getGuildEventsGetAllURL());
        /** SoapActionCallback soapActionCallback = new SoapActionCallback(cons.getSOAPURL());
         DataOutput response = (DataOutput) getWebServiceTemplate()
         .marshalSendAndReceive(request, soapActionCallback );
         String responseString = response.getVideoOut().toString();

         **/
        GuildEventsDataOutput response = (GuildEventsDataOutput) template
                .marshalSendAndReceive(request, message -> ((SoapMessage)message).setSoapAction(cons.getGuildEventsSOAPGetAll()));

        return response.getGuildEventsOut();
    }

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

}
