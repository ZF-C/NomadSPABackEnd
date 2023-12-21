package com.nomadspa.backend.SpaServiceCatalog;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import java.time.LocalTime;

public class SpaServiceCatalogConfig {
    @Bean
    CommandLineRunner commandLineRunner(SpaServiceCatalogRepository repository){
        return args -> {
            SpaServiceCatalog hourBodyMassage = new SpaServiceCatalog(
                    "60min Body Massage",
                    60,
                    69,
                    28);
            SpaServiceCatalog halfHourBodyMassage = new SpaServiceCatalog(
                    "30min Body Massage",
                    30,
                    45,
                    15);
            SpaServiceCatalog hourFootReflexology = new SpaServiceCatalog(
                    "60min Foot Reflexology",
                    60,
                    55,
                    23);
            SpaServiceCatalog halfHourFootReflexology = new SpaServiceCatalog(
                    "30min Foot Reflexology",
                    30,
                    39,
                    12);

            SpaServiceCatalog halfHourChairMassage = new SpaServiceCatalog(
                    "30min Chair Massage",
                    30,
                    45,
                    15);

            SpaServiceCatalog quarterHourChairMassage = new SpaServiceCatalog(
                    "15min Chair Massage",
                    15,
                    25,
                    7);

            SpaServiceCatalog packageA = new SpaServiceCatalog(
                    "30min Foot Reflexology + 30min Body Massage",
                    60,
                    74,
                    25);

            SpaServiceCatalog packageB = new SpaServiceCatalog(
                    "60min Foot Reflexology + 30min Body Massage",
                    90,
                    89,
                    35);

            SpaServiceCatalog packageC = new SpaServiceCatalog(
                    "60min Foot Reflexology + 30min Body Massage",
                    90,
                    99,
                    35);

            SpaServiceCatalog packageD = new SpaServiceCatalog(
                    "60min Foot Reflexology + 60min Body Massage",
                    120,
                    115,
                    45);
            SpaServiceCatalog weekendPackageA = new SpaServiceCatalog(
                    "30min Foot Reflexology + 30min Body Massage",
                    60,
                    84,
                    25);

            SpaServiceCatalog weekendPackageB = new SpaServiceCatalog(
                    "60min Foot Reflexology + 30min Body Massage",
                    90,
                    99,
                    35);

            SpaServiceCatalog weekendPackageC = new SpaServiceCatalog(
                    "60min Foot Reflexology + 30min Body Massage",
                    90,
                    108,
                    35);

            SpaServiceCatalog weekendPackageD = new SpaServiceCatalog(
                    "60min Foot Reflexology + 60min Body Massage",
                    120,
                    124,
                    45);

        };
    }
}
