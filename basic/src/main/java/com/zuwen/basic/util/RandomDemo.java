package com.zuwen.basic.util;

import java.math.BigDecimal;
import java.util.Random;

/**
 * 生成随机数
 */
public class RandomDemo {
    public static void main(String[] args) {
        create0_1();
        create0_10();
    }

    /**
     * 生成[0,1)之间的随机数
     */
    private static void create0_1() {
        double count = Math.random();
        BigDecimal bigDecimal = new BigDecimal(count);
        BigDecimal countFormat = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_DOWN);
        System.out.println(countFormat);
    }

    /**
     * 生成[0,10)之间的随机整数
     */
    private static void create0_10() {
        Random random = new Random();
        int count = random.nextInt(10);
        System.out.println(count);
    }
}
