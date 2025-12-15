package com.example.car;

import com.example.car.entities.Car;
import com.example.car.repositories.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class CarApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(5000);
        requestFactory.setReadTimeout(5000);
        restTemplate.setRequestFactory(requestFactory);

        return restTemplate;
    }
    @Bean
    CommandLineRunner loadData(CarRepository carRepository) {
        return args -> {

            carRepository.save(new Car(null, "Toyota", "A 123 45", "Corolla", 1L));
            carRepository.save(new Car(null, "Renault", "B 987 65", "Clio", 1L));
            carRepository.save(new Car(null, "Peugeot", "C 456 78", "208", 2L));
            carRepository.save(new Car(null, "Mercedes", "D 222 11", "C-Class", 3L));
            carRepository.save(new Car(null, "BMW", "E 555 22", "320i", 2L));

            System.out.println("✔ Fake voiture dataset loaded!");
        };
    }
}
