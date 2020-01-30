package com.academyproject.championsacademyleague.accesingdatamysql.rewards;

import com.academyproject.championsacademyleague.Configurations.timeValue;
import com.academyproject.championsacademyleague.accesingdatamysql.guildPlayers.GuildPlayers;
import com.academyproject.championsacademyleague.accesingdatamysql.guildPlayers.GuildPlayersController;
import com.academyproject.championsacademyleague.accesingdatamysql.player.Player;
import com.academyproject.championsacademyleague.accesingdatamysql.player.PlayerController;
import com.academyproject.championsacademyleague.accesingdatamysql.player.PlayerRepository;
import com.academyproject.championsacademyleague.constants.Time;
import com.academyproject.championsacademyleague.services.dateFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping(path = "/reward")
public class RewardController {
    @Autowired
    private RewardRepository rewardRepository;
    private PlayerRepository playerRepository;
    private PlayerController playerController;
    private GuildPlayersController guildPlayersController;
    private com.academyproject.championsacademyleague.accesingdatamysql.notificationReceivers.NotificationReceiverController notificationReceiverController;

    @GetMapping(path="/getall")
    public @ResponseBody Iterable<Reward> getAllRewards() {
        return rewardRepository.findAll();
    }

    @GetMapping(path="/getAllRewardsToApprove")
    public @ResponseBody Iterable<Reward> getAllRewardsToApprove(){
        return rewardRepository.findRewardsToApprove();
    }

    @PostMapping(path="/create")
    public @ResponseBody String create(@RequestParam String idReward, @RequestParam String idPlayerGiverFK, @RequestParam String idPlayerReceiverFK, @RequestParam String champiesGiven, @RequestParam String dateOfReward, @RequestParam String approved, @RequestParam String timeSpent, @RequestParam String justification){
        Player giver = (Player) playerController.getPlayerById(idPlayerGiverFK.toString());
        Player receiver = (Player) playerController.getPlayerById(idPlayerReceiverFK.toString());
        rewardRepository.save(new Reward(Integer.parseInt(idReward), giver, receiver, Integer.parseInt(champiesGiven), dateOfReward, Integer.parseInt(approved), timeSpent, justification));
        return "reward created";
    }

    @PostMapping(path="/update")
    public @ResponseBody String update(@RequestParam String idReward, @RequestParam String idPlayerGiverFK, @RequestParam String idPlayerReceiverFK, @RequestParam String champiesGiven, @RequestParam String dateOfReward, @RequestParam String approved, @RequestParam String timeSpent, @RequestParam String justification){
        Reward reward = (Reward) rewardRepository.findAllById(Collections.singleton(Integer.parseInt(idReward)));
        reward.setIDPlayerGiverFK((Player) playerController.getPlayerById(idPlayerGiverFK.toString()));
        reward.setIDPlayerReceiverFK((Player) playerController.getPlayerById(idPlayerReceiverFK.toString()));
        reward.setChampiesGiven(Integer.parseInt(champiesGiven));
        reward.setDateOfReward(dateOfReward);
        reward.setApproved(Integer.parseInt(approved));
        reward.setTimeSpent(timeSpent);
        reward.setJustification(justification);
        rewardRepository.save(reward);
        return "reward updated";
    }

    @GetMapping(path="/getById")
    public @ResponseBody Iterable<Reward> getById(@RequestParam Integer idReward){
        return rewardRepository.findAllById(Collections.singleton(idReward));
    }

    @GetMapping(path="/getByPlayerGiver")
    public @ResponseBody Iterable<Reward> getByPlayerGiver(@RequestParam String idPlayerGiverFK){
        return rewardRepository.findByPlayerGiver(idPlayerGiverFK);
    }

    @GetMapping(path="/getByPlayerReceiver")
    public @ResponseBody Iterable<Reward> getByPlayerReceiver(@RequestParam String idPlayerReceiverFK){
        return rewardRepository.findByPlayerReceiver(idPlayerReceiverFK);
    }

    @GetMapping(path="/getByDateOfReward")
    public @ResponseBody Iterable<Reward> getByDateOfReward(@RequestParam String dateofreward){
        return rewardRepository.findByDateOfReward(dateofreward);
    }

    @GetMapping(path="/getByChampiesGiven")
    public @ResponseBody Iterable<Reward> getByChampiesGiven(@RequestParam Integer champiesGiven){
        return rewardRepository.findByChampiesGiven(champiesGiven);
    }

