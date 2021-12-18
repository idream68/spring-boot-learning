package com.springboot.learning.learnschedule.dynamic.controller;

import com.springboot.learning.learnschedule.dynamic.service.ScheduledManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Editor zjhan
 * @Date 2021/12/8 10:10
 * @Description TODO
 */
@RestController
public class ScheduleSetController {
    ScheduledManager scheduledManager;

    @Autowired
    public void setScheduledManager(ScheduledManager scheduledManager) {
        this.scheduledManager = scheduledManager;
    }

    @PostMapping("/add-task")
    public ResponseEntity addScheduleTask(@RequestParam("taskName") String taskName,
                                          @RequestParam("scheduleType") String scheduleType,
                                          @RequestParam(value = "cron", required = false, defaultValue = "0 0 0 0 0 0") String cron,
                                          @RequestParam(value = "period", required = false, defaultValue = "-1") long period) {
        try {
            scheduledManager.start(taskName, scheduleType, cron, period);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/remove-task")
    public ResponseEntity removeTask(@RequestParam("taskName") String taskName) {
        try {
            scheduledManager.cancel(taskName);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/reset-task")
    public ResponseEntity resetTask(@RequestParam("taskName") String taskName,
                                    @RequestParam("scheduleType") String scheduleType,
                                    @RequestParam(value = "cron", required = false) String cron,
                                    @RequestParam(value = "period", required = false) long period) {
        try {
            scheduledManager.reset(taskName, scheduleType, cron, period);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }
}
