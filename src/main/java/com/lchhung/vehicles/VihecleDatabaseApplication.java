package com.lchhung.vehicles;

import com.lchhung.vehicles.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VihecleDatabaseApplication {
	@Autowired
	private UserRepository userRepository;
	@Autowired	
	private CarRepository carRepository;

	@Autowired	
	private OwnerRepository ownerRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(VihecleDatabaseApplication.class, args);
	}
	
	@Bean
	CommandLineRunner runner() {
		return args -> {
			// Test data
			//User information
			Owner owner1 = new Owner("Kim" , "Le");
			Owner owner2 = new Owner("Kent" , "Le");
			ownerRepository.save(owner1);
			ownerRepository.save(owner2);

			//Car information
			carRepository.save(new Car("Ford", "Mustang", "Red", "ADF-1121", 2017, 59000, owner1));
			carRepository.save(new Car("Nissan", "Leaf", "White", "SSJ-3002", 2014, 29000, owner2));
			carRepository.save(new Car("Toyota", "Prius", "Silver", "KKO-0212", 2018, 39000, owner2));

			//User name, password information to test with Spring Security
			// Use BCrypt calculator to calculate BCrypt passsword, e.g. https://www.bcryptcalculator.com/encode
			userRepository.save( new User ("hung", "$2a$10$TcGYtmvGHXkjhFJrDGqol.lMBV95sXIRPZAnMpLOQZrrbihcISdpq","USER"));
			userRepository.save(new User ("admin", "$2a$10$2Xo22qOn1l97GHvgbz8hJem49hhNnyRKhvqBrFP3xHzWC79bpkwRy", "ADMIN"));
		};
	}	
}
