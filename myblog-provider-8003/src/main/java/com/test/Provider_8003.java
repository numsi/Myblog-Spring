package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author numsi
 * @date 2020/4/29 20:27
 */
@SpringBootApplication
@EnableEurekaClient//在服务启动后自动注册到Eureka中
@EnableDiscoveryClient//服务发现
public class Provider_8003 {
    public static void main(String[] args) {
        SpringApplication.run(Provider_8003.class,args);
    }
}
