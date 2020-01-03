package com.academyproject.championsacademyleague.controllers;

import com.academyproject.championsacademyleague.constants.Time;
import com.academyproject.championsacademyleague.schemas.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("rewards")
public class rewardsController {
    @Autowired
    public com.academyproject.championsacademyleague.services.rewardsService rewardsService;
    @Autowired
    public com.academyproject.championsacademyleague.services.playerService playerService;

    /**
     * Connection with angular and the exterior
     * @return
     */

    @RequestMapping("getAll")
    public List<RewardsOut> getAllRewards() {
        RewardsDataInput dataIn= new RewardsDataInput();
        RewardsIn rewardsIn= new RewardsIn("","","","","","","","");
        dataIn.getRewardsIn().add(rewardsIn);
        return rewardsService.getAll(dataIn);

    }

    @RequestMapping("getAllRewardsToApprove")
    public List<RewardsOut> getAllRewardsToApprove() {
        RewardsDataInput dataIn= new RewardsDataInput();
        RewardsIn rewardsIn= new RewardsIn("","","","","","0","", "");
        dataIn.getRewardsIn().add(rewardsIn);
        return rewardsService.get(dataIn);
    }

    @RequestMapping("Create")
        public List<RewardsOut> getCreateRewards(String idReward, String idPlayerGiverFK, String idPlayerReceiverFK, String champiesGiven, String dateOfReward, String approved, String timeSpent, String justification) {
        RewardsDataInput dataIn= new RewardsDataInput();
        RewardsIn rewardsIn= new RewardsIn(idReward,idPlayerGiverFK,idPlayerReceiverFK,champiesGiven,dateOfReward, approved,timeSpent, justification);
        dataIn.getRewardsIn().add(rewardsIn);
        return rewardsService.create(dataIn);
    }

    @RequestMapping("Update")
    public List<RewardsOut> getUpdateRewards(String idReward, String idPlayerGiverFK, String idPlayerReceiverFK, String champiesGiven, String dateOfReward, String approved, String timeSpent, String justification) {
        RewardsDataInput dataIn= new RewardsDataInput();
        RewardsIn rewardsIn= new RewardsIn(idReward,idPlayerGiverFK,idPlayerReceiverFK,champiesGiven,dateOfReward, approved,timeSpent, justification);
        dataIn.getRewardsIn().add(rewardsIn);
        return rewardsService.update(dataIn);
    }

    @RequestMapping("Get")
    public List<RewardsOut> getGetRewards(String idReward, String idPlayerGiverFK, String idPlayerReceiverFK, String champiesGiven, String dateOfReward, String approved, String timeSpent, String justification) {
        RewardsDataInput dataIn= new RewardsDataInput();
        RewardsIn rewardsIn= new RewardsIn(idReward,idPlayerGiverFK,idPlayerReceiverFK,champiesGiven,dateOfReward, approved,timeSpent, justification);
        dataIn.getRewardsIn().add(rewardsIn);
        return rewardsService.get(dataIn);
    }

    @RequestMapping("Delete")
    public List<RewardsOut> getDeleteRewards(String idReward) {
        RewardsDataInput dataIn= new RewardsDataInput();
        RewardsIn rewardsIn= new RewardsIn(idReward,"","","","","","", "");
        dataIn.getRewardsIn().add(rewardsIn);
        return rewardsService.delete(dataIn);
    }
    @RequestMapping("Approve")
    public boolean approveReward(String[] idReward){
        for(int i=0; i<idReward.length;i++) {
            List<RewardsOut> rewards = getGetRewards(idReward[i], "", "", "", "", "", "", "");
            String[] date = rewards.get(0).getDateOfReward().split("T");
            getUpdateRewards(rewards.get(0).getIDReward(), rewards.get(0).getIDPlayerGiverFK(), rewards.get(0).getIDPlayerReceiverFK(), rewards.get(0).getChampiesGiven(), date[0], "1", rewards.get(0).getTimeSpent(), rewards.get(0).getJustification());
            PlayerOut playerGiver = playerService.getPlayerByID(rewards.get(0).getIDPlayerGiverFK());
            PlayerOut playerReceiver = playerService.getPlayerByID(rewards.get(0).getIDPlayerReceiverFK());
            System.out.println(Time.valueOf(rewards.get(0).getTimeSpent()));
            playerService.giveChampies(playerService.getPlayerByID(rewards.get(0).getIDPlayerGiverFK()).getUserName(), playerService.getPlayerByID(rewards.get(0).getIDPlayerReceiverFK()).getUserName(), Integer.valueOf(rewards.get(0).getChampiesGiven()));
        }
        return true;
    }

    @RequestMapping("Disapprove")
    public boolean disapprove(String[] idReward){
        for(int i=0;i<idReward.length;i++) {
            List<RewardsOut> rewards = getGetRewards(idReward[i], "", "", "", "", "", "", "");
            String[] date = rewards.get(0).getDateOfReward().split("T");
            getUpdateRewards(rewards.get(0).getIDReward(), rewards.get(0).getIDPlayerGiverFK(), rewards.get(0).getIDPlayerReceiverFK(), "0", date[0], "0", rewards.get(0).getTimeSpent(), rewards.get(0).getJustification());
        }
        return true;
    }

    @RequestMapping("Reward")
    public boolean rewardPlayer(String playerGiver, String playerReceiver, String time, String justification){
        return rewardsService.registry(playerGiver, playerReceiver, Time.valueOf(time), justification);
    }

}