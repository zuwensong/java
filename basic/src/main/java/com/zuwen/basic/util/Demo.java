package com.zuwen.basic.util;

import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/**
 * log4j.xml https://blog.csdn.net/niuch1029291561/article/details/80938095
 */
public class Demo {
    public static void main(String[] args) {
        System.out.println(test2());
    }

    private static int test() {
        int a = 0;
        try {
            a = 10;
            return a;
        }finally {
            a = 5;
        }
    }
    private static Integer test2() {
        Integer a = 0;
        try {
            a = 10;
            return a;
        }finally {
            a = 5;
        }
    }
}
