package com.example.shop.Controllers;

import com.example.shop.model.Product;
import com.example.shop.repository.ProductRepository;
import com.example.shop.dto.ApiResponse;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public ApiResponse<List<Product>> all() {
        List<Product> products = productRepository.findAll();
        return new ApiResponse<>(true, "Products fetched successfully", products);
    }

    @PostMapping
    public ApiResponse<Product> add(@RequestBody Product product) {
        Product savedProduct = productRepository.save(product);
        return new ApiResponse<>(true, "Product added successfully", savedProduct);
    }
}