package com.example.springboot.demo.service;

import com.example.springboot.demo.entities.Employee;
import com.example.springboot.demo.exception.ResourceNotFoundException;
import com.example.springboot.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Integer id) throws ResourceNotFoundException {
        Employee byId = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found"));
        return byId;
    }

    public Employee createEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Employee employee){
         employeeRepository.delete(employee);
    }

}
