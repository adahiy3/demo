package com.example.springboot.demo.service;

import com.example.springboot.demo.entities.LandLoard;
import com.example.springboot.demo.entities.Phone;
import com.example.springboot.demo.model.LandLoadDTO;
import com.example.springboot.demo.model.LandLoardAndPhone;
import com.example.springboot.demo.model.LandLoardCriteria;
import com.example.springboot.demo.repository.LandLoardBasicRepository;
import com.example.springboot.demo.repository.LandLoardRepository;
import com.example.springboot.demo.specification.LandLoardSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LandLoardService {

    @Autowired
    LandLoardRepository landLoardRepository;

    @Autowired
    LandLoardBasicRepository landLoardBasicRepository;

    public LandLoard saveLandLoard(LandLoard landLoard){
        List<Phone> phoneList = landLoard.getPhoneList();
        phoneList.stream().forEach(phone -> phone.setLandLoard(landLoard));
        return landLoardRepository.save(landLoard);
    }



    public List<LandLoardAndPhone> findLandLoardAndPhoneBasedOnName(String ladloardname) {
        List<LandLoardAndPhone> landLoardAndPhoneBasedOnName = landLoardBasicRepository.findLandLoardAndPhoneBasedOnName(ladloardname);
        return landLoardAndPhoneBasedOnName;
    }

    public Integer countLandLoards() {
        return landLoardBasicRepository.countLandLoards();
    }

    public List<LandLoadDTO> findLandLoards(LandLoardCriteria landLoardCriteria) {
        //define specification here based on landLoardCriteria
        //first create here then we will think of encapsulating it somewhere else.
        List<LandLoadDTO> landLoadDTOS = new ArrayList<>();

        LandLoardSpecification landLoardSpecification = new LandLoardSpecification(landLoardCriteria);
        List<LandLoard> all = landLoardRepository.findAll(landLoardSpecification);

        all.stream().forEach(landLoard -> {
            LandLoadDTO landLoadDTO = new LandLoadDTO();
            landLoadDTO.setName(landLoard.getName());
            landLoadDTO.setNickName(landLoard.getNickName());
            landLoadDTO.setAddress(landLoard.getAddress());
            landLoadDTOS.add(landLoadDTO);
        });
        return landLoadDTOS;
    }
}
