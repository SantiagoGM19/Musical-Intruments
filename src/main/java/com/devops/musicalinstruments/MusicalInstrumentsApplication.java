package com.devops.musicalinstruments;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.devops.musicalinstruments.repositories")
public class MusicalInstrumentsApplication{

    public static void main(String[] args) {
        SpringApplication.run(MusicalInstrumentsApplication.class, args);
    }

}
