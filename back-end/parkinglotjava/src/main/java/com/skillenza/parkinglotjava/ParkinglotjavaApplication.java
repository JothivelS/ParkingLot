package com.skillenza.parkinglotjava;

import java.util.Date;
import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@EnableJpaAuditing
public class ParkinglotjavaApplication {
	
	
	public static void main(String[] args) {
		SpringApplication.run(ParkinglotjavaApplication.class, args);
	}
	
	@Bean
    CommandLineRunner init(ParkingLotRepository parkingLotRepository) {
        return args -> {
        	int number = 1234;
        	for(int i=1; i<= 10; i++) {
        		ParkingLot parkingLot = new ParkingLot();
        		parkingLot.setLot(i++);
        		parkingLot.setCreatedAt(new Date());
        		parkingLot.setParkingAmount(20);
        		parkingLot.setParkingDuration(60);
        		parkingLot.setVehicleNumber(number++);
        		parkingLot.setUpdatedAt(new Date());
        		parkingLotRepository.save(parkingLot);
        	}
            parkingLotRepository.findAll().forEach(System.out::println);
        };
    }

}
