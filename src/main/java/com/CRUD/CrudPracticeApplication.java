package com.CRUD;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
@EnableCaching
public class CrudPracticeApplication {
    private static final Logger log = LoggerFactory.getLogger(CrudPracticeApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(CrudPracticeApplication.class, args);
        log.info("Application Started!!!!");
    }

}
