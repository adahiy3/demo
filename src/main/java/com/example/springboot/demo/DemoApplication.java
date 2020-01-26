package com.example.springboot.demo;

import com.example.springboot.demo.condition.IndiaTaxCalculationTypeCondition;
import com.example.springboot.demo.condition.USTaxCalculationTypeCondition;
import com.example.springboot.demo.service.IndiaTaxCalculation;
import com.example.springboot.demo.service.TaxCalculationService;
import com.example.springboot.demo.service.UsTaxCalculation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);}

}
