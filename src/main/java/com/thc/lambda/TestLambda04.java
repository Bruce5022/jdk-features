package com.thc.lambda;

import com.thc.model.Employee;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

/**
 * lambda表达式练习
 * "->" lambda操作符
 * 左边：参数列表
 * 右边：执行功能
 * lambda表达式需要函数式接口的支持
 *
 * @FunctionalInterface注解辨识的是函数式接口
 */
public class TestLambda04 {

    public static void main(String[] args) {
//        test01();
        test02();
    }

    // 最初实现Runnable接口方式
    public static void test01() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello world");
            }
        };

        new Thread(runnable).start();

    }

    // lambda实现
    public static void test02() {
        new Thread(() -> System.out.println("hello world")).start();
    }

    // 有一个参数,无返回值
    public static void test03() {
        Consumer<String> consumer = x -> System.out.println(x);
        consumer.accept("szw");
    }

    // 有两个参数,有返回值,并且Lambda体中有多条语句
    public static void test04() {
        List<Integer> list = Arrays.asList(5, 2, 6, 5, 8, 8, 4);
        Comparator<Integer> comparator = (x, y) -> {
            System.out.println("x=" + x + ",y=" + y);
            return Integer.compare(x, y);
        };
        Collections.sort(list, comparator);
        System.out.println(list);
    }

    // 若Lambda体中只有一条语句,return和大括号都可以省略不写
    public static void test05() {
        List<Integer> list = Arrays.asList(5, 2, 6, 5, 8, 8, 4);
        Comparator<Integer> comparator = (x, y) -> Integer.compare(x, y);
        Collections.sort(list, comparator);
        System.out.println(list);
    }

    // Lambda表达式参数列表的数据类型可以省略不写,因为JVM编译器可以根据上下文推出数据类型,即"类型推断".
    public static void test06() {
        List<Integer> list = Arrays.asList(5, 2, 6, 5, 8, 8, 4);
        // 下面的语法,参数列表如果写参数数据类型,都要写,如果不写都不写
        // 如下语法是可以省略参数类型的,因为前面返回值接受者有数据类型,所以,可以省略掉
        // Comparator<Integer> comparator = (Integer x, Integer y) -> Integer.compare(x, y);
        // 下面是可以的
        Comparator<Integer> comparator = (x, y) -> Integer.compare(x, y);
//        下面无法推出类型,是报错的
//        Comparator comparator = (x, y) -> Integer.compare(x, y);
        Collections.sort(list, comparator);
        System.out.println(list);
    }


}
