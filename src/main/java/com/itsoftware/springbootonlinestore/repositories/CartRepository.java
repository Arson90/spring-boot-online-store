package com.itsoftware.springbootonlinestore.repositories;

import com.itsoftware.springbootonlinestore.beans.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends CrudRepository<Cart, Long> {
    List<Cart> findAll();
}
