## Refer spring-cloud-netflix-circuit-breaker
Hystrix on Inventory Service

From inventory-service we are invoking REST endpoint on 
catalog-service to get the product info.
What if catalog-service is down? What if catalog-service is taking 
too long to respond thereby slowing down all the services depending on it? 
We would like to have some timeouts and implement some fallback mechanism.

Add Hystrix starter to inventory-service.

<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
</dependency>

To enable Circuit Breaker add @EnableCircuitBreaker 
annotation on inventory-service entry-point class.

 use @HystrixCommand annotation on any method we want to apply timeout and fallback method.
 
## Instead of configuring these parameter values in the code we can configure them in bootstrap.properties/yml files as follows.
hystrix.command.getProductInventoryByCode.execution.isolation.thread.timeoutInMilliseconds=2000
hystrix.command.getProductInventoryByCode.circuitBreaker.errorThresholdPercentage=60

@HystrixCommand(commandKey = "inventory-by-productcode", fallbackMethod = "getDefaultProductInventoryByCode")

Hystrix Dashboard dependency or
common dashboard using Turbine

Instead of having a separate dashboard for every service we can use Turbine to provide a unified view of all services in a single dashboard. For more details see http://cloud.spring.io/spring-cloud-static/Finchley.M7/single/spring-cloud.html#_turbine.