    @GetMapping(path="/getByTimeSpent")
    public @ResponseBody Iterable<Reward> getByTimeSpent(@RequestParam Integer timeSpent){
        return rewardRepository.findByTimeSpent(timeSpent);
    }

    @PostMapping(path="/delete")
    public @ResponseBody String delete(@RequestParam Integer idReward){
        rewardRepository.deleteById(idReward);
        return "reward deleted";
    }

    @PostMapping(path="/approve")
    public @ResponseBody boolean approveReward(@RequestParam String[] idReward){
        Player playerGiver;
        Player playerReceiver;
        for(int i=0; i<idReward.length;i++) {
            Reward reward = (Reward) getById(Integer.parseInt(idReward[i]));
            String [] date = reward.getDateOfReward().split("T");
            update(String.valueOf(reward.getIDReward()), String.valueOf(reward.getIDPlayerGiverFK().getIdPlayer()), String.valueOf(reward.getIDPlayerReceiverFK().getIdPlayer()), String.valueOf(reward.getChampiesGiven()), reward.getDateOfReward(), "1", reward.getTimeSpent(), reward.getJustification());
            playerGiver = (Player) playerController.getPlayerById(reward.getIDPlayerGiverFK().toString());
            playerReceiver = (Player) playerController.getPlayerById(reward.getIDPlayerReceiverFK().toString());
            giveChampies(((Player) playerController.getPlayerById(reward.getIDPlayerGiverFK().toString())).getUsername(), ((Player) playerController.getPlayerById(reward.getIDPlayerReceiverFK().toString())).getUsername(), Integer.valueOf(reward.getChampiesGiven()));
            if(reward.getChampiesGiven()==1){
                notificationReceiverController.createNotificationsByID(reward.getIDPlayerGiverFK().toString(), reward.getIDPlayerReceiverFK().toString(),playerGiver.getUsername()+" gave you "+reward.getChampiesGiven()+" champy for your work", "0", "1");
                notificationReceiverController.createNotificationsByID(reward.getIDPlayerReceiverFK().toString(), reward.getIDPlayerGiverFK().toString(), "You gave "+reward.getChampiesGiven()+" champy to "+playerReceiver.getUsername(), "0", "1");
            }else{
                notificationReceiverController.createNotificationsByID(reward.getIDPlayerGiverFK().toString(), reward.getIDPlayerReceiverFK().toString(),playerGiver.getUsername()+" gave you "+reward.getChampiesGiven()+" champy for your work", "0", "1");
                notificationReceiverController.createNotificationsByID(reward.getIDPlayerReceiverFK().toString(), reward.getIDPlayerGiverFK().toString(), "You gave "+reward.getChampiesGiven()+" champy to "+playerReceiver.getUsername(), "0", "1");
            }
        }
        return true;
    }

    @PostMapping(path="/disapprove")
    public @ResponseBody boolean disapprove(@RequestParam Integer[] idReward){
        for(int i=0;i<idReward.length;i++) {
            Reward reward = (Reward) getById(idReward[i]);
            String[] date = reward.getDateOfReward().split("T");
            update(String.valueOf(reward.getIDReward()), String.valueOf(reward.getIDPlayerGiverFK().getIdPlayer()), String.valueOf(reward.getIDPlayerReceiverFK().getIdPlayer()), "0", reward.getDateOfReward(), "0", reward.getTimeSpent(), reward.getJustification());
            String a = reward.getIDPlayerGiverFK().toString();

            Player giver = (Player) playerController.getPlayerById(reward.getIDPlayerGiverFK().toString());
            int value = new timeValue().timeToValue(Time.valueOf(reward.getTimeSpent()));
            giver.setChampiesToGive(reward.getChampiesGiven()+value);
            Player player = new Player(giver.getIdPlayer(), giver.getUsername(), giver.getEmail(), giver.getPassword(), giver.getGender(), giver.getUsertype(), giver.getXp(), giver.getChampiesToGive(), giver.getMyChampies(), giver.getStatus());
            playerRepository.save(player);

            Player receiver = (Player) playerController.getPlayerById(reward.getIDPlayerReceiverFK().toString());
            playerRepository.save(receiver);

            notificationReceiverController.createNotificationsByID(reward.getIDPlayerGiverFK().toString(), reward.getIDPlayerGiverFK().toString(), "Your reward to "+receiver.getUsername()+" was disapproved", "0", "1");
        }
        return true;
    }

