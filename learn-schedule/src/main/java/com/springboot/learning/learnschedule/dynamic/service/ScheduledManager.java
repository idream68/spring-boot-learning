package com.springboot.learning.learnschedule.dynamic.service;

import com.springboot.learning.learnschedule.common.MyTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;

/**
 * @Editor zjhan
 * @Date 2021/12/7 20:38
 * @Description 动态定时任务管理器
 */
@Service
public class ScheduledManager {
    private final Logger log = LoggerFactory.getLogger(ScheduledManager.class);

    private final ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
    private final Map<String, ScheduledFuture<?>> scheduledFutureMap = new HashMap<>();

    ApplicationContext context;

    @Autowired
    public void setContext(ApplicationContext context) {
        this.context = context;
    }

    @PostConstruct
    public void init() {
        threadPoolTaskScheduler.initialize();
    }

    public void start(String taskName, String scheduleType, String cron, long period) {
        MyTask myTask = context.getBean(MyTask.class);
        myTask.setId(taskName);
        switch (scheduleType) {
            case "cron":
                startCron(myTask, cron);
                break;
            case "fixedRate":
                startFixedRate(myTask, period);
                break;
            case "fixedDelay":
                startFixedDelay(myTask, period);
                break;
            default:
                log.error("Useless scheduleType: {}", scheduleType);
        }
    }

    /**
     * 添加cron类型的定时任务
     * @param myTask
     * @param cron
     */
    private void startCron(MyTask myTask, String cron) {
        ScheduledFuture<?> scheduledFuture = threadPoolTaskScheduler.schedule(
                myTask,
                triggerContext -> new CronTrigger(cron).nextExecutionTime(triggerContext));
        scheduledFutureMap.put(myTask.getId(), scheduledFuture);
    }

    /**
     * 添加fixedRate类型定时任务
     * @param myTask
     * @param period
     */
    private void startFixedRate(MyTask myTask, long period) {
        ScheduledFuture<?> scheduledFuture = threadPoolTaskScheduler.scheduleAtFixedRate(myTask, period);
        scheduledFutureMap.put(myTask.getId(), scheduledFuture);
    }

    /**
     * 添加fixedDelay类型定时任务
     * @param myTask
     * @param period
     */
    private void startFixedDelay(MyTask myTask, long period) {
        ScheduledFuture<?> scheduledFuture = threadPoolTaskScheduler.scheduleWithFixedDelay(myTask, period);
        scheduledFutureMap.put(myTask.getId(), scheduledFuture);
    }

    /**
     * 根据任务id取消定时任务
     * @param taskId
     */
    public void cancel(String taskId) {
        ScheduledFuture<?> scheduledFuture = scheduledFutureMap.get(taskId);
        if (scheduledFuture!=null && !scheduledFuture.isCancelled()) {
            scheduledFuture.cancel(false);
        }
        scheduledFutureMap.remove(taskId);
    }

    /**
     * 重置指定定时任务
     * @param taskName
     * @param scheduleType
     * @param cron
     * @param period
     */
    public void reset(String taskName, String scheduleType, String cron, long period) {
        cancel(taskName);
        start(taskName, scheduleType, cron, period);
    }
}
