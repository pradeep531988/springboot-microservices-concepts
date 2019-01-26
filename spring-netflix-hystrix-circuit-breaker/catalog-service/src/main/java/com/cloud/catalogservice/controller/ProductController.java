package com.cloud.catalogservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.catalogservice.exception.ProductNotFoundException;
import com.cloud.catalogservice.model.Product;
import com.cloud.catalogservice.service.IProductService;

import lombok.extern.slf4j.Slf4j;
 
@RestController
@RequestMapping("/api/products")
@Slf4j
public class ProductController {
 
    private final IProductService productService;
 
    @Autowired
    public ProductController(IProductService productService) {
        this.productService = productService;
    }
 
    @GetMapping("")
    public List<Product> allProducts() {
        return productService.findAllProducts();
    }
 
    @GetMapping("/{code}")
    public Product productByCode(@PathVariable String code) {
        return productService.findProductByCode(code)
                .orElseThrow(() -> new ProductNotFoundException("Product with code ["+code+"] doesn't exist"));
    }
}