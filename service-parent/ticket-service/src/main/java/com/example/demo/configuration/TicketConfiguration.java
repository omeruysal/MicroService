package com.example.demo.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.example")
@EnableElasticsearchRepositories

@EnableEurekaClient
public class TicketConfiguration {
	
	   @Bean
	    public ModelMapper modelMapper(){
	        return new ModelMapper();
	    }

}
