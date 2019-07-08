package com.thc.jdk8.step01;

@FunctionalInterface
public interface MyFunction2<T, R> {
    R getValue(T t1, T t2);
}
