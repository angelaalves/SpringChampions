package com.academyproject.championsacademyleague.accesingdatamysql.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Optional;

@Controller
@RequestMapping(path="/events")
public class EventsController {

    @Autowired
    private EventsRepository eventsRepository;

    @GetMapping(path="/getall")
    public @ResponseBody Iterable<Event> getAllEvents() {
        // This returns a JSON or XML with the players
        return eventsRepository.findAll();
    }

    @PostMapping(path="/update")
    public @ResponseBody String updateEvents(@RequestParam String idevent, String eventname, String eventdate, String eventtype){
        Optional<Event> event = eventsRepository.findById(Integer.parseInt(idevent));
        event.get().setEventDate(eventdate);
        event.get().setEventName(eventname);
        event.get().setEventType(eventtype);
        eventsRepository.save(event.get());
        return "event updated";
    }

    @PostMapping(path="/create")
    public @ResponseBody String createEvents(@RequestParam String idevent, String eventname, String eventdate, String eventtype){
        Event event = new Event();
        event.setIDEvent(Integer.parseInt(idevent));
        event.setEventName(eventname);
        event.setEventDate(eventdate);
        event.setEventType(eventtype);
        eventsRepository.save(event);
        return "event created";
    }

    @PostMapping(path="/delete")
    public @ResponseBody String createEvents(@RequestParam String idevent){
        eventsRepository.deleteById(Integer.parseInt(idevent));
        return "event deleted";
    }

    @GetMapping(path="/getById")
    public @ResponseBody Event getEventsById(@RequestParam String idevent){
        return eventsRepository.findEventById(idevent);
    }

    @GetMapping(path="/getByEventName")
    public @ResponseBody Iterable<Event> getEventsByEventName(@RequestParam String eventname){
        return eventsRepository.findEventByEventName(eventname);
    }

    @GetMapping(path="/getByEventDate")
    public @ResponseBody Iterable<Event> getEventsByEventDate(@RequestParam String eventdate){
        return eventsRepository.findEventByEventDate(eventdate);
    }

    @GetMapping(path="/getByEventType")
    public @ResponseBody Iterable<Event> getEventsByEventType(@RequestParam String eventtype){
        return eventsRepository.findEventByEventType(eventtype);
    }
}