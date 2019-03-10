package com.thc.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Java8内置的四大核心函数式接口
 * 1.Consumer<T> 消费型接口
 * void accept()
 * 2.Supplier<T> 供给型接口
 * T get()
 * 3.Function<T, R> 函数型接口
 * R apply(T t)
 * 4.Predicate<T> 断言型接口
 * T test(T t)
 */
public class TestLambda05 {

    public static void main(String[] args) {
//        cal(1.2, (m) -> System.out.println(m));
        List<Integer> list = getNumList(10, () -> 5);
        System.out.println(list.size());
    }

    //消费型
    public static void cal(double money, Consumer<Double> consumer) {
        consumer.accept(money);
    }

    //供给型
    //需求：产生一些整数，并放入集合中
    public static List<Integer> getNumList(int size, Supplier<Integer> supplier) {
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            integers.add(supplier.get());
        }
        return integers;
    }

}
