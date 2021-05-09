package ru.kgogolev.task6.repository;


import lombok.AllArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.kgogolev.task6.model.Order;
import ru.kgogolev.task6.model.Product;
import ru.kgogolev.task6.model.User;
import ru.kgogolev.task6.util.HibernateUtil;

import java.util.List;

@Repository
@AllArgsConstructor
public class OrdersRepository {
    private final SessionFactory factory;

    public List<Order> getAllOrdersByUserId(Long id) {

        return HibernateUtil.doInTransaction(factory, session -> session.get(User.class, id).getOrders());
    }

    public List<Order> getAllOrdersWithSomeProduct(Long productId) {

        return HibernateUtil.doInTransaction(factory, session -> session.get(Product.class, productId).getListOfOrdersWithThisProduct());
    }
}
