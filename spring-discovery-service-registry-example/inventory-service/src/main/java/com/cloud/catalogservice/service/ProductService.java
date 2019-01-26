package com.cloud.catalogservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductService {
	
	private final RestTemplate restTemplate;
    
    @Autowired
    public ProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String findProductByCode(String code) {
            System.out.println("Fetching inventory level for product_code: "+code);
            ResponseEntity<String> itemResponseEntity =
                    restTemplate.getForEntity("http://catalog-service/api/products/{code}",
                                                String.class,
                                                code);
            if(itemResponseEntity.getStatusCode() == HttpStatus.OK) {
                String quantity = itemResponseEntity.getBody();
            } else {
                System.out.println("Unable to get inventory level for product_code: "+code +
                ", StatusCode: "+itemResponseEntity.getStatusCode());
            }
           return (itemResponseEntity.getBody());
    }
}
