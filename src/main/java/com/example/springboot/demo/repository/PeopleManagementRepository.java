package com.example.springboot.demo.repository;

import com.example.springboot.demo.entities.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeopleManagementRepository extends CrudRepository<Person,Integer> {
    List<Person> findByLastName(String lastName);

    List<Person>  fetchPersonsInfo(String lastName);

    List<Person> fetchPersonsInfoNamedNative(String lastName);

    //@Query(value = "Select p from Person p where p.lastName=?1")
    @Query(value = "Select * from Person  where last_name=?1", nativeQuery = true)
    List<Person> fetchPersonsInfoQuery(String lastName);

    List<Person> findByFirstName(String lastName, Pageable page);
}
