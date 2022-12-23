package com.musala.soft.scheduler.config;

import com.musala.soft.scheduler.task.Scheduler;
import com.musala.soft.scheduler.task.SchedulerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class CustomConfig {

    @Bean
    public Scheduler scheduler(){
        return new SchedulerImpl();
    }

    @Bean
    public WebClient webClient(){
        return WebClient.builder().build();
    }

    @Bean(name = "musalaWebclient")
    public WebClient.Builder musalaWebclient(){
        return WebClient.create().mutate();
    }
}
