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
import org.springframework.ws.soap.SoapMessage;

import java.util.List;

@Service
public class videoService {
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
    public List<VideoOutput> getAll (VideoDataInput request) {
        template = new WebServiceTemplate(marshaller);
        template.setDefaultUri(cons.getGetAllURL());
        /** SoapActionCallback soapActionCallback = new SoapActionCallback(cons.getSOAPURL());
         DataOutput response = (DataOutput) getWebServiceTemplate()
         .marshalSendAndReceive(request, soapActionCallback );
         String responseString = response.getVideoOut().toString();

         **/
        VideoDataOutput response = (VideoDataOutput) template
                .marshalSendAndReceive(request, message -> ((SoapMessage)message).setSoapAction(cons.getGetAllURL()));

        return response.getVideoOutput();
    }
/**
 public List <VideoOut>  get (DataInput request) {



 template = new WebServiceTemplate(marshaller);
 template.setDefaultUri(cons.getGetURL());

 DataOutput response = (DataOutput) template
 .marshalSendAndReceive(request, message -> ((SoapMessage)message).setSoapAction(cons.getSOAPURL()));


 return response.getVideoOut();
 }

 public List <VideoOut>  update (DataInput request) {



 template = new WebServiceTemplate(marshaller);
 template.setDefaultUri(cons.getUpdateURL());

 DataOutput response = (DataOutput) template
 .marshalSendAndReceive(request, message -> ((SoapMessage)message).setSoapAction(cons.getSOAPURL()));


 return response.getVideoOut();
 }

 public List <VideoOut> create (DataInput request) {



 template = new WebServiceTemplate(marshaller);
 template.setDefaultUri(cons.getCreateURL());

 DataOutput response = (DataOutput) template
 .marshalSendAndReceive(request, message -> ((SoapMessage)message).setSoapAction(cons.getSOAPURL()));


 return response.getVideoOut();
 }

 public List <VideoOut> delete (DataInput request) {



 template = new WebServiceTemplate(marshaller);
 template.setDefaultUri(cons.getDeleteURL());

 DataOutput response = (DataOutput) template
 .marshalSendAndReceive(request, message -> ((SoapMessage)message).setSoapAction(cons.getSOAPURL()));


 return response.getVideoOut();
 }


 **/

}
