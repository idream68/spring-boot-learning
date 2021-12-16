package com.springboot.learning.customerbeanname;

import com.springboot.learning.customerbeanname.filter.CustomerBeanNameFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

//@SpringBootApplication
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan(excludeFilters = {@ComponentScan.Filter(type = FilterType.CUSTOM, classes = CustomerBeanNameFilter.class)})
public class CustomerBeanNameApplication {

    @Autowired
    com.springboot.learning.customerbeanname.bean.User user1;
    @Autowired
    com.springboot.learning.customerbeanname.bean.bean1.User user2;
    @Autowired
    com.springboot.learning.customerbeanname.bean.bean2.User user3;

    public static void main(String[] args) {
        SpringApplication.run(CustomerBeanNameApplication.class, args);
    }

}
