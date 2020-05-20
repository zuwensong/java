package com.zuwen.basic.proxy;

/**
 * 需要被代理的类
 */
public class TargetObject implements SomeService {

    /**
     * 需要被代理的方法
     * @return Str
     */
    @Override
    public String doSome() {
        return "hello";
    }

}
