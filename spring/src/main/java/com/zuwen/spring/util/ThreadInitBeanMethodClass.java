package com.zuwen.spring.util;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Spring中添加Bean的初始化方法和销毁方法的三种方式
 * 1.对于基于配置文件配置的bean，使用<bean init-method="xxxMethod" destory-method='yyyMethod'/>
 * 2.Bean可以实现InitializingBean,DisposableBean接口
 * 3.Bean中使用@PostConstruct,@PreDestroy指定
 *
 * 优先级：
 * 初始化之后执行： @PostConstruct > InitializingBean > init-method
 * 销毁之前执行：@preDestroy > DisposableBean > destoryMethod
 */
public class ThreadInitBeanMethodClass {
}


class DemoBean implements InitializingBean, DisposableBean {
    private String name;
    private Integer age;

    @PostConstruct
    private void init() {

    }

    @PreDestroy
    private void destory() {

    }

    @Override
    public void destroy() throws Exception {

    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}