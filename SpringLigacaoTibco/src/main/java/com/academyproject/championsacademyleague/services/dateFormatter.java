package com.academyproject.championsacademyleague.services;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class dateFormatter {

    public String DateFormatter(){
        SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
        return String.valueOf(formatter.format(new Date()));
    }
    public String timeFormatter(){
        SimpleDateFormat formatter=new SimpleDateFormat("hh:mm");
        return String.valueOf(formatter.format(new Date()));
    }
}
