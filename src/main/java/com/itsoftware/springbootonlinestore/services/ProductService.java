package com.itsoftware.springbootonlinestore.services;

import com.itsoftware.springbootonlinestore.beans.Product;
import com.itsoftware.springbootonlinestore.beans.User;
import com.itsoftware.springbootonlinestore.dto.ProductDTO;
import com.itsoftware.springbootonlinestore.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(long productId) {
        return productRepository.findById(productId)
                .orElseThrow();
    }

    public long saveProduct(ProductDTO productDTO) {
        Product product = new Product(productDTO.getType(), productDTO.getName(), productDTO.getPrice());
        return productRepository.save(product).getId();
    }

    public void updateProduct(long productId, ProductDTO productDTO) {
        productRepository.findById(productId)
                .map(product -> updateProduct(product, productDTO));
    }

    private Product updateProduct(Product product, ProductDTO productDTO) {
        product.setType(productDTO.getType());
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        return productRepository.save(product);
    }

    public void deleteProduct(long productId) {
        if (productRepository.existsById(productId)) {
            productRepository.deleteById(productId);
        }
    }
}