    @PostMapping(path="/reward")
    public @ResponseBody void rewardPlayer(@RequestParam String playerGiver, @RequestParam String playerReceiver, @RequestParam String time, String justification){
        registry(playerGiver, playerReceiver, Time.valueOf(time), justification);

        Player giver = (Player) playerRepository.findByUsername(playerGiver);

        GuildPlayers gp = (GuildPlayers) guildPlayersController.getGuildPlayerByWarrior(giver.getIdPlayer());

        notificationReceiverController.createNotificationsByID(String.valueOf(giver.getIdPlayer()), gp.getGuildPlayersId().getIDGuildMasterFK().toString(), "A reward has been created", "0", "1");
    }

    @PostMapping(path="/registry")
    public @ResponseBody boolean registry(@RequestParam String playerGiver, @RequestParam String playerReceiver, @RequestParam Time time, @RequestParam String justification){
        List<Player> playersList = (List<Player>) playerController.getAllPlayers();
        Reward registry = new Reward();
        Player giver = new Player();
        Player receiver = new Player();
        int value=new timeValue().timeToValue(time);
        for (int i=0; i<playersList.size(); i++){
            if(playersList.get(i).getUsername().equals(playerGiver)){
                giver = playersList.get(i);
            }else if(playersList.get(i).getUsername().equals(playerReceiver)){
                receiver=playersList.get(i);
            }
        }
        if(giver.equals(null) || receiver.equals(null))
            return false;
        giver.setChampiesToGive(Integer.valueOf(giver.getChampiesToGive())-value);
        playerController.update(giver.getUsername(), giver.getEmail(), giver.getPassword(), giver.getGender(), giver.getUsertype(), String.valueOf(giver.getXp()), String.valueOf(giver.getChampiesToGive()), String.valueOf(giver.getMyChampies()), giver.getStatus());
        create("", String.valueOf(giver.getIdPlayer()), String.valueOf(receiver.getIdPlayer()), String.valueOf(value), new dateFormatter().DateFormatter(), String.valueOf(0), String.valueOf(time), justification);
        return true;
    }

    @PostMapping(path="/giveChampies")
    public @ResponseBody boolean giveChampies(@RequestParam String playerGiver, @RequestParam String playerReceiver, @RequestParam int value){
        /*List<Player> playersList = getAllRewards();
        Player giver = new Player();
        Player receiver = new Player();
        for(int i=0; i< playersList.size(); i++){
            if(playersList.get(i).getUserName().equals(playerGiver)){
                giver=playersList.get(i);
            }else if(playersList.get(i).getUserName().equals(playerReceiver)){
                receiver=playersList.get(i);
            }
        }


        List<PlayerOut> playersList=getAllRewards(new PlayerDataInput());
        PlayerOut giver=new PlayerOut();
        PlayerOut receiver=new PlayerOut();
        for(int i=0; i< playersList.size(); i++){
            if(playersList.get(i).getUserName().equals(playerGiver)){
                giver=playersList.get(i);
            }else if(playersList.get(i).getUserName().equals(playerReceiver)){
                receiver=playersList.get(i);
            }
        }
        if((Integer.valueOf(giver.getChampiesToGive())-value)<0 || giver.getChampiesToGive()==null || receiver.getChampiesToGive()==null){
            return false;
        }else{
            /*
            giver.setChampiesToGive(String.valueOf(Integer.valueOf(giver.getChampiesToGive())-value));
            PlayerIn giverIn=new PlayerIn(giver.getIDPlayer(), giver.getUserName(), giver.getEmail(), giver.getPassword(), giver.getGender(), giver.getUserType(), giver.getXP(), giver.getChampiesToGive(), giver.getMyChampies(), giver.getStatus());
            PlayerDataInput inputGiver=new PlayerDataInput();
            inputGiver.getPlayerIn().add(giverIn);
            update(inputGiver);*/

            /*receiver.setMyChampies(String.valueOf(Integer.valueOf(receiver.getMyChampies())+value));
            receiver.setXP(String.valueOf(Integer.valueOf(receiver.getXP())+(2*value)));
            PlayerIn receiverIn=new PlayerIn(receiver.getIDPlayer(), receiver.getUserName(), receiver.getEmail(), receiver.getPassword(), receiver.getGender(), receiver.getUserType(), receiver.getXP(), receiver.getChampiesToGive(), receiver.getMyChampies(), receiver.getStatus());
            PlayerDataInput inputReceiver=new PlayerDataInput();
            inputReceiver.getPlayerIn().add(receiverIn);
            update(inputReceiver);

            */return true;
        //}
    }
}