package com.thc.lambda;

import com.thc.service.GreetingService;

public class TestLambda02 {

    public static void main(String[] args) {
        test01();

    }


    /**
     * lambda表达式实现接口，参数类型默认是接口中定义的参数
     * 类型，如果跟接口方法参数不一致，或者类型不对，都会报错
     */
    public static void test01() {
        GreetingService greetingService = (x) -> System.out.println(x + System.currentTimeMillis() + "!");
        greetingService.sayMessage("你好，");
    }

}
