package com.thc.lambda;

import com.thc.model.Employee;

import java.util.function.Consumer;

/**
 * lambda表达式练习
 * "->" lambda操作符
 * 左边：参数列表
 * 右边：执行功能
 * lambda表达式需要函数式接口的支持
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

    // 一个接口
    public static void test03() {
        Consumer<Employee> consumer = x -> System.out.println(x.getAge());
    }
}
