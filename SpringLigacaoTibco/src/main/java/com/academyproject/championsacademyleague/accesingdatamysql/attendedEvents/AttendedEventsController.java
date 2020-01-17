package com.academyproject.championsacademyleague.accesingdatamysql.attendedEvents;

import com.academyproject.championsacademyleague.accesingdatamysql.guild.Guild;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="attendedEvents")
public class AttendedEventsController {

    @Autowired
    private AttendedEventsRepository attendedEventsRepository;

    @GetMapping(path="/getall")
    public @ResponseBody Iterable<AttendedEvents> getAllAttendedEvents() {
        // This returns a JSON or XML with the players
        return attendedEventsRepository.findAll();
    }
}
