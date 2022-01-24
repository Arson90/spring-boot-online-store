package com.itsoftware.springbootonlinestore.beans;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private long id;
    private String type;
    private String name;
    private float price;

    public Product(String type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }
}
