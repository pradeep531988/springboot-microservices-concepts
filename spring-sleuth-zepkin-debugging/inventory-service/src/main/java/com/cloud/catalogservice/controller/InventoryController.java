package com.cloud.catalogservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;

import com.cloud.catalogservice.service.ProductService;

@Controller
@RequestMapping("/api/inventory")
public class InventoryController {
	
	@Autowired
	private ProductService productService;
	
    @GetMapping("/{code}")
	public ResponseEntity<String> getProducts(@PathVariable String code) {
		return new ResponseEntity(productService.getProductInventoryByCode(code), HttpStatus.OK);
	}

}
