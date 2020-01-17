package com.academyproject.championsacademyleague.accesingdatamysql.events;

import com.academyproject.championsacademyleague.accesingdatamysql.guild.Guild;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(name="/event")
public class EventsController {

    @Autowired
    private EventsRepository eventsRepository;

    @GetMapping(path="/getall")
    public @ResponseBody Iterable<Events> getAllEvents() {
        // This returns a JSON or XML with the players
        return eventsRepository.findAll();
    }
}
