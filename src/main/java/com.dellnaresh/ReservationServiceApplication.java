package com.dellnaresh;


import com.dellnaresh.entity.Reservation;
import com.dellnaresh.repos.ReservationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

/**
 * Created by nareshm on 3/1/2016.
 */
@SpringBootApplication
public class ReservationServiceApplication {
    @Bean
    CommandLineRunner runner(ReservationRepository rr) {
        return args -> Stream.of(
                "Julia", "Mia", "Phil", "Dave", "Pieter",
                "Bridget", "Stéphane", "Josh", "Jennifer")
                .forEach(n -> rr.save(new Reservation(n)));
    }
    public static void main(String args[]){
        SpringApplication.run(ReservationServiceApplication.class, args);

    }
}
