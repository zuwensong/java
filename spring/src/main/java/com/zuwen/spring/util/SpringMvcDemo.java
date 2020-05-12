package com.zuwen.spring.util;

/**
 * Spring Mvc
 * DispatcherServlet【前置控制器】配置在web.xml中，主要作用：拦截匹配的请求，然后根据相应的规则将请求分发到对应的Controller上。
 * Spring Mvc组件
 *  1.DispatcherServlet
 *  2.HandlerMapping
 *  3.Controller
 *  4.ModelAndView          模型和视图
 *  5.ViewResolver          视图解析器
 * 整体流程：
 *  1.请求被DispatcherServlet拦截，然后它会去查询handlerMapping，找到对应的Controller并将请求分发到对应的Controller
 *  2.Controller处理完业务后返回一个ModelAndView,之后拦截器会查询对应ViewResolver找到ModelAndView指定的视图，渲染并返回客户端。
 */
public class SpringMvcDemo {
}
