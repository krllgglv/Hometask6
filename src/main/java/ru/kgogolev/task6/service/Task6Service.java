package ru.kgogolev.task6.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kgogolev.task6.model.Order;
import ru.kgogolev.task6.model.Product;
import ru.kgogolev.task6.repository.OrdersRepository;
import ru.kgogolev.task6.repository.ProductRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class Task6Service {
    private ProductRepository productRepository;
    private OrdersRepository ordersRepository;

    public void printAllOrderedProductsByCustomerId(Long userId) {
        List<Order> orders = ordersRepository.getAllOrdersByUserId(userId);
        for (Order order : orders) {
            System.out.println("заказ № " + order.getId());
            System.out.println("товары:");
            for (Product product : order.getProductsInOrder()) {
                System.out.println(product.getName());
            }
        }
    }

    public void printAllCustomersForSomeProduct(Long productId) {
        List<Order> orders = ordersRepository.getAllOrdersWithSomeProduct(productId);
        Product productById = productRepository.getProductById(productId);
        System.out.println("Продукт \"" + productById.getName() + "\" купили :");
        for (Order order : orders) {
            System.out.println(order.getUser());
        }
    }
}


