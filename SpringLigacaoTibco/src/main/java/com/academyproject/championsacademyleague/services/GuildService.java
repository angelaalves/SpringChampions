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
public class GuildService {
    private static final Logger log = LoggerFactory.getLogger(GuildService.class);

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
    public List<GuildOut> getAll (GuildDataInput request) {
        template = new WebServiceTemplate(marshaller);
        template.setDefaultUri(cons.getGuildGetAllURL());
        /** SoapActionCallback soapActionCallback = new SoapActionCallback(cons.getSOAPURL());
         DataOutput response = (DataOutput) getWebServiceTemplate()
         .marshalSendAndReceive(request, soapActionCallback );
         String responseString = response.getVideoOut().toString();

         **/
        GuildDataOutput response = (GuildDataOutput) template
                .marshalSendAndReceive(request, message -> ((SoapMessage)message).setSoapAction(cons.getGuildSOAPGetAll()));

        return response.getGuildOut();
    }

    public List <GuildOut> get (GuildDataInput request) {
        template = new WebServiceTemplate(marshaller);
        template.setDefaultUri(cons.getGuildGetURL());

        GuildDataOutput response = (GuildDataOutput) template
                .marshalSendAndReceive(request, message -> ((SoapMessage)message).setSoapAction(cons.getGuildSOAPGet()));

        return response.getGuildOut();
    }

    public List <GuildOut> update (GuildDataInput request) {
        template = new WebServiceTemplate(marshaller);
        template.setDefaultUri(cons.getGuildUpdateURL());

        GuildDataOutput response = (GuildDataOutput) template
                .marshalSendAndReceive(request, message -> ((SoapMessage)message).setSoapAction(cons.getGuildSOAPUpdate()));

        return response.getGuildOut();
    }

    public List <GuildOut> create (GuildDataInput request) {
        template = new WebServiceTemplate(marshaller);
        template.setDefaultUri(cons.getGuildCreateURL());

        GuildDataOutput response = (GuildDataOutput) template
                .marshalSendAndReceive(request, message -> ((SoapMessage)message).setSoapAction(cons.getGuildSOAPCreate()));

        return response.getGuildOut();
    }

    public List <GuildOut> delete (GuildDataInput request) {
        template = new WebServiceTemplate(marshaller);
        template.setDefaultUri(cons.getGuildDeleteURL());

        GuildDataOutput response = (GuildDataOutput) template
                .marshalSendAndReceive(request, message -> ((SoapMessage)message).setSoapAction(cons.getGuildSOAPDelete()));

        return response.getGuildOut();
    }
}
