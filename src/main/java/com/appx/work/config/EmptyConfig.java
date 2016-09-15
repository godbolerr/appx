package com.appx.work.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

// Required for unit testing classes which does not need any database access/camel access
@Configuration
@ComponentScan(basePackages = {"com.appx.work.config","com.appx.work.service","com.appx.work.controller"})
@PropertySource("classpath:application.properties")
public class EmptyConfig {

}
