package com.example.springboot.demo.service;

public class UsTaxCalculation implements TaxCalculationService {

    @Override
    public int calculateTax() {
        return 30;
    }
}
