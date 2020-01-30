package com.academyproject.championsacademyleague.accesingdatamysql.guildEvents;

import com.academyproject.championsacademyleague.accesingdatamysql.events.Event;
import com.academyproject.championsacademyleague.accesingdatamysql.events.EventsRepository;
import com.academyproject.championsacademyleague.accesingdatamysql.guild.Guild;
import com.academyproject.championsacademyleague.accesingdatamysql.guild.GuildRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Controller
@RequestMapping(path= "guildEvents")
public class GuildEventsController {

    @Autowired
    private GuildEventsRepository guildEventsRepository;
    @Autowired
    private GuildRepository guildRepository;
    @Autowired
    private EventsRepository eventsRepository;
    @Autowired
    private com.academyproject.championsacademyleague.accesingdatamysql.guild.GuildController guildController;
    @Autowired
    private com.academyproject.championsacademyleague.accesingdatamysql.guildEvents.GuildEventsController guildEventsController;
    @Autowired
    private com.academyproject.championsacademyleague.accesingdatamysql.events.EventsController eventsController;

    @GetMapping(path="/getall")
    public @ResponseBody Iterable<GuildEvents> getAllGuildEvents() {
        // This returns a JSON or XML with the players
        return guildEventsRepository.findAll();
    }

    @PostMapping(path="/create")
    public @ResponseBody String createGuildEvents(@RequestParam String idGuildFK, @RequestParam String idEventFK){
        Guild guild=guildRepository.findGuildByID(idGuildFK);
        Event event=eventsRepository.findEventById(idEventFK);
        GuildEventsId id=new GuildEventsId(guild, event);
        GuildEvents guildEvent=new GuildEvents(id);
        guildEventsRepository.save(guildEvent);
        return "guild event created";
    }

    @PostMapping(path="/update")
    public @ResponseBody String updateGuildEvents(@RequestParam String idGuildFK, @RequestParam String idEventFK, @RequestParam String newIdGuildFK, @RequestParam String newIdEventFK){
        GuildEvents guildEvents = guildEventsRepository.findGuildEvent(idGuildFK, idEventFK);
        Event newEvent=eventsRepository.findEventById(newIdEventFK);
        Guild newGuild=guildRepository.findGuildByID(newIdGuildFK);
        guildEvents.setId(new GuildEventsId(newGuild, newEvent));
        guildEventsRepository.save(guildEvents);
        return "guild event updated";
    }

    @PostMapping(path="/delete")
    public @ResponseBody String deleteGuildEvents(@RequestParam String idGuildFK, @RequestParam String idEventFK){
        GuildEvents guildEvent=guildEventsRepository.findGuildEvent(idGuildFK, idEventFK);
        guildEventsRepository.delete(guildEvent);
        return "guild event deleted";
    }

    @GetMapping(path="/getGuildEventByGuildId")
    public @ResponseBody Iterable<GuildEvents> getGuildEventByGuildId(@RequestParam String idGuildFK) {
        // This returns a JSON or XML with the players
        return guildEventsRepository.findGuildEventByGuildId(idGuildFK);
    }

    @GetMapping(path="/getGuildEventByEventId")
    public @ResponseBody Iterable<GuildEvents> getGuildEventByEventId(@RequestParam String idEventFK) {
        // This returns a JSON or XML with the players
        return guildEventsRepository.findGuildEventByEventId(idEventFK);
    }

    @PostMapping(path="/createGuildEventsList")
    public @ResponseBody void createGuildEventsList(@RequestParam String guildName, @RequestParam String startDate) throws ParseException {
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        Guild guild =guildRepository.findGuildByStartDate(startDate).get(0);
        String date=guild.getStartDate().split("T")[0];
        if(date.equals(startDate)){
            Iterable<Event> eventsList = eventsRepository.findAll();
            for(Event event: eventsList) {
                if(format.parse(guild.getStartDate().split("T")[0]).before(format.parse(event.getEventDate().split("T")[0]))&& format.parse(guild.getEndDate().split("T")[0]).after(format.parse(event.getEventDate().split("T")[0]))) {
                    GuildEvents guildEvent = new GuildEvents(new GuildEventsId(guild, event));
                    guildEventsRepository.save(guildEvent);
                    createGuildEvents(String.valueOf(guild.getIDGuild()),String.valueOf(guildEvent.getId().getIDEventFK().getIDEvent()));
                }
            }
        }
    }
}