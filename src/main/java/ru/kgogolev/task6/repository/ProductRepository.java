package ru.kgogolev.task6.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.kgogolev.task6.model.Product;

import java.util.List;

@Repository
@Data
@AllArgsConstructor
public class ProductRepository {


    private SessionFactory factory;


    public List<Product> getAllProducts() {
        List<Product> result;
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            result = session.createQuery("SELECT p from Product p WHERE p.isDeleted = false").getResultList();
            System.out.println(result);
            session.getTransaction().commit();
        }
        return result;

    }

    public void deleteById(Long id) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Product productToDelete = session.get(Product.class, id);
            productToDelete.setIsDeleted(true);
            session.getTransaction().commit();

        }
    }

    public void create(Product product) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            session.save(product);
            session.getTransaction().commit();
        }
    }

    public void update(Product product) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Product productToUpdate = session.get(Product.class, product.getId());
            productToUpdate.setName(product.getName());
            productToUpdate.setPrice(product.getPrice());
            productToUpdate.setIsDeleted(false);
            session.getTransaction().commit();
        }
    }
}
