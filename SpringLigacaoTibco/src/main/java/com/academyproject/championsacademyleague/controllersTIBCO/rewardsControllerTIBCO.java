package com.academyproject.championsacademyleague.controllersTIBCO;

import com.academyproject.championsacademyleague.Configurations.timeValue;
import com.academyproject.championsacademyleague.constants.Time;
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
    @Autowired
    public com.academyproject.championsacademyleague.services.playerService playerService;
    @Autowired
    public com.academyproject.championsacademyleague.services.NotificationReceiversService notificationReceiversService;
    @Autowired
    public com.academyproject.championsacademyleague.services.guildPlayersService guildPlayersService;

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
        PlayerOut playerGiver;
        PlayerOut playerReceiver;
        for(int i=0; i<idReward.length;i++) {
            List<RewardsOut> rewards = getGetRewards(idReward[i], "", "", "", "", "", "", "");
            String[] date = rewards.get(0).getDateOfReward().split("T");
            getUpdateRewards(rewards.get(0).getIDReward(), rewards.get(0).getIDPlayerGiverFK(), rewards.get(0).getIDPlayerReceiverFK(), rewards.get(0).getChampiesGiven(), date[0], "1", rewards.get(0).getTimeSpent(), rewards.get(0).getJustification());
            playerGiver = playerService.getPlayerByID(rewards.get(0).getIDPlayerGiverFK());
            playerReceiver=playerService.getPlayerByID((rewards.get(0).getIDPlayerReceiverFK()));
            System.out.println(Time.valueOf(rewards.get(0).getTimeSpent()));
            playerService.giveChampies(playerService.getPlayerByID(rewards.get(0).getIDPlayerGiverFK()).getUserName(), playerService.getPlayerByID(rewards.get(0).getIDPlayerReceiverFK()).getUserName(), Integer.valueOf(rewards.get(0).getChampiesGiven()));
            if(rewards.get(0).getChampiesGiven().equals("1")){
                notificationReceiversService.createNotificationsByID(rewards.get(0).getIDPlayerGiverFK(), rewards.get(0).getIDPlayerReceiverFK(), playerGiver.getUserName()+" gave you "+rewards.get(0).getChampiesGiven()+" champy for your work", "0", "1");
                notificationReceiversService.createNotificationsByID( rewards.get(0).getIDPlayerReceiverFK(), rewards.get(0).getIDPlayerGiverFK(), "You gave "+rewards.get(0).getChampiesGiven()+" champy to "+playerReceiver.getUserName(), "0", "1");
            }else{
                notificationReceiversService.createNotificationsByID(rewards.get(0).getIDPlayerGiverFK(), rewards.get(0).getIDPlayerReceiverFK(), playerGiver.getUserName()+" gave you "+rewards.get(0).getChampiesGiven()+" champies for your work", "0", "1");
                notificationReceiversService.createNotificationsByID( rewards.get(0).getIDPlayerReceiverFK(), rewards.get(0).getIDPlayerGiverFK(), "You gave "+rewards.get(0).getChampiesGiven()+" champies to "+playerReceiver.getUserName(), "0", "1");
            }

        }

        return true;
    }

    @RequestMapping("Disapprove")
    public boolean disapprove(String[] idReward){
        for(int i=0;i<idReward.length;i++) {
            List<RewardsOut> rewards = getGetRewards(idReward[i], "", "", "", "", "", "", "");
            String[] date = rewards.get(0).getDateOfReward().split("T");
            getUpdateRewards(rewards.get(0).getIDReward(), rewards.get(0).getIDPlayerGiverFK(), rewards.get(0).getIDPlayerReceiverFK(), "0", date[0], "0", rewards.get(0).getTimeSpent(), rewards.get(0).getJustification());

            PlayerOut giver=playerService.getPlayerByID(rewards.get(i).getIDPlayerGiverFK());
            int value=new timeValue().timeToValue(Time.valueOf(rewards.get(i).getTimeSpent()));
            giver.setChampiesToGive(String.valueOf(Integer.valueOf(giver.getChampiesToGive())+value));
            PlayerDataInput champiesReturn=new PlayerDataInput();
            PlayerIn giverIn=new PlayerIn(giver.getIDPlayer(), giver.getUserName(), giver.getEmail(), giver.getPassword(), giver.getGender(), giver.getUserType(), giver.getXP(), giver.getChampiesToGive(), giver.getMyChampies(), giver.getStatus());
            champiesReturn.getPlayerIn().add(giverIn);
            playerService.update(champiesReturn);

            PlayerDataInput dataIn=new PlayerDataInput();
            PlayerIn playerIn=new PlayerIn(rewards.get(0).getIDPlayerReceiverFK(),"","","","","","","","","");
            dataIn.getPlayerIn().add(playerIn);
            List<PlayerOut> receiver=playerService.get(dataIn);

            notificationReceiversService.createNotificationsByID(rewards.get(0).getIDPlayerGiverFK(), rewards.get(0).getIDPlayerGiverFK(), "Your reward to "+receiver.get(0).getUserName()+" was disapproved", "0", "1");
        }
        return true;
    }

    @RequestMapping("Reward")
    public void rewardPlayer(String playerGiver, String playerReceiver, String time, String justification){
        rewardsService.registry(playerGiver, playerReceiver, Time.valueOf(time), justification);

        PlayerDataInput dataIn=new PlayerDataInput();
        PlayerIn playerIn=new PlayerIn("",playerGiver,"","","","","","","","");
        dataIn.getPlayerIn().add(playerIn);
        List<PlayerOut> giver=playerService.get(dataIn);

        GuildPlayersDataInput GPInput=new GuildPlayersDataInput();
        GuildPlayersIn GPIn=new GuildPlayersIn("", "",giver.get(0).getIDPlayer());
        GPInput.getGuildPlayersIn().add(GPIn);
        List<GuildPlayersOut> GPList= guildPlayersService.get(GPInput);

        notificationReceiversService.createNotificationsByID(giver.get(0).getIDPlayer(), GPList.get(0).getIDGuildMasterFK(), "A reward has been created", "0", "1");
    }

}