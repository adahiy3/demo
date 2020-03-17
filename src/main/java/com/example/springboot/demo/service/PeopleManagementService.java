package com.example.springboot.demo.service;

import com.example.springboot.demo.entities.Person;
import com.example.springboot.demo.repository.PeopleManagementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public Person updatePersonEmail(Integer personId, String emailId) {
        Optional<Person> personbyId = peopleManagementRepository.findById(personId);
        if (personbyId.isPresent()) {
            Person person = personbyId.get();
            person.setEmail(emailId);
            Person savePerson = peopleManagementRepository.save(person);
            return savePerson;
        }
       /* else {
            //TODO: raise an exception here if nothing to update and return a meaningful message to user
            //add a controller advise to handle this exception and check stacktrace and send a responseentity back to POSTMAN
            throw new RuntimeException("Person does not exists");
        }*/
       return null;

    }

    public List<Person> findPersonsByLastName(String lastName) {
        return (List<Person>) peopleManagementRepository.findByLastName(lastName);
    }

    public List<Person> findPersonsInfo(String lastName) {
        return (List<Person>) peopleManagementRepository.fetchPersonsInfo(lastName);

    }

    public List<Person> findPersonsInfoNamedNative(String lastName) {
        return (List<Person>) peopleManagementRepository.fetchPersonsInfoNamedNative(lastName);

    }

    public List<Person> findPersonsInfoNamedQuery(String lastName) {
        return (List<Person>) peopleManagementRepository.fetchPersonsInfoQuery(lastName);

    }

    public List<Person> findPersonsInfoPagination(String lastName, Pageable page) {
        return (List<Person>) peopleManagementRepository.findByFirstName(lastName,page);

    }
}
