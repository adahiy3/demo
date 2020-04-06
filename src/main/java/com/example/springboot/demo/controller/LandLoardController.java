package com.example.springboot.demo.controller;

import com.example.springboot.demo.entities.LandLoard;
import com.example.springboot.demo.model.LandLoadDTO;
import com.example.springboot.demo.model.LandLoardAndPhone;
import com.example.springboot.demo.model.LandLoardCriteria;
import com.example.springboot.demo.service.LandLoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/landloard")
public class LandLoardController {


    @Autowired
    LandLoardService landLoardService;

    @RequestMapping(method = RequestMethod.POST, value = "/createlandloard")
    public void saveLandLoard(@RequestBody LandLoard landLoard) {
         landLoardService.saveLandLoard(landLoard);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/findlandloard/{ladloardname}")
    public List<LandLoardAndPhone> findLandLoardAndPhoneByName(@PathVariable("ladloardname")String ladloardname){
        List<LandLoardAndPhone> landLoardAndPhoneBasedOnName = landLoardService.findLandLoardAndPhoneBasedOnName(ladloardname);
        return landLoardAndPhoneBasedOnName;
    }

    //group by example using criteria query api.
        @RequestMapping(method = RequestMethod.GET, value = "/countlandloards")
    public Integer countLandLoards(){
        Integer landLoardAndPhoneBasedOnName = landLoardService.countLandLoards();
        return landLoardAndPhoneBasedOnName;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/findlandloards")
    public List<LandLoadDTO> findLandLoardsBySpecification(@RequestBody LandLoardCriteria landLoardCriteria){
        List<LandLoadDTO> landLoards = landLoardService.findLandLoards(landLoardCriteria);
        return landLoards;
    }

}
