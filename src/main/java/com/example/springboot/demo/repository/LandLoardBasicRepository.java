package com.example.springboot.demo.repository;

import com.example.springboot.demo.entities.LandLoard;
import com.example.springboot.demo.entities.LandLoard_;
import com.example.springboot.demo.entities.Phone;
import com.example.springboot.demo.entities.Phone_;
import com.example.springboot.demo.model.LandLoardAndPhone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Repository
public class LandLoardBasicRepository implements Repository {

    @Autowired
    EntityManager entityManager;


    public List<LandLoardAndPhone> findLandLoardAndPhoneBasedOnName(String ladloardname) {

        List<LandLoardAndPhone> landLoardAndPhones = new ArrayList<>();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Phone> landLoardAndPhonesQuery = criteriaBuilder.createQuery(Phone.class);

        Root<Phone> landLoardRoot = landLoardAndPhonesQuery.from(Phone.class);
        Join<Phone, LandLoard> join = landLoardRoot.join(Phone_.landLoard);

        Predicate landLoardPredicate = criteriaBuilder.equal(join.get(LandLoard_.NAME), ladloardname);

        landLoardAndPhonesQuery.where(landLoardPredicate);

        TypedQuery<Phone> query = entityManager.createQuery(landLoardAndPhonesQuery);
        List<Phone> resultList = query.getResultList();

        resultList.stream().forEach(landLoard -> {
            LandLoardAndPhone landLoardAndPhone = new LandLoardAndPhone();
            landLoardAndPhone.setLandLoardName(landLoard.getLandLoard().getName());
            landLoardAndPhone.setLandLoardNickName(landLoard.getLandLoard().getNickName());
            landLoardAndPhone.setAreaCode(landLoard.getAreaCode().toString());
            landLoardAndPhone.setPhoneNumber(landLoard.getPhoneNumber().toString());
            landLoardAndPhones.add(landLoardAndPhone);
        });

        return landLoardAndPhones;
    }

    public Integer countLandLoards() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> countOfLandLoardCriteriaQuery = criteriaBuilder.createQuery(Long.class);
        Root<LandLoard> rootLandLoard = countOfLandLoardCriteriaQuery.from(LandLoard.class);
        Expression<Long> count = criteriaBuilder.count(rootLandLoard.get(LandLoard_.name));
         countOfLandLoardCriteriaQuery.select(count);
        TypedQuery<Long> query = entityManager.createQuery(countOfLandLoardCriteriaQuery);
        return Math.toIntExact(query.getSingleResult());
    }
}
