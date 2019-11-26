package com.academyproject.championsacademyleague.services;

import com.academyproject.championsacademyleague.constants.NotificationView;
import com.academyproject.championsacademyleague.constants.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service
public class NotificationService {
    @Autowired
    public SessionService sessionService;
    public RestTemplate restTemplate=new RestTemplate();

    public void send(NotificationView notification){
        String to = notification.getTo();
        //colocar na base de dados e enviar ao player destinatario
        warn();
    }
    public Post warn(){
        String url = "http://localhost:4200/";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        Post post = new Post(1, "warning", "");

        HttpEntity<Post> entity = new HttpEntity<>(post, headers);

        return this.restTemplate.postForObject(url, entity, Post.class);
    }
}