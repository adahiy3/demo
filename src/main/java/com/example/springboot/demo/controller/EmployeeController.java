package com.example.springboot.demo.controller;

import com.example.springboot.demo.entities.Employee;
import com.example.springboot.demo.exception.ResourceNotFoundException;
import com.example.springboot.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/employee")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }


    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value="id") Integer id) {
        try{
        Employee employeeById = employeeService.getEmployeeById(id);
            ResponseEntity<Employee> responseEntity = ResponseEntity.ok().body(employeeById);

            return responseEntity;
        }
        catch(Exception e){

            System.out.println("handle exception");
        }
        return null;
    }

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee) throws ResourceNotFoundException {

        Employee employee1 = employeeService.createEmployee(employee);
        return employee1;
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable(value = "id") Integer id) {
        Employee employee= null;
        try{
         employee = employeeService.getEmployeeById(id);}
        catch(Exception e){
                System.out.println("handle exception");


        }
        employeeService.deleteEmployee(employee);
     }


}
