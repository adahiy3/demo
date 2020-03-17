package com.example.springboot.demo.service;

import com.example.springboot.demo.entities.LandLoard;
import com.example.springboot.demo.entities.Phone;
import com.example.springboot.demo.model.LandLoardAndPhone;
import com.example.springboot.demo.repository.LandLoardBasicRepository;
import com.example.springboot.demo.repository.LandLoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
