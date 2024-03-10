package com.joker.ojbackendjudgeservice;

import com.joker.ojbackendjudgeservice.rabbitmq.InitRabbitMq;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class})
@EnableScheduling
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
@ComponentScan("com.joker")
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.joker.ojbackendserviceclient.service"})
public class OjBackendJudgeServiceApplication {

    public static void main(String[] args) {
        //初始化消息队列
        InitRabbitMq.doInit();
        SpringApplication.run(OjBackendJudgeServiceApplication.class, args);
    }

}
