package com.example.springboot.demo.repository;

import com.example.springboot.demo.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
