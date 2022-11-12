package com.example.Noble.Journal.Journal;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

@Configuration
public class JournalConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            JournalRepo journalRepo
    ) {

        return args -> {
            JournalEntry one = new JournalEntry(
                    LocalDateTime.now(),
                    "SpringDataJPA is TOUGH!",
                    9L,
                    "Lexapro"
            );

            JournalEntry two = new JournalEntry(
                    LocalDateTime.of(2022, Month.NOVEMBER, 7, 5, 24),
                    "Test Entry",
                    2L,
                    "Lexapro"

            );
            journalRepo.saveAll(

                    List.of(one, two)

            );
        };

    }
}
