package com.academyproject.championsacademyleague.constants;

import com.academyproject.championsacademyleague.services.dateFormatter;

import java.util.Date;

public class NotificationView {
    private String from="";
    private String to="";
    private String date="";
    private String hour="";


    public NotificationView(String from, String to){
        this.from=from;
        this.to=to;
        this.date=new dateFormatter().DateFormatter();
        this.hour=new dateFormatter().timeFormatter();
    }
    public NotificationView(String from, String to, String date, String hour){
        this.from=from;
        this.to=to;
        this.date=date;
        this.hour=hour;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getDate() {
        return date;
    }

    public String getHour() {
        return hour;
    }
}