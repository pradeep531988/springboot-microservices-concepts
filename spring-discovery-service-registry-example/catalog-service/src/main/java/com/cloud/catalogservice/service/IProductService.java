package com.cloud.catalogservice.service;

import java.util.List;
import java.util.Optional;

import com.cloud.catalogservice.model.Product;

public interface IProductService {
	
	public List<Product> findAllProducts();
	public Optional<Product> findProductByCode(String code);

}
