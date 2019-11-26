package com.academyproject.championsacademyleague.controllers;

import com.academyproject.championsacademyleague.schemas.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("rewards")
public class rewardsController {
    @Autowired
    public com.academyproject.championsacademyleague.services.rewardsService rewardsService;

    /**
     * Connection with angular and the exterior
     * @return
     */

    @RequestMapping("getAll")
    public List<RewardsOut> getAllRewards() {
        RewardsDataInput dataIn= new RewardsDataInput();
        RewardsIn rewardsIn= new RewardsIn("","","","","","","");
        dataIn.getRewardsIn().add(rewardsIn);
        return rewardsService.getAll(dataIn);

    }

    @RequestMapping("Create")
        public List<RewardsOut> getCreateRewards(String idReward, String idPlayerGiverFK, String idPlayerReceiverFK, String champiesGiven, String dateOfReward, String approved, String timeSpent) {
        RewardsDataInput dataIn= new RewardsDataInput();
        RewardsIn rewardsIn= new RewardsIn(idReward,idPlayerGiverFK,idPlayerReceiverFK,champiesGiven,dateOfReward, approved,timeSpent);
        dataIn.getRewardsIn().add(rewardsIn);
        return rewardsService.create(dataIn);
    }

    @RequestMapping("Update")
    public List<RewardsOut> getUpdateRewards(String idReward, String idPlayerGiverFK, String idPlayerReceiverFK, String champiesGiven, String dateOfReward, String approved, String timeSpent) {
        RewardsDataInput dataIn= new RewardsDataInput();
        RewardsIn rewardsIn= new RewardsIn(idReward,idPlayerGiverFK,idPlayerReceiverFK,champiesGiven,dateOfReward, approved,timeSpent);
        dataIn.getRewardsIn().add(rewardsIn);
        return rewardsService.update(dataIn);
    }

    @RequestMapping("Get")
    public List<RewardsOut> getGetRewards(String idReward, String idPlayerGiverFK, String idPlayerReceiverFK, String champiesGiven, String dateOfReward, String approved, String timeSpent) {
        RewardsDataInput dataIn= new RewardsDataInput();
        RewardsIn rewardsIn= new RewardsIn(idReward,idPlayerGiverFK,idPlayerReceiverFK,champiesGiven,dateOfReward, approved,timeSpent);
        dataIn.getRewardsIn().add(rewardsIn);
        return rewardsService.get(dataIn);
    }

    @RequestMapping("Delete")
    public List<RewardsOut> getDeleteRewards(String idReward) {
        RewardsDataInput dataIn= new RewardsDataInput();
        RewardsIn rewardsIn= new RewardsIn(idReward,"","","","","","");
        dataIn.getRewardsIn().add(rewardsIn);
        return rewardsService.delete(dataIn);
    }
}