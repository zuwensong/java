package com.zuwen.spring.util;

/**
 * 什么是Spring Boot
 *  Spring Boot是为Spring服务的，用来简化新Spring应用的搭建和开发过程。
 *  好处：
 *      1.无xml配置，自动创配，配置简单
 *      2.独立运行，易上手，提升开发效率
 *  Spring Boot两个核心配置文件
 *      1.bootstrap.yml
 *      2.application.yml
 *  Spring Boot实现热部署的两种方式
 *      1.使用devtools
 *      2.idea编辑器，勾选自动编译或者手动重新编译
 *
 * 什么是Spring Cloud
 *  Spring Cloud是利用了Spring Boot的开发便捷性，简化了分布式系统的开发，像服务注册中心、配置中心、负载均衡、断路器等等都可以使用Spring Boot开发来实现一键启动和部署。
 *
 * Spring Cloud中的断路器的作用是什么
 *  断路器主要是用来防止因为服务单元出现故障，导致调用方长时间等待从而导致系统瘫痪，Spring Cloud中一般是使用Hystrix。
 *
 * Spring Cloud中的核心组件
 *  1.Eureka
 *  2.Feign
 *  3.Ribbon
 *  4.Hystrix
 *  5.Zuul
 */
public class TotalDemo {
}
