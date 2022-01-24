package com.itsoftware.springbootonlinestore.beans;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private long id;
    @Column(name = "total_price")
    private double totalPrice;
    @ManyToMany
    @JoinColumn(name = "product_id")
    private List<Product> products;

    public Cart(double totalPrice, List<Product> products) {
        this.totalPrice = totalPrice;
        this.products = products;
    }
}
