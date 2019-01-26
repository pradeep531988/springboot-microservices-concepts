# This project is an example of Service Discovery and Service Registry
# 1 API GATEWAY 4 MICROSERVICE CLIENT 1 CONFIG SERVER 1 EUREKHA SERVER

# This project has 4 micro service client and 1 API gateway, 1 EUREKHA SERVER and 1 CONFIG SERVER
# Multiple instance of Catalog Service is run on different port,
  but based on serviceID its registered in Eurekha Server
# Config-Server application is used to get Application configuration dynamically
# ALL 4 eurekha client are registered with eurekha server
# Using RestTemplate and LoadBalancer api call to Catalog Service is made from Inventory Service
# Multiple instance of Catalog Service is run and api call is made from inventory service
# by refering to Service Id instead of IP.
# Hystrix server will automatically perform load balancing

#   @Bean
#   @LoadBalanced
#    public RestTemplate restTemplate() {
#        return new RestTemplate();
#    }
# restTemplate.getForEntity("http://catalog-service/api/products/{code}",String.class,code);
