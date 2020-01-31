package com.example.springboot.demo.repository;

import com.example.springboot.demo.entities.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeopleManagementRepository extends CrudRepository<Person,Integer> {
    List<Person> findByLastName(String lastName);
}
