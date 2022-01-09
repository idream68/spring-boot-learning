package com.springboot.learning.tools.stopwatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//import org.springframework.web.util.UriUtils;
//import org.springframework.web.util.WebUtils;
//
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//import java.nio.charset.StandardCharsets;
import java.util.Random;

/**
 * 没步执行时间并自动计算每步运行时间比
 * 每步不能有交叉
 */
@Service
public class StopWatchDemo {
    private final Logger log = LoggerFactory.getLogger(StopWatchDemo.class);

    public void stopWatchDemo() throws InterruptedException {
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//          获取指定cookie
//        Cookie cookie = WebUtils.getCookie(request, "hello");
//        UriUtils.decode("", StandardCharsets.UTF_8);
//        UriUtils.encode("", StandardCharsets.UTF_8);
        // 设置id
        StopWatch stopWatch = new StopWatch(String.valueOf(new Random().nextInt()));
//        开始第一步
        stopWatch.start("Step 1");
        int r1 = new Random().nextInt();
        int s1 = (r1 > 0 ? r1 : -r1) % 1000;
        System.out.println(s1);
        Thread.sleep(s1);
//        结束第一步
        stopWatch.stop();
//        开始第二步
        stopWatch.start("Step 2");
        int r2 = new Random().nextInt();
        int s2 = (r2 > 0 ? r2 : -r2) % 10000;
        System.out.println(s2);
        Thread.sleep(s2);
//        结束第二步
        stopWatch.stop();
        log.info("step times: {}", stopWatch.prettyPrint());
    }
}
