package com.example.springboot.demo.repository;

import com.example.springboot.demo.entities.LandLoard;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.EntityManager;

public interface LandLoardRepository extends CrudRepository<LandLoard, Integer> {
}
