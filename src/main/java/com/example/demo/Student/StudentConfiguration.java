package com.example.demo.Student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfiguration {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {

        return args -> {
            Student s1 = new Student("mariam", LocalDate.of(2004, Month.MARCH, 6) ,"marriam@gmail.com");

            Student s2 = new Student( "alex", LocalDate.of(2000, Month.APRIL, 5)
                    , "alex@gmail.com");

            repository.saveAll(List.of(s1, s2));

        };


    }


}