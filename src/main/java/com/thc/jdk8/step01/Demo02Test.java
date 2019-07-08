package com.thc.jdk8.step01;

public class Demo02Test {
    public static void main(String[] args) {

        String szw = strHandler("szw", (x) -> x.toUpperCase());
        System.out.println(szw);
        szw = strHandler("szw", (x) -> x.substring(1,2).toUpperCase());
        System.out.println(szw);
    }

    // 需求:用于处理字符串
    public static String strHandler(String str, MyFunction myFunction) {
        return myFunction.getValue(str);
    }
}
