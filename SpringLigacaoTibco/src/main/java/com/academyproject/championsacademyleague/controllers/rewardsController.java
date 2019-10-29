package com.academyproject.championsacademyleague.controllers;

import com.academyproject.championsacademyleague.schemas.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.DataInput;
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
    public List<RewardsOut> getCreateRewards() {

    }

    @RequestMapping("Update")
    public List<RewardsOut> getUpdateRewards() {

    }

    @RequestMapping("Get")
    public List<RewardsOut> getGetRewards() {

    }

    @RequestMapping("Delete")
    public List<RewardsOut> getDeleteRewards() {

    }
}
