package com.zuwen.thread.util;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 线程
 *
 * Runnable和Callable的区别
 *  1.Runnable里面的是run(), Callable里面的是call()
 *  2.run()没有返回值,不能抛出异常; call()方法有返回值,可以抛出异常
 *  3.Callable的类创建线程的时候需要使用FeatureTask类，该类用来表示异步计算的结果，通过它的get()可以获取线程的计算结果
 *
 * 并发工具类
 *  1.CountDownLatch
 *      等待线程，直到它等待的其他线程都执行完成并且调用countDown()方法发出通知后，当前线程才可以继续执行
 *  2.CyclicBarrier
 *      所有线程都进行等待，直到所有线程都调用await()方法后，同时执行
 *  3.Semaphore
 *  4.Exchanger
 *
 * CAS
 *  compare and swap 比较并替换，采用乐观锁的方式解决多线程场景下线程安全问题，如果内存地址上的值和预期的值相同就进行替换，否则不替换
 *  java中的很多原子操作类里面的incrementAndGet()的实现原理就是采用CAS+自旋的方式实现的
 *
 *  CAS会导致的问题
 *   1.ABA问题
 *      可以使用AtomicStampedReference通过加version的方式来标识每次操作解决ABA问题
 *   2.不能保证代码块的原子性
 *      CAS只能保证单个变量的原子性，对于多个变量的操作，只能使用synchronized了
 *   3.会导致CPU利用率增加
 *      CAS底层是使用循环判断的过程，所以可能会出现CPU一直被占用
 *
 *  自旋
 *   自旋是指等待锁的线程通过循环不断的判断锁是否释放，而不是直接进入阻塞状态，因为线程的阻塞和唤醒会让CPU在用户态和内核态之间切换
 *   而对于大多数场景下，CPU处理同步代码块中的内容是很短暂的，为了这么短暂的时间而去频繁的切换会给CPU带来很大的压力
 *
 *  Synchronized底层原理
 *   1.JDK1.6以后，Synchronized内部的锁状态有四种：无锁状态->偏向锁状态->轻量锁状态->重量锁状态
 *      无锁状态：没加锁状态
 *      偏向锁状态：单线程访问时，synchronized会上偏向锁,当该线程再次获取锁的时候，无需做任何同步操作，只需要判断锁标记位为"偏向锁"，并且线程ID是当前线程ID即可获得锁
 *      轻量锁：当偏向锁被持有的时候，有另外的线程申请锁时，偏向锁会升级为轻量级锁
 *      重量锁：同一时间多个线程竞争锁时，轻量级锁会升级为重量级锁，此时线程会进入阻塞状态，带来的开销也会很大，一般重量级锁用在同步代码执行时间较长的场景
 *   2.在轻量级锁获取失败的时候，线程会进入自旋模式，在达到自旋次数上限还未获取到锁的时候，线程会进入阻塞状态
 *   3.为什么synchronized是非公平锁？
 *      因为synchronized在获取锁的时候采用了自旋模式，去判断锁是否被释放，如果被释放就会进入锁竞争阶段，所以是非公平的
 */
public class TotalDemo {

    public static void main(String[] args) {

    }
}
