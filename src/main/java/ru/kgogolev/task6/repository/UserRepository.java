package ru.kgogolev.task6.repository;


import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.kgogolev.task6.model.Order;
import ru.kgogolev.task6.model.User;

import java.util.List;

@Repository
@AllArgsConstructor
public class UserRepository {
    private SessionFactory factory;

    public List<Order> getAllOrdersByUserId(Long id) {
        List<Order> result;
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            User user = session.get(User.class, id);
            result = user.getOrders();
            System.out.println(result);
            session.getTransaction().commit();
        }
        return result;
    }
}
