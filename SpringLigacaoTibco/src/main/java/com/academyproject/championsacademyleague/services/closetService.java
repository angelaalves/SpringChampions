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
import org.springframework.ws.soap.SoapMessage;

import java.io.DataInput;
import java.io.DataOutput;
import java.util.List;

@Service
public class closetService {
    private static final Logger log = LoggerFactory.getLogger(videoService.class);

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
    public List<ClosetOut> getAll (ClosetDataInput request) {
        template = new WebServiceTemplate(marshaller);
        template.setDefaultUri(cons.getVideoGetAllURL());
        /** SoapActionCallback soapActionCallback = new SoapActionCallback(cons.getSOAPURL());
         DataOutput response = (DataOutput) getWebServiceTemplate()
         .marshalSendAndReceive(request, soapActionCallback );
         String responseString = response.getVideoOut().toString();

         **/
        ClosetDataOutput response = (ClosetDataOutput) template
                .marshalSendAndReceive(request, message -> ((SoapMessage)message).setSoapAction(cons.getVideoSOAPGetAll()));

        return response.getClosetOut();
    }

    public List <ClosetOut> get (ClosetDataInput request) {
        template = new WebServiceTemplate(marshaller);
        template.setDefaultUri(cons.getVideoGetURL());

        ClosetDataOutput response = (ClosetDataOutput) template
                .marshalSendAndReceive(request, message -> ((SoapMessage)message).setSoapAction(cons.getVideoSOAPGet()));

        return response.getClosetOut();
    }

    public List <ClosetOut> update (ClosetDataInput request) {
        template = new WebServiceTemplate(marshaller);
        template.setDefaultUri(cons.getVideoUpdateURL());

        ClosetDataOutput response = (ClosetDataOutput) template
                .marshalSendAndReceive(request, message -> ((SoapMessage)message).setSoapAction(cons.getVideoSOAPUpdate()));

        return response.getClosetOut();
    }

    public List <ClosetOut> create (ClosetDataInput request) {
        template = new WebServiceTemplate(marshaller);
        template.setDefaultUri(cons.getVideoCreateURL());

        ClosetDataOutput response = (ClosetDataOutput) template
                .marshalSendAndReceive(request, message -> ((SoapMessage)message).setSoapAction(cons.getVideoSOAPCreate()));

        return response.getClosetOut();
    }

    public List <ClosetOut> delete (ClosetDataInput request) {
        template = new WebServiceTemplate(marshaller);
        template.setDefaultUri(cons.getVideoDeleteURL());

        ClosetDataOutput response = (ClosetDataOutput) template
                .marshalSendAndReceive(request, message -> ((SoapMessage)message).setSoapAction(cons.getVideoSOAPDelete()));

        return response.getClosetOut();
    }

}

