package com.nomadspa.backend.Therapist;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class TherapistConfig {
    @Bean
    CommandLineRunner commandLineRunner(
            TherapistRepository repository){
        return args -> {
            Therapist Jayson = new Therapist(
                    "Jayson",
                    "3343321329",
                    LocalDate.of(1999, AUGUST, 16));
            Therapist Jacob = new Therapist(
                    "Jacob",
                    "3343321328",
                    LocalDate.of(1997, DECEMBER, 21));
            repository.saveAll(
                    List.of(Jayson,Jacob)
            );

        };

    }
}
