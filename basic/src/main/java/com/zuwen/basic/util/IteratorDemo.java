package com.zuwen.basic.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorDemo {

    public static void main(String[] args) {

        forDemo();
        forDemo2();
        iteratorDemo();
        forEachDemo();
    }

    /**
     * 增强型for循环遍历途中删除会报错ConcurrentModificationException
     */
    private static void forEachDemo() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        for(String a : list) {
            if("b".equals(a)) {
                list.remove(a);
            }
        }

    }


    /**
     * 此中方式结果会少删除一个b，原因就是每次遍历删除一个节点后，空数组会被移动至最后等待GC回收，这样删除节点下面的那些节点就会向上移动
     * 此时这些后续节点索引都前移一位，导致紧跟着的b被跳过去了
     */
    private static void forDemo() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        for (int i=0; i<list.size(); i++) {
            System.out.println(list.get(i));
            if("b".equals(list.get(i))) {
                list.remove(i);
            }
        }
    }

    /**
     * 倒叙遍历可以正常操作，因为删除后的节点再移动已经不影响了
     */
    private static void forDemo2() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        for (int i=list.size()-1; i>=0; i--) {
            if("b".equals(list.get(i))) {
                list.remove(i);
            }
        }
        System.out.println(list);
    }

    /**
     * 可以正常删除
     */
    private static void iteratorDemo() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String str = iterator.next();
            if("b".equals(str)) {
                iterator.remove();
            }
        }
        System.out.println(list);
    }
}
