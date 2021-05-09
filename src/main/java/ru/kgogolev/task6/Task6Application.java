package ru.kgogolev.task6;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.kgogolev.task6.model.Order;
import ru.kgogolev.task6.model.Product;
import ru.kgogolev.task6.repository.ProductRepository;
import ru.kgogolev.task6.repository.UserRepository;

import java.util.List;

@SpringBootApplication
public class Task6Application {

    public static void main(String[] args) {
        SpringApplication.run(Task6Application.class, args);
    }

    @Bean
    public CommandLineRunner runner(UserRepository repository){
        return args -> {
            List<Order> orders = repository.getAllOrdersByUserId(1L);
            orders.forEach(System.out::println);
        };
    }
}
