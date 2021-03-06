package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer//EnableEurekaServer服务端启动类，可以接收别人注册进来
public class EurekaServe_7001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServe_7001.class,args);
    }
}
