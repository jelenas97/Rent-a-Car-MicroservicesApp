package com.advertisement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@SpringBootApplication
@EnableEurekaClient
@EnableTransactionManagement
@EnableJpaRepositories
public class AdvertisementApplication {
    public static void main(String[] args){
        SpringApplication.run(AdvertisementApplication.class,args);
    }
}