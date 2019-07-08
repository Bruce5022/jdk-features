package com.thc.service;

@FunctionalInterface
public interface MyPredicate<T> {
    boolean test(T t);
}
