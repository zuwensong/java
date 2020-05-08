package com.zuwen.basic.util;

/**
 * 向下取整：指取比当前小数小的最大整数
 * 向上取整：指取比当前小数大的最大整数
 */
public class MathDemo {
    public static void main(String[] args) {
        roundMethod();

        floorMethod();

        ceilMethod();
    }

    /**
     * round方法的功能：加上0.5，然后向下取整数
     */
    private static void roundMethod() {
        System.out.println(Math.round(1.4));
        System.out.println(Math.round(1.5));
        System.out.println(Math.round(1.6));

        System.out.println(Math.round(-1.4)); //-0.9 =-1
        System.out.println(Math.round(-1.5)); // -1 = -1
        System.out.println(Math.round(-1.6)); // -1.1 = -2
    }

    /**
     * 向下取整，但是返回的是double类型
     */
    private static void floorMethod() {
        System.out.println(Math.floor(1.4));
        System.out.println(Math.floor(1.5));
        System.out.println(Math.floor(1.6));

        System.out.println(Math.floor(-1.4));
        System.out.println(Math.floor(-1.5));
        System.out.println(Math.floor(-1.6));
    }


    /**
     * 向上取整，但是返回的是double类型
     */
    private static void ceilMethod() {
        System.out.println(Math.ceil(1.4));
        System.out.println(Math.ceil(1.5));
        System.out.println(Math.ceil(1.6));

        System.out.println(Math.ceil(-1.4));
        System.out.println(Math.ceil(-1.5));
        System.out.println(Math.ceil(-1.6));
    }
}
