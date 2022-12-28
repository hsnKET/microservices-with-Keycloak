# Microservices Architectures with (Spring Cloud Config, Consul Discovery, Consul Config,Vault)

## Project Architecture

## Project Structure
![image](https://user-images.githubusercontent.com/94486861/209438466-f5708731-d5fa-46c6-a235-04c9b5fd4f1c.png)

## Consul

Consul is a powerful service networking tool that enables services to discover and connect with each other.

- To start the Consul server, you can use the following command:
```bash
consul agent -server -bootstrap-expect=1 -data-dir=DATA_FOLDER_HERE -ui -bind=YOUR_IP_HERE
```

### My Result 

![image](https://user-images.githubusercontent.com/94486861/209437987-c466b214-7a53-409a-b6f8-fab7182985cb.png)

## Gateway Service
Start up point
```java
@SpringBootApplication
public class GatewaysServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewaysServiceApplication.class,args);
    }

    @Bean
    DiscoveryClientRouteDefinitionLocator locator(ReactiveDiscoveryClient rdc, DiscoveryLocatorProperties dlp){
        return new DiscoveryClientRouteDefinitionLocator(rdc,dlp);
    }

}
```

#### Configuration File
contains `config-service`  and [`CORS`](https://fr.wikipedia.org/wiki/Cross-origin_resource_sharing) configuration

```properties
server:
  port: 9999
spring:
  application:
    name: gateway-service
  config:
    import: optional:configserver:http://localhost:5544
  cloud:
    gateway:
      globalcors:
        cors-configurations:
          '[/**]':
            allowedOrigins: "http://localhost:4200"
            allowedHeaders: "*"
            allowedMethods:
              - GET
              - POST
              - DELETE
              - PUT

```

#### Test 
`order-servie`

![image](https://user-images.githubusercontent.com/94486861/209437774-75a84c3d-2575-4700-9efe-07ff9a0ac4f0.png)

`customer-servie`

![image](https://user-images.githubusercontent.com/94486861/209437803-6961129d-0e20-46ed-ad57-50dcdffb25de.png)

`inventory-serivce`

![image](https://user-images.githubusercontent.com/94486861/209437813-de944203-2610-4368-b649-1be08a29bfe7.png)

`billing-serivce`

![image](https://user-images.githubusercontent.com/94486861/209438427-8787c080-00cb-4a8b-b97b-8c04a42ed2e6.png)


## Config Service
This service provides us ability to stores configuration data in a version control system Git, and allows other services to retrieve this data from it at runtime.

```yml
server:
  port: 5544
spring:
  application:
    name: config-service
  cloud:
    config:
      server:
        git:
          uri: REPO_PATH
          default-label: master
```
### Test 
test `customer-service` simple configuration

![image](https://user-images.githubusercontent.com/94486861/209437384-7ac6f6cc-7770-449b-a44d-7f030acfee24.png)

## Customer Service
### Project Structure
![image](https://user-images.githubusercontent.com/94486861/209438538-d5f6078e-8a5e-480f-9d8d-1f2162111615.png)

### Test

![image](https://user-images.githubusercontent.com/94486861/209438632-630512ac-59f6-414b-a566-98c6bb79e8b5.png)

## Inventory Service
### Project Structure
![image](https://user-images.githubusercontent.com/94486861/209438697-960654b6-ab61-4e8e-a719-dd01cb0d4b40.png)
### Configuration
```properties
server:
  port: 8787
spring:
  application:
    name: order-service
  h2:
    console:
      enabled: true
  datasource:
    url: jdbc:h2:mem:orders-db
  #
  config:
    import: optional:configserver:http://localhost:5544
logging:
  level:
    me.ketlas.orderservice.services.CustomerRestClientService: debug
    me.ketlas.orderservice.services.ProductRestClientService: debug

```
### Test
![image](https://user-images.githubusercontent.com/94486861/209438740-9663cbf3-eb7d-471f-a5fa-7d5bfd0bd6c4.png)

## Order Service
### Project Structure
![image](https://user-images.githubusercontent.com/94486861/209438772-17df8c72-2141-4956-bea1-b86feb8dca86.png)

### Test
![image](https://user-images.githubusercontent.com/94486861/209438801-8da0c591-61e7-445b-8a19-b913310b5e90.png)

## Billing Service
### Project Structure
![image](https://user-images.githubusercontent.com/94486861/209438970-452cdf62-1ccb-4e7e-a556-e3322ca83dc7.png)

### Test
![image](https://user-images.githubusercontent.com/94486861/209438427-8787c080-00cb-4a8b-b97b-8c04a42ed2e6.png)

## FrontEnd

### Project Structure
![image](https://user-images.githubusercontent.com/94486861/209439049-095f8846-6019-4e40-be77-4f8fe61378cc.png)

### Products List
![image](https://user-images.githubusercontent.com/94486861/209440238-38c80345-d99a-4844-937f-118cf71aae28.png)

### Customers List
![image](https://user-images.githubusercontent.com/94486861/209440282-057777d9-6b83-4b26-b212-26511a43c1c0.png)


### Customer Orders List
![image](https://user-images.githubusercontent.com/94486861/209440326-072e33be-0369-40d9-b3b3-9bddbd3574ef.png)


### Order Details
![image](https://user-images.githubusercontent.com/94486861/209440719-a36aeaf2-0093-41dc-a0df-2ee34449fc47.png)









