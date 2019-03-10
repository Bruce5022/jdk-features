package com.thc.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class TestLambda01 {

    private static List<Integer> list = Arrays.asList(5, 2, 6, 5, 8, 8, 4);

    public static void main(String[] args) {
//        test01();
//        test02();
        test03();

    }

    // 原来的匿名内部类
    public static void test01() {
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
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };

        // 这里可以用有序的treeSet来处理，如果是对象，需要传入Comparator
        TreeSet<Integer> treeSet = new TreeSet<>(comparator);
        treeSet.addAll(list);
        System.out.println(treeSet);
    }

    // 分析：上面的匿名内部类，比较器中，有用的东西，就一点，用最新的Lambda表达式修改后如下
    public static void test03() {
        Comparator<Integer> comparator = (x, y) -> Integer.compare(x, y);
        Collections.sort(list, comparator);
        System.out.println(list);
    }
}
