package com.academyproject.championsacademyleague.services;

import com.academyproject.championsacademyleague.constants.Constants;
import com.academyproject.championsacademyleague.schemas.VideoDataInput;
import com.academyproject.championsacademyleague.schemas.VideoDataOutput;
import com.academyproject.championsacademyleague.schemas.VideoOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.SoapMessage;

import java.io.*;
import java.net.*;
import java.util.List;

@Service
public class videoService extends WebServiceGatewaySupport {
    private static final Logger log = LoggerFactory.getLogger(videoService.class);

    Constants cons= new Constants();

    @Autowired
    public Jaxb2Marshaller marshaller;

    public WebServiceTemplate template;

    public List<VideoOutput> getAll (VideoDataInput request) {
        template = new WebServiceTemplate(marshaller);
        template.setDefaultUri(cons.getVideoGetAllURL());
        VideoDataOutput response = (VideoDataOutput) template
                .marshalSendAndReceive(request, message -> ((SoapMessage)message).setSoapAction(cons.getVideoSOAPGetAll()));

        return response.getVideoOutput();
    }

    public List <VideoOutput> get (VideoDataInput request) {
        template = new WebServiceTemplate(marshaller);
        template.setDefaultUri(cons.getVideoGetURL());

        VideoDataOutput response = (VideoDataOutput) template
            .marshalSendAndReceive(request, message -> ((SoapMessage)message).setSoapAction(cons.getVideoSOAPGet()));

        return response.getVideoOutput();
 }

    public List <VideoOutput> update (VideoDataInput request) {
        template = new WebServiceTemplate(marshaller);
        template.setDefaultUri(cons.getVideoUpdateURL());

        VideoDataOutput response = (VideoDataOutput) template
            .marshalSendAndReceive(request, message -> ((SoapMessage)message).setSoapAction(cons.getVideoSOAPUpdate()));

        return response.getVideoOutput();
 }

    public List <VideoOutput> create (VideoDataInput request) {
        template = new WebServiceTemplate(marshaller);
        template.setDefaultUri(cons.getVideoCreateURL());

        VideoDataOutput response = (VideoDataOutput) template
            .marshalSendAndReceive(request, message -> ((SoapMessage)message).setSoapAction(cons.getVideoSOAPCreate()));

        return response.getVideoOutput();
 }

    public List <VideoOutput> delete (VideoDataInput request) {
        template = new WebServiceTemplate(marshaller);
        template.setDefaultUri(cons.getVideoDeleteURL());

        VideoDataOutput response = (VideoDataOutput) template
            .marshalSendAndReceive(request, message -> ((SoapMessage)message).setSoapAction(cons.getVideoSOAPDelete()));

        return response.getVideoOutput();
 }

}
