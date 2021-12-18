package com.springboot.learning.learnschedule.common;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Editor zjhan
 * @Date 2021/12/7 20:42
 * @Description 定时任务执行器，简单例子
 */
@Component
@Scope("prototype")
public class MyTask implements Runnable {
    String id;

    public MyTask(String id) {
        this.id = id;
    }

    public MyTask() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("thread: " + Thread.currentThread().getName() + " taskId: " + this.id + " time: " + new Date());
    }
}
