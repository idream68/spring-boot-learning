package com.springboot.learning.learnschedule.determine;

import com.springboot.learning.learnschedule.common.MyTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@EnableScheduling
@Service
public class RunTaskSchedule {
    MyTask cronTask;
    MyTask fixedRateTask;
    MyTask fixedDelayTask;

    @Autowired
    public void init(MyTask cronTask, MyTask fixedRateTask, MyTask fixedDelayTask) {
        this.cronTask = cronTask;
        this.cronTask.setId("cron");
        this.fixedRateTask = fixedRateTask;
        this.fixedRateTask.setId("fixedRate");
        this.fixedDelayTask = fixedDelayTask;
        this.fixedDelayTask.setId("fixedDelay");
    }

    @Async
    @Scheduled(cron = "*/10 * * * * *")
    public void scheduleByCron() {
        this.cronTask.run();
    }

    @Async
    @Scheduled(fixedRate = 2000)
    public void scheduleByFixedRate() {
        this.fixedRateTask.run();
    }

    @Async
    @Scheduled(fixedDelay = 3000)
    public void scheduleByFixedDelay() {
        this.fixedDelayTask.run();
    }
}
