package com.advertisement;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableEurekaClient
@EnableTransactionManagement
@EnableJpaRepositories
@EnableFeignClients
@EnableRabbit
public class AdvertisementApplication {

    @Value("${location-queue}")
    private String queueName;

    @Value("${host}")
    private String host;



    @Bean
    public Queue incomingQueue() {
        Queue queue = new Queue(this.queueName, true);
        return queue;
    }

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory(this.host);
        return connectionFactory;
    }
    @Bean
    public RabbitAdmin rabbitAdmin() {
        RabbitAdmin rabbitAdmin = new RabbitAdmin(connectionFactory());
        rabbitAdmin.afterPropertiesSet();
        rabbitAdmin.declareQueue(incomingQueue());
        return  rabbitAdmin;
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange("default-exchange", true, false);
    }

    public static void main(String[] args){
        SpringApplication.run(AdvertisementApplication.class,args);
    }
}
