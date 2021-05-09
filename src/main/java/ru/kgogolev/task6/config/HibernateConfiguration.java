package ru.kgogolev.task6.config;


import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.kgogolev.task6.model.Order;
import ru.kgogolev.task6.model.Product;
import ru.kgogolev.task6.model.User;

@Configuration
public class HibernateConfiguration {

    @Bean
    public org.hibernate.cfg.Configuration config() {
        return new org.hibernate.cfg.Configuration()
                .addAnnotatedClass(Product.class)
                .addAnnotatedClass(Order.class)
                .addAnnotatedClass(User.class);
    }

    @Bean
    public SessionFactory createFactory() {
        return config().buildSessionFactory();
    }
}
