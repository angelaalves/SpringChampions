package com.academyproject.championsacademyleague.accesingdatamysql.rewards;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.GeneratedValue;

@Controller
@RequestMapping(path = "reward")
public class RewardController {
    @Autowired
    private RewardRepository rewardRepository;

    @GetMapping(path="/getall")
    public @ResponseBody
    Iterable<Reward> getAllNotificationReceivers() {
        // This returns a JSON or XML with the players
        return rewardRepository.findAll();
    }
}
