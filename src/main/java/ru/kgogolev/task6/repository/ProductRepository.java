package ru.kgogolev.task6.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.kgogolev.task6.model.Product;
import ru.kgogolev.task6.util.HibernateUtil;

@Repository
@Data
@AllArgsConstructor
public class ProductRepository {


    private final SessionFactory factory;


    public Product getProductById(Long id) {
        return (Product) HibernateUtil.doInTransaction(factory,
                session -> session.createQuery("SELECT p from Product p WHERE p.id = :id")
                        .setParameter("id", id).getSingleResult());
    }
}
