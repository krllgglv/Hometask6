package ru.kgogolev.task6.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "orders")
@Data
@AllArgsConstructor
@RequiredArgsConstructor

public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

//    @Column(name = "id_user")
//    private Long id_user;


    @ManyToOne
    @JoinColumn(name = "id_user")
//            foreignKey = @ForeignKey(name = "orders_id_user_fk"))
    private User user;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user=" + user +
                '}';
    }
}
