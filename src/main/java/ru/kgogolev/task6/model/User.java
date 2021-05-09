package ru.kgogolev.task6.model;


import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@RequiredArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String  name;

    @OneToMany(mappedBy = "user")
//    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private List<Order> orders;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +

                '}';
    }
}
