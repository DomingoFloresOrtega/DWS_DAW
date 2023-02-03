package org.domingoe3;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
public class SpringBootWebMvcJdbcExamen3Application implements CommandLineRunner{
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebMvcJdbcExamen3Application.class, args);
		
	}
	
	@Override
	public void run(String... args) throws Exception {
		
	}

}
