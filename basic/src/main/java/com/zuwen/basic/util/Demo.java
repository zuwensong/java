package com.zuwen.basic.util;

import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/**
 * log4j.xml https://blog.csdn.net/niuch1029291561/article/details/80938095
 */
public class Demo {
    public static void main(String[] args) {
        Random random = new Random();
        int a = random.nextInt(10);
        System.out.println(a);
    }
}
