package com.cloud.catalogservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

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
    
    @HystrixCommand(fallbackMethod = "getDefaultProductInventoryByCode",
    commandProperties = {
       @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000"),
       @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value="60")
    }
)
    public String getProductInventoryByCode(String productCode)
    {
    	  System.out.println("Fetching inventory level for product_code: "+productCode);
          ResponseEntity<String> itemResponseEntity =
                  restTemplate.getForEntity("http://catalog-service/api/products/{code}",
                                              String.class,
                                              productCode);
          if(itemResponseEntity.getStatusCode() == HttpStatus.OK) {
              String quantity = itemResponseEntity.getBody();
          } else {
              System.out.println("Unable to get inventory level for product_code: "+productCode +
              ", StatusCode: "+itemResponseEntity.getStatusCode());
          }
         return (itemResponseEntity.getBody());
    }
 
    @SuppressWarnings("unused")
    String getDefaultProductInventoryByCode(String productCode) {
    	return "Returning no value from fallback method";
    }
}
