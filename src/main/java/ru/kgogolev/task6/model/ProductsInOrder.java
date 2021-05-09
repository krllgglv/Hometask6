package ru.kgogolev.task6.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "products_in_order")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class ProductsInOrder {
    @Id
    @Column(name = "id_order")
    private Long idOrder;

    @Id
    @Column(name = "id_product")
    private Long idProdoct;


    @Column(name = "price")
    private Double priceInOrder;

    @Column(name = "quantity")
    private Integer quantity;


}
