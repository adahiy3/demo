package com.example.springboot.demo.service;

import com.example.springboot.demo.entities.Person;
import com.example.springboot.demo.repository.PeopleManagementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeopleManagementService {

    @Autowired
    PeopleManagementRepository peopleManagementRepository;

    public List<Person> findAllPerson(){
        return null;
    }

    public Person findPersonById(){
        return null;
    }

    public Person savePerson(Person person){
       return peopleManagementRepository.save(person);
    }


    public List<Person> savePersons(List<Person> personList) {
        return (List<Person>) peopleManagementRepository.saveAll(personList);
    }

    public List<Person> findPersonsById(List<Integer> personIdList) {
        return (List<Person>) peopleManagementRepository.findAllById(personIdList);
    }

    public void deletePerson(Integer personId){
        peopleManagementRepository.deleteById(personId);
    }

    public Person updatePersonEmail(Integer personId, String emailId){
        Optional<Person> personbyId = peopleManagementRepository.findById(personId);
        if (personbyId.isPresent()){
            Person person = personbyId.get();
            person.setEmail(emailId);
            Person savePerson = peopleManagementRepository.save(person);
            return savePerson;
        }
        else {
            //TODO: raise an exception here if nothing to update and return a meaningful message to user
            return null;
        }
    }

    public List<Person> findPersonsByLastName(String lastName) {
        return (List<Person>) peopleManagementRepository.findByLastName(lastName);
    }
}
