package com.thc.jdk8.step01;

public class Demo03Test {
    public static void main(String[] args) {
        Long op = op(100l, 200l, (t1, t2) -> t1 + t2);
        System.out.println(op);
    }

    public static Long op(Long t1, Long t2, MyFunction2<Long, Long> myFunction) {
        return myFunction.getValue(t1, t2);
    }
}
