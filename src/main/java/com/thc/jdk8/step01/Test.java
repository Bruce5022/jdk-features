package com.thc.jdk8.step01;

import com.thc.model.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    private static List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 9999.99),
            new Employee("李四", 38, 5555.55),
            new Employee("王五", 50, 6666.66),
            new Employee("赵六", 16, 1111.11),
            new Employee("田七", 8, 3333.33),
            new Employee("史八", 32, 2222.22)
    );


    public static void main(String[] args) {
//        Test.employees=null;
//        List<Employee> collect = employees.stream().filter((e) -> e.getAge() > 20).collect(Collectors.toList());
//        for (Employee col : collect) {
//
//            System.out.println(col);
//        }

        String s = Integer.toBinaryString(17);
        System.out.println(s);
       s = Integer.toBinaryString(13);
        System.out.println(-5 + 1/4 + 2*-3 + 5.0);
    }
}
