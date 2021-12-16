package com.springboot.learning.customerbeanname.config;

import com.springboot.learning.customerbeanname.generator.DecapitalizeClassNameGenerator;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@Configuration
@ComponentScan(basePackages = "com.springboot.learning.customerbeanname.bean", nameGenerator = DecapitalizeClassNameGenerator.class)
public class DecapitalizeBeanGeneratorConfig {
}
