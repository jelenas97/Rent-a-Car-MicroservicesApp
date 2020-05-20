package com.messages;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MessagesApplication {
    public static void main(String[] args){
        SpringApplication.run(MessagesApplication.class,args);
    }
}