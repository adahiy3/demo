package com.example.springboot.demo.controller;

import com.example.springboot.demo.entities.Person;
import com.example.springboot.demo.exception.ResourceNotFoundException;
import com.example.springboot.demo.model.PersonRequest;
import com.example.springboot.demo.service.PeopleManagementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping(value = "/api/person")

public class PersonController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    PeopleManagementService peopleManagementService;

    @RequestMapping(method = RequestMethod.POST, value = "/save")
    public Person savePerson(@RequestBody Person person,String transactionId) {
        transactionId = "t1234";
        MDC.put("transactionId",transactionId);
        LOGGER.info("creating person {}",person.getFirstName());

        Person person1 = peopleManagementService.savePerson(person);
        //MDC.clear();

        return  person1;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/savepersons")
    public List<Person> savePersons(@RequestBody List<Person> personList) {
        return peopleManagementService.savePersons(personList);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/persons")
    public List<Person> findPersonsById(@RequestBody List<Integer> personIdList) {
        return peopleManagementService.findPersonsById(personIdList);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/person/{personId}")
    public void findPersonsById(@PathVariable("personId") Integer personId) {
        peopleManagementService.deletePerson(personId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/person/{personId}/{emailId}")
    public Person findPersonsById(@PathVariable("personId") Integer personId, @PathVariable("emailId") String emailId) throws ResourceNotFoundException {
        Person person =  peopleManagementService.updatePersonEmail(personId, emailId);
        if (person == null){
            LOGGER.error("findPersonsById: Person not found for parameter personId {}",personId);
            throw new ResourceNotFoundException("Person Not Found");

        }
        return person;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/personsByLastName/{lastName}")
    public List<Person> findPersonsByLastName(@PathVariable("lastName") String lastName) {
        return peopleManagementService.findPersonsByLastName(lastName);
    }

    //Example of named query
    @RequestMapping(method = RequestMethod.GET, value = "/personsByLastNameNamedQuery/{lastName}")
    public List<Person> findPersonsByLastNameNamedQuery(@PathVariable("lastName") String lastName) {
        return peopleManagementService.findPersonsInfo(lastName);
    }

    //Example of named native query
    @RequestMapping(method = RequestMethod.GET, value = "/personsByLastNameNamedNativeQuery/{lastName}")
    public List<Person> findPersonsByLastNameNamedNativeQuery(@PathVariable("lastName") String lastName) {
        return peopleManagementService.findPersonsInfoNamedNative(lastName);
    }

    //Example of   @query
    @RequestMapping(method = RequestMethod.GET, value = "/personsByLastNameQuery/{lastName}")
    public List<Person> findPersonsByLastNameQuery(@PathVariable("lastName") String lastName) {
        return peopleManagementService.findPersonsInfoNamedQuery(lastName);
    }

    //Example of pagination in jpa methods
    @RequestMapping(method = RequestMethod.GET, value = "/personsByFirstName")
    public List<Person> findPersonsByFirstNamePagination(@RequestBody PersonRequest personRequest) {
        // return peopleManagementService.findPersonsInfoPagination(lastName,  PageRequest.of(1,1 , Sort.by(Sort.Direction.ASC,"email")));
        LOGGER.error("ERROR LEVEL SAMPLE LOGGING");
        LOGGER.debug("debug LEVEL SAMPLE LOGGING");
        LOGGER.warn("WARN LEVEL SAMPLE LOGGING");
        LOGGER.info("INFO LEVEL SAMPLE LOGGING");
        LOGGER.trace("TRACE LEVEL SAMPLE LOGGING");

        return peopleManagementService.findPersonsInfoPagination(personRequest.getFirstName(), PageRequest.of(personRequest.getPage(), personRequest.getNumberofRecords(), Sort.by(Sort.Direction.ASC, "email")));
    }

}
