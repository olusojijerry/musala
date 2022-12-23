package com.musala.soft.scheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DroneScheduler {
    public static void main(String[] args){
        SpringApplication.run(DroneScheduler.class, args);
    }
}
