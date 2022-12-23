package com.musala.soft.scheduler.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulerTask {
    @Autowired
    Scheduler scheduler;

    @Scheduled(cron = "${spring.drone.scheduling.drone-status}")
    public void updateDroneStatus(){
        scheduler.updateDroneStatus();
    }

}
