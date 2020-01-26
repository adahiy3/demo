package com.example.springboot.demo.controller;

import com.example.springboot.demo.service.TaxCalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

   /* @Autowired
    TaxCalculationService taxCalculationService;*/
   @Autowired
   TaxCalculationService taxCalculationService;


    @GetMapping(value = "/test")
    public String testController() {
        return "i am a test controller";
    }

    @GetMapping(value="/taxcalculation")
    public int getTaxRate(){
        return taxCalculationService.calculateTax();
    }
}
