package me.ketlas.customerservice;

import com.github.javafaker.Faker;
import me.ketlas.customerservice.entities.Customer;
import me.ketlas.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.stream.IntStream;

@SpringBootApplication
public class CustomerServiceApplication {


    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class,args);
    }

    @Bean
    CommandLineRunner start(CustomerRepository customerRepository){
        return args -> {
            Faker faker = new Faker();
            IntStream.range(0,100)
                    .forEach(name ->{
                        String fullName = faker.name().fullName();
                        customerRepository.save(Customer.builder()
                                .email(fullName.replaceAll("[^A-Za-z]",".").concat("@gmail.com"))
                                .name(fullName)
                                .build());
                    });
        };
    }
}
