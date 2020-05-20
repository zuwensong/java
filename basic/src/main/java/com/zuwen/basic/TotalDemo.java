package com.zuwen.basic;

/**
 * JVM
 *  1.JVM的组成部分
 *      类加载器
 *      执行引擎
 *      内存区
 *      本地方法调用
 *
 * volatile为什么不具有原子性
 *  对于AB两个线程对变量a++操作，a++操作分三步：1.从主存获取a的值；2.对a+1；3.将a+1后的值写入主存
 *  在第一步的时候AB两个线程同时获取a,然后A线程加一并更新主存，但是此时B线程没有重新读取a所以B加一写入主存的值不正确了
 */
public class TotalDemo {
}
