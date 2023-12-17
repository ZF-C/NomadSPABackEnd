package com.nomadspa.backend.Customer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;
import static java.time.Month.*;


public class CustomerConfig {
    @Bean
    CommandLineRunner commandLineRunner(
            CustomerRepository repository){
        return args -> {
            Customer Jayson = new Customer(
                    "John",
                    "3343321329");
            Customer Jacob = new Customer(
                    "jayna",
                    "3343321328");
            repository.saveAll(
                    List.of(Jayson,Jacob)
            );

        };

    }
}
