package com.zuwen.basic.proxy;

import java.lang.reflect.Proxy;

public class ProxyMain {

    public static void main(String[] args) {
        TargetObject target = new TargetObject();
        StaticProxyObject staticProxyObject = new StaticProxyObject(target);
        System.out.println(staticProxyObject.doSome());


        // JDK 动态代理方式增强目标类TargetObject中的方法doSome()
        SomeService proxy = (SomeService) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), (proxy1, method, args1) -> {
            String targetResult = (String) method.invoke(target, args1);
            return targetResult.toUpperCase();
        });

        // 获取代理类后，调用代理类中的增强方法
        System.out.println(proxy.doSome());
    }
}
