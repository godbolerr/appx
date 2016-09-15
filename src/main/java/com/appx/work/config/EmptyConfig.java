package com.appx.work.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

// Required for unit testing classes which does not need any database access/camel access
@Configuration
@PropertySource("classpath:application.properties")
public class EmptyConfig {

}
