package com.thc.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class TestLambda01 {

    public static void main(String[] args) {
//        test01();
        test02();

    }

    // 原来的匿名内部类
    public static void test01() {
        List<Integer> list = Arrays.asList(5, 2, 6, 5, 8, 8, 4);
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println(o1 + "-----------" + o2);
                return Integer.compare(o1, o2);
            }
        };
        Collections.sort(list, comparator);
        System.out.println(list);
    }

    public static void test02() {
        List<Integer> list = Arrays.asList(5, 2, 6, 5, 8, 8, 4);
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };

        TreeSet<Integer> treeSet = new TreeSet<>(comparator);
        treeSet.addAll(list);
        System.out.println(treeSet);
    }
}
