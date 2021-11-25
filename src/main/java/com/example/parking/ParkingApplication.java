package com.example.parking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories("Repository")
@ComponentScan({"Repository"})
@EntityScan({"Entity"})
@ComponentScan(basePackageClasses = Controller.class)
public class ParkingApplication /*implements CommandLineRunner*/ {

    public static void main(String[] args) {
        SpringApplication.run(ParkingApplication.class, args);

    }
/*
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {
       /*Customer customer = new Customer("dd", 77);
        Car bmw = new Car(777, "bmw", "X5");
        customer.setCarList(Arrays.asList(bmw));
        customerRepository.save(customer);
    }*/
}
