package com.example.springboot.demo.specification;

import com.example.springboot.demo.entities.LandLoard;
import com.example.springboot.demo.model.LandLoardCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class LandLoardSpecification implements Specification<LandLoard> {

    String criteria = ":";

    public LandLoardSpecification() {

    }



    private LandLoardCriteria landLoardCriteria;

    public LandLoardSpecification(LandLoardCriteria landLoardCriteria) {
        this.landLoardCriteria = landLoardCriteria;
    }

    @Override
    public Specification<LandLoard> and(Specification<LandLoard> other) {
        return null;
    }

    @Override
    public Specification<LandLoard> or(Specification<LandLoard> other) {
        return null;
    }

    @Override
    public Predicate toPredicate(Root<LandLoard> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

       /* predicates.add(builder.like(
                builder.lower(root.get(criteria.getKey())),
                "%" + criteria.getValue().toString().toLowerCase() + "%"));*/

       // if (landLoardCriteria.getOperation()!=criteria)

            return criteriaBuilder.like(criteriaBuilder.lower(root.get(landLoardCriteria.getKey()))
            ,  "%" +landLoardCriteria.getValue().toLowerCase()+ "%" );

       // return null;
    }
}
