package com.thc.stream;

import com.thc.model.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Stream的中间操作
 * 多个中间操作可以链接起来形成一个流水线，除非流水线上触发终止操作
 * 否则，中间操作不会执行任何的处理。
 * 而在终止操作时，一次性全部处理，称为"惰性求值"
 * 筛选与切片
 * 1.filter(Predicate p) 接收lambda从流中排除某些元素
 * 2.distinct() 筛选，通过流所生成元素的hashCode和equals()
 * 3.limit()和skip()
 * 映射
 * map()
 * mapToDouble()
 * mapToInt()
 * mapToLong()
 * flatMap()
 * 排序
 * sorted()
 * sorted(Comparator comp)
 */
public class TestStream02 {

    private static List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 9999.99),
            new Employee("李四", 38, 5555.55),
            new Employee("王五", 50, 6666.66),
            new Employee("赵六", 16, 1111.11),
            new Employee("田七", 8, 3333.33),
            new Employee("史八", 32, 2222.22)
    );

    public static void main(String[] args) {

        test01();
    }

    // map - 接收lambda，将元素转换成其它形式或提取信息
    // 接收一个函数作为参数，该函数会被应用到每个元素上，并
    // 将其映射成一个新的元素
    public static void test01() {
        List<String> list = Arrays.asList("aaa", "bbb", "ccc");

        list.stream().map((str) -> str.toUpperCase()).forEach(System.out::println);

        System.out.println("-------------------------");
        employees.stream().map(Employee::getName).forEach(System.out::println);


        Stream<Stream<Character>> stream = list.stream().map(TestStream02::filterCharacter);
        stream.forEach((sm) -> {
            sm.forEach(System.out::println);
        });


        System.out.println("=========");
        Stream<Character> stream2 = list.stream().flatMap(TestStream02::filterCharacter);
        stream2.forEach(System.out::println);
    }

    public static Stream<Character> filterCharacter(String str) {
        List<Character> list = new ArrayList<>();
        for (Character chater : str.toCharArray()) {
            list.add(chater);
        }

        return list.stream();
    }
}
