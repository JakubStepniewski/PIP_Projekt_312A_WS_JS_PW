package com.ztm_proj.ztm_proj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class ZtmProjApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZtmProjApplication.class, args);
    }

}
