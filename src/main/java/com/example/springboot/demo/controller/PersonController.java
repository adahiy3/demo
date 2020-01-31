package com.example.springboot.demo.controller;

import com.example.springboot.demo.entities.Person;
import com.example.springboot.demo.service.PeopleManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController()
@RequestMapping(value = "/api/person")

public class PersonController {

    @Autowired
    PeopleManagementService peopleManagementService;

@RequestMapping(method = RequestMethod.POST, value = "/save")
    public Person savePerson(@RequestBody Person person){
    return peopleManagementService.savePerson(person);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/savepersons")
    public List<Person> savePersons(@RequestBody List<Person> personList){
        return peopleManagementService.savePersons(personList);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/persons")
    public List<Person> findPersonsById(@RequestBody List<Integer> personIdList){
        return peopleManagementService.findPersonsById(personIdList);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/person/{personId}")
    public void findPersonsById(@PathVariable("personId")Integer personId){
         peopleManagementService.deletePerson(personId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/person/{personId}/{emailId}")
    public Person findPersonsById(@PathVariable("personId")Integer personId,@PathVariable("emailId")String emailId){
        return peopleManagementService.updatePersonEmail(personId,emailId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/personsByLastName/{lastName}")
    public List<Person> findPersonsByLastName(@PathVariable("lastName")String lastName){
        return peopleManagementService.findPersonsByLastName(lastName);
    }
}
