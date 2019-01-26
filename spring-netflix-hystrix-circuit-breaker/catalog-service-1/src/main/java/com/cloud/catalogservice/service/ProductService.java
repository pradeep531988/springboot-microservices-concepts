package com.cloud.catalogservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloud.catalogservice.model.Product;
import com.cloud.catalogservice.repository.IProductRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class ProductService implements IProductService {
	 private final IProductRepository productRepository;
	 
	    @Autowired
	    public ProductService(IProductRepository productRepository) {
	        this.productRepository = productRepository;
	    }
	 
	    public List<Product> findAllProducts() {
	        return productRepository.findAll();
	    }
	 
	    public Optional<Product> findProductByCode(String code) {
	        return productRepository.findByCode(code);
	    }

}
