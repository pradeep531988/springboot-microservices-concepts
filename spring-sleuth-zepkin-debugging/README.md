# springboot-microservices-concepts

Poor man’s distributed tracing
One solution to this is at the beginning of the call chain we can 
create a CORRELATION_ID and add it to all log statements. Along with it, 
send CORRELATION_ID as a header to all the downstream services as well 
so that those downstream services also use CORRELATION_ID in logs. 
This way we can identify all the log statements related to a particular action across services.

add Sleuth dependency:

<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-sleuth</artifactId>
</dependency>

Sleuth includes the pattern [appname,traceId,spanId,exportable] in logs from the MDC.

Observe that TraceID 0335da07260d3d6f is same in both catalog-service and inventory-service for the same REST API call. This way we can easily correlate the logs across services.

Exporting tracing info to Zipkin Server
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-zipkin</artifactId>
</dependency>

Configure Zipkin server URL in bootstrap.properties of both inventory-service and catalog-service.
spring.zipkin.base-url=http://localhost:9411/
spring.sleuth.sampler.probability=1
