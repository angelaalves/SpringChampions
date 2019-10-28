package com.academyproject.championsacademyleague.services;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class Config {
    @Bean
    public Jaxb2Marshaller marshaller() {
        System.out.println("Marsheller jaxb2");
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setPackagesToScan("com.spring.academy.SpringChampionsAcademy.schemas");
        return marshaller;
    }
}
