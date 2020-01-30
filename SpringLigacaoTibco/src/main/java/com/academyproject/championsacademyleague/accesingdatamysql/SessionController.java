package com.academyproject.championsacademyleague.accesingdatamysql;

import com.academyproject.championsacademyleague.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("session")
public class SessionController {
    @Autowired
    public SessionService sessionService;

    @RequestMapping("loggout")
    public boolean loggout(@RequestParam String email){
        return sessionService.removingPlayer(email);
    }
}