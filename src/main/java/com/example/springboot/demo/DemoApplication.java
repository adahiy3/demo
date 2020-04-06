package com.example.springboot.demo;

import com.example.springboot.demo.condition.IndiaTaxCalculationTypeCondition;
import com.example.springboot.demo.condition.USTaxCalculationTypeCondition;
import com.example.springboot.demo.configuration.ApplicationConfiguration;
import com.example.springboot.demo.configuration.MailConfig;
import com.example.springboot.demo.configuration.SampleBeanConfig;
import com.example.springboot.demo.model.Mail;
import com.example.springboot.demo.service.IndiaTaxCalculation;
import com.example.springboot.demo.service.TaxCalculationService;
import com.example.springboot.demo.service.UsTaxCalculation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;

import java.util.List;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);}

		@Autowired
		ApplicationConfiguration applicationConfiguration;

		@Autowired
		MailConfig mailConfig;

		@Autowired
		SampleBeanConfig sampleBeanConfig;

	@Override
	public void run(String... args) throws Exception {

		String environment = applicationConfiguration.getEnvironment();
		System.out.println("environment"+environment);

		List<String> servers =
				applicationConfiguration.getServers();

		servers.stream().forEach(server->System.out.println("server"+server));

		String from = mailConfig.getFrom();
		System.out.println(from);

		Mail mail = sampleBeanConfig.mail();

		System.out.println(mail.getPort());

	}
}
