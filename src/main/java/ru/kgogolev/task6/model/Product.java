package ru.kgogolev.task6.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "products")
@Data
@RequiredArgsConstructor

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String name;



    @Column(name = "price")
    private Double price;

    @Column(name = "is_deleted")
    private Boolean isDeleted;
}

