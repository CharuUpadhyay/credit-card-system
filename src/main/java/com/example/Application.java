package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.credit.repository.CardRepository;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class Application implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CardRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//
////		logger.info("card id 10001 -> {}", repository.findById(10001L));
//
////		logger.info("Inserting -> {}", repository.save(new Card("John", "1111222233334444", new BigDecimal("100"), new BigDecimal("200"))));
////
////		logger.info("All cards -> {}", repository.findAll());
	}
}
