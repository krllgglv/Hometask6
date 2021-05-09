package ru.kgogolev.task6;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.kgogolev.task6.service.Task6Service;

@SpringBootApplication
public class Task6Application {

    public static void main(String[] args) {
        SpringApplication.run(Task6Application.class, args);
    }

    @Bean
    public CommandLineRunner runner(Task6Service service) {
        return args -> {
                service.printAllCustomersForSomeProduct(2L);
                service.printAllOrderedProductsByCustomerId(1L);
        };
    }
}
