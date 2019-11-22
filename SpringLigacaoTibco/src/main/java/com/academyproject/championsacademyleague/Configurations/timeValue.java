package com.academyproject.championsacademyleague.Configurations;

import com.academyproject.championsacademyleague.constants.Time;
import org.springframework.stereotype.Component;

@Component
public class timeValue {

    public int timeToValue(Time time){
        int value=0;
        switch(time){
            case SHORT:
                value=1;
                break;
            case MEDIUM:
                value=2;
                break;
            case LONG:
                value=3;
                break;
            default:
                break;
        }
        return value;
    }
}
