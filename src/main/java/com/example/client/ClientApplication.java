package com.example.client;

import com.example.client.entities.Client;
import com.example.client.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@SpringBootApplication
@EnableDiscoveryClient
public class ClientApplication implements CommandLineRunner{

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

    @Autowired
    private Environment environment;
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Datasource URL: " + environment.getProperty("spring.datasource.url"));
        System.out.println("Datasource Username: " + environment.getProperty("spring.datasource.username"));
        System.out.println("Datasource Password: " + environment.getProperty("spring.datasource.password"));
    }

    @Bean
    CommandLineRunner initializeH2Database(ClientRepository clientRepository) {
        return args -> {
            clientRepository.save(new Client(Long.parseLong("1"), "Amine SAFI", Float.parseFloat("23")));
            clientRepository.save(new Client(Long.parseLong("2"), "Amal ALAOUI", Float.parseFloat("22")));
            clientRepository.save(new Client(Long.parseLong("3"), "Samir RAMI", Float.parseFloat("22")));
        };
    }
}
