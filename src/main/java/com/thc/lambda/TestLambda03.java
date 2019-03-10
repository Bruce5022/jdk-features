package com.thc.lambda;

import com.thc.model.Employee;
import com.thc.service.MyPredicate;
import com.thc.service.impl.FilterEmployeeByAge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestLambda03 {
    private static List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 9999.99),
            new Employee("李四", 38, 5555.55),
            new Employee("王五", 50, 6666.66),
            new Employee("赵六", 16, 1111.11),
            new Employee("田七", 8, 3333.33),
            new Employee("史八", 32, 2222.22)
    );


    public static void main(String[] args) {
//        test01();
//        test02()
//        test03();
//        test04();

        test05();
    }

    /**
     * 最初方式过滤数据年龄
     */
    private static void test01() {
        List<Employee> emps = filterEmployeesByAge(employees);
        for (Employee emp : emps) {
            System.out.println(emp);
        }
    }

    /**
     * 最初方式过滤数据薪资
     */
    private static void test02() {
        List<Employee> emps = filterEmployeesBySalary(employees);
        for (Employee emp : emps) {
            System.out.println(emp);
        }
    }

    /**
     * 设计模式优化后的调用
     */
    private static void test03() {
        List<Employee> emps = filterEmployees(employees, new FilterEmployeeByAge());
        for (Employee emp : emps) {
            System.out.println(emp);
        }
    }

    /**
     * 优化2：用lambda表达式
     */
    private static void test04() {
        List<Employee> emps = filterEmployees(employees, (x) -> x.getAge() >= 25);
        emps.forEach(System.out::println);
    }

    /**
     * 优化3：用stream api优化
     */
    private static void test05() {
        employees.stream().filter((x) -> x.getAge() >= 25).forEach(System.out::println);
    }

    // 需求1：获取当前公司中，员工年龄大于35的员工信息
    public static List<Employee> filterEmployeesByAge(List<Employee> list) {
        List<Employee> emps = new ArrayList<>();
        for (Employee l : list) {
            if (l.getAge() >= 35) {
                emps.add(l);
            }
        }
        return emps;
    }

    // 需求2：获取当前公司中员工工资大于5000的员工信息
    public static List<Employee> filterEmployeesBySalary(List<Employee> list) {
        List<Employee> emps = new ArrayList<>();
        for (Employee l : list) {
            if (l.getSalary() >= 3500) {
                emps.add(l);
            }
        }
        return emps;
    }

    // 优化1：设计模式对需求1和需求2优化的方式
    public static List<Employee> filterEmployees(List<Employee> list, MyPredicate<? super Employee> predicate) {
        List<Employee> emps = new ArrayList<>();
        for (Employee l : list) {
            if (predicate.test(l)) {
                emps.add(l);
            }
        }
        return emps;
    }


}
