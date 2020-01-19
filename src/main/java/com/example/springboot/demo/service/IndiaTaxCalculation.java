package com.example.springboot.demo.service;

public class IndiaTaxCalculation implements TaxCalculationService {

    @Override
    public int calculateTax() {
        return 20;
    }
}
