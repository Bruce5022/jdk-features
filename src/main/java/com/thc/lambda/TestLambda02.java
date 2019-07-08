package com.thc.lambda;

import com.thc.service.MathOperation;
import com.thc.service.GreetingService;

/**
 * lambda表达式实现自定义接口的使用
 */
public class TestLambda02 {

    public static void main(String[] args) {
//        test01();
        test02();
    }


    /**
     * lambda表达式实现接口，参数类型默认是接口中定义的参数
     * 类型，如果跟接口方法参数不一致，或者类型不对，都会报错
     */
    public static void test01() {
        GreetingService greetingService = (x) -> System.out.println(x + System.currentTimeMillis() + "!");
        greetingService.sayMessage("你好，");
    }

    /**
     * 实现加减乘除的运算
     */
    public static void test02() {

        MathOperation addOp = (num1, num2) -> num1 + num2;
        MathOperation subOp = (num1, num2) -> num1 - num2;
        MathOperation mulOp = (num1, num2) -> {
            return num1 * num2;
        };
        MathOperation divOp = (num1, num2) -> (num1 * num2);

        System.out.println(addOp.operation(2, 3));
    }

}
