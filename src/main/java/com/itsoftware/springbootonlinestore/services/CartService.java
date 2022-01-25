package com.itsoftware.springbootonlinestore.services;

import com.itsoftware.springbootonlinestore.beans.Cart;
import com.itsoftware.springbootonlinestore.beans.Product;
import com.itsoftware.springbootonlinestore.repositories.CartRepository;
import com.itsoftware.springbootonlinestore.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    @Autowired
    public CartService(CartRepository cartRepository, ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }

    public List<Cart> getCarts() {
        return cartRepository.findAll();
    }

    public Cart getCartById(long id) {
        return cartRepository.findById(id)
                .orElseThrow();
    }

    public long saveCart() {
        Cart cart = new Cart();
        return cartRepository.save(cart).getId();
    }

    public Optional<Cart> addProductToCart(long cartId, long productId) {
        return cartRepository.findById(cartId)
                .map(cart -> {
                    productRepository
                            .findById(productId)
                            .map(product -> cart.getProducts().add(product));
                    return cartRepository.save(cart);
        });
    }

    public Optional<Cart> deleteProductFromCart(long cartId, Long productId) {
        return cartRepository.findById(cartId)
                .map(cart -> cart.getProducts()
                        .stream()
                        .filter(product -> productId.equals(product.getId()))
                        .findFirst()
                        .map(product -> {
                            cart.getProducts().remove(product);
                            return cartRepository.save(cart);
                        }))
                .orElseThrow();
    }
}
