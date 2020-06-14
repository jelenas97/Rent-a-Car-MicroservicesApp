package com.rent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableTransactionManagement
@EnableJpaRepositories
public class RentApplication {
    public static void main(String[] args){
        SpringApplication.run(RentApplication.class,args);
    }
}