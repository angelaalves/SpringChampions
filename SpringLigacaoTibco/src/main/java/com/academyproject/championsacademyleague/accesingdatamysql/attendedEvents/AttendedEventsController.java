package com.academyproject.championsacademyleague.accesingdatamysql.attendedEvents;

import com.academyproject.championsacademyleague.accesingdatamysql.events.Event;
import com.academyproject.championsacademyleague.accesingdatamysql.player.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@Controller
@RequestMapping(path="/attendedEvents")
public class AttendedEventsController {

    @Autowired
    private AttendedEventsRepository attendedEventsRepository;
    private com.academyproject.championsacademyleague.accesingdatamysql.events.EventsController eventsController;
    private com.academyproject.championsacademyleague.accesingdatamysql.player.PlayerController playerController;

    @PostMapping(path="/create")
    public @ResponseBody String createAttendedEvent(@RequestParam String idevent, @RequestParam String idplayer){
        Event event = eventsController.getEventsById(idevent);
        Player player = playerController.getPlayerById(idplayer);
        attendedEventsRepository.save(new AttendedEvents(new AttendedEventsId(event, player)));
        return "attended event created";
    }

    @PostMapping(path="/delete")
    public @ResponseBody String deleteAttendedEventByPlayerId(@RequestParam String ideventfk, @RequestParam String idplayerfk){
        AttendedEvents attendedEvent=attendedEventsRepository.findAttendedEventByIds(ideventfk, idplayerfk);
        attendedEventsRepository.delete(attendedEvent);
        return "attended event deleted";
    }

    @GetMapping(path="/getByPlayerId")
    public @ResponseBody Iterable<AttendedEvents> getAttendedEventByPlayerID(@RequestParam Integer idplayerfk){
        return attendedEventsRepository.findAllById(Collections.singleton(idplayerfk));
    }

    @GetMapping(path="/getByEventId")
    public @ResponseBody Iterable<AttendedEvents> getAttendedEventByEventId(@RequestParam Integer ideventfk){
        return attendedEventsRepository.findAllById(Collections.singleton(ideventfk));
    }

    @GetMapping(path="/getall")
    public @ResponseBody Iterable<AttendedEvents> getAllAttendedEvents() {
        // This returns a JSON or XML with the players
        return attendedEventsRepository.findAll();
    }
}
