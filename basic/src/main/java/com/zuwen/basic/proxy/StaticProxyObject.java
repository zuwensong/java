package com.zuwen.basic.proxy;

public class StaticProxyObject implements SomeService {

    private TargetObject targetObject;

    public StaticProxyObject(TargetObject targetObject) {
        this.targetObject = targetObject;
    }

    /**
     * 增强目标类中的方法
     * @return 返回大写的字符串
     */
    @Override
    public String doSome() {
        return targetObject.doSome().toUpperCase();
    }
}
