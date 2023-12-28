package com.nomadspa.backend.SpaServiceCatalog;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalTime;
@Configuration
@Profile("dev")
public class SpaServiceCatalogConfig {
    @Bean
    CommandLineRunner setupSpaServiceCatalog(SpaServiceCatalogRepository repository){
        return args -> {
            SpaServiceCatalog hourBodyMassage = new SpaServiceCatalog(
                    "hourBodyMassage",
                    60,
                    69,
                    28);
            SpaServiceCatalog halfHourBodyMassage = new SpaServiceCatalog(
                    "halfHourBodyMassage",
                    30,
                    45,
                    15);
            SpaServiceCatalog hourFootReflexology = new SpaServiceCatalog(
                    "hourFootReflexology",
                    60,
                    55,
                    23);
            SpaServiceCatalog halfHourFootReflexology = new SpaServiceCatalog(
                    "halfHourFootReflexology",
                    30,
                    39,
                    12);

            SpaServiceCatalog halfHourChairMassage = new SpaServiceCatalog(
                    "halfHourChairMassage",
                    30,
                    45,
                    15);

            SpaServiceCatalog quarterHourChairMassage = new SpaServiceCatalog(
                    "quarterHourChairMassage",
                    15,
                    25,
                    7);

            SpaServiceCatalog packageA = new SpaServiceCatalog(
                    "packageA",
                    60,
                    74,
                    25);

            SpaServiceCatalog packageB = new SpaServiceCatalog(
                    "packageB",
                    90,
                    89,
                    35);

            SpaServiceCatalog packageC = new SpaServiceCatalog(
                    "packageC",
                    90,
                    99,
                    35);

            SpaServiceCatalog packageD = new SpaServiceCatalog(
                    "packageD",
                    120,
                    115,
                    45);
            SpaServiceCatalog weekendPackageA = new SpaServiceCatalog(
                    "weekendPackageA",
                    60,
                    84,
                    25);

            SpaServiceCatalog weekendPackageB = new SpaServiceCatalog(
                    "weekendPackageB",
                    90,
                    99,
                    35);

            SpaServiceCatalog weekendPackageC = new SpaServiceCatalog(
                    "weekendPackageC",
                    90,
                    108,
                    35);

            SpaServiceCatalog weekendPackageD = new SpaServiceCatalog(
                    "weekendPackageD",
                    120,
                    124,
                    45);
            repository.saveAll(
                    java.util.List.of(
                            hourBodyMassage,
                            halfHourBodyMassage,
                            hourFootReflexology,
                            halfHourFootReflexology,
                            halfHourChairMassage,
                            quarterHourChairMassage,
                            packageA,
                            packageB,
                            packageC,
                            packageD,
                            weekendPackageA,
                            weekendPackageB,
                            weekendPackageC,
                            weekendPackageD)
            );

        };
    }
}
