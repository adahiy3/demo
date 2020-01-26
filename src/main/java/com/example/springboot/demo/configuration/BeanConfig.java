package com.example.springboot.demo.configuration;

import com.example.springboot.demo.condition.IndiaTaxCalculationTypeCondition;
import com.example.springboot.demo.condition.USTaxCalculationTypeCondition;
import com.example.springboot.demo.service.IndiaTaxCalculation;
import com.example.springboot.demo.service.TaxCalculationService;
import com.example.springboot.demo.service.UsTaxCalculation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean(name="taxCalculationService")
    @Conditional(IndiaTaxCalculationTypeCondition.class)
    public TaxCalculationService getIndiaTaxCalculationService(){
        return new IndiaTaxCalculation();
    }

    @Bean(name="taxCalculationService")
    @Conditional(USTaxCalculationTypeCondition.class)
    public TaxCalculationService getUSTaxCalculationService(){
        return new UsTaxCalculation();
    }
}
