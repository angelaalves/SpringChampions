package com.academyproject.championsacademyleague.Configurations;

import com.academyproject.championsacademyleague.constants.Time;
import org.springframework.stereotype.Component;

@Component
public class timeValue {

    public int timeToValue(Time time){
        int value=0;
        switch(time){
            case Short:
                value=1;
                break;
            case Medium:
                value=2;
                break;
            case Long:
                value=3;
                break;
            default:
                break;
        }
        return value;
    }
}
