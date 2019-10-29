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
public class skinService {
    private static final Logger log = LoggerFactory.getLogger(skinService.class);

    Constants cons= new Constants();

    @Autowired
    public Jaxb2Marshaller marshaller;

    public WebServiceTemplate template;



    public List<SkinOut> getAll (SkinDataInput request) {
        template = new WebServiceTemplate(marshaller);
        template.setDefaultUri(cons.getSkinGetAllURL());

        SkinDataOutput response = (SkinDataOutput) template
                .marshalSendAndReceive(request, message -> ((SoapMessage)message).setSoapAction(cons.getSkinSOAPGetAll()));

        return response.getSkinOut();
    }

    public List <SkinOut> get (SkinDataInput request) {
        template = new WebServiceTemplate(marshaller);
        template.setDefaultUri(cons.getSkinGetURL());

        SkinDataOutput response = (SkinDataOutput) template
                .marshalSendAndReceive(request, message -> ((SoapMessage)message).setSoapAction(cons.getSkinSOAPGet()));

        return response.getSkinOut();
    }

    public List <SkinOut> update (SkinDataInput request) {
        template = new WebServiceTemplate(marshaller);
        template.setDefaultUri(cons.getSkinUpdateURL());

        SkinDataOutput response = (SkinDataOutput) template
                .marshalSendAndReceive(request, message -> ((SoapMessage)message).setSoapAction(cons.getSkinSOAPUpdate()));

        return response.getSkinOut();
    }

    public List <SkinOut> create (SkinDataInput request) {
        template = new WebServiceTemplate(marshaller);
        template.setDefaultUri(cons.getSkinCreateURL());

        SkinDataOutput response = (SkinDataOutput) template
                .marshalSendAndReceive(request, message -> ((SoapMessage)message).setSoapAction(cons.getSkinSOAPCreate()));

        return response.getSkinOut();
    }

    public List <SkinOut> delete (SkinDataInput request) {
        template = new WebServiceTemplate(marshaller);
        template.setDefaultUri(cons.getSkinDeleteURL());

        SkinDataOutput response = (SkinDataOutput) template
                .marshalSendAndReceive(request, message -> ((SoapMessage)message).setSoapAction(cons.getSkinSOAPDelete()));

        return response.getSkinOut();
    }
}
