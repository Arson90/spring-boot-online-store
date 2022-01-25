package com.itsoftware.springbootonlinestore.dto;

import com.itsoftware.springbootonlinestore.beans.Product;

import java.util.List;

public class CartDTO {
    private long id;
    private double totalPrice;
    private List<Product> products;
}
