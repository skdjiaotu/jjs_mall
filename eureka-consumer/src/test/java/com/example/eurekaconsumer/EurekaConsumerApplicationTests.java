package com.example.eurekaconsumer;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@SpringBootTest
class EurekaConsumerApplicationTests {

    @Test
    void contextLoads() {
        List<Student> l1 = new ArrayList<>();
        l1.add(new Student("jack", 20));
        l1.add(new Student("tom", 20));
        l1.add(new Student("jerry", 20));

        List<Student> l2 = new ArrayList<>();
        l2.add(new Student("haw", 20));
        l2.add(new Student("dame", 20));
        l2.add(new Student("lisa", 20));

        Stream.concat(l1.stream(), l2.stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList()).forEach(System.out::print);

    }


    @Test
    void testBigDecimal() {
        BigDecimal a = new BigDecimal("1.0");
        BigDecimal b = new BigDecimal("0.9");
        BigDecimal c = new BigDecimal("0.8");

        BigDecimal x = a.subtract(b);
        BigDecimal y = b.subtract(c);
        BigDecimal z = b.add(c);

        System.out.println(z); /* 0.1 */
        System.out.println(x); /* 0.1 */
        System.out.println(y); /* 0.1 */
        System.out.println(Objects.equals(x, y)); /* true */

    }

    static class Student {
        String name;
        Integer age;

        Student(String name, Integer age) {
            this.name = name;
            this.age = age;
        }
    }

    @Test
    void testArrayList() {
        List<String> myList =
                Arrays.asList("a1", "a2", "b1", "c2", "c1");

        // myList.stream() // 创建流
        //         .filter(s -> s.startsWith("c")) // 执行过滤，过滤出以 c 为前缀的字符串
        //         .map(String::toUpperCase) // 转换成大写
        //         .sorted() // 排序
        //         .forEach(System.out::println); // for 循环打印
        //
        //
        // myList.stream().findFirst().ifPresent(System.out::println);
        //
        // IntStream.range(1,100).filter(a->a>50).forEach(System.out::println);
        //
        // Arrays.stream(new int[]{1, 23, 14, 41}).map(n -> n * 2 + 1).average().ifPresent(System.out::println);
        //
        // Arrays.stream(new int[]{1, 23, 14, 41}).mapToObj(n ->"a" + n).forEach(System.out::println);
        //
        // Stream.of("d2", "a2", "b1", "b3", "c4").map(s -> {
        //     System.out.println("map" + s);
        //     return s.toUpperCase();
        // }).anyMatch(s -> {
        //     System.out.println("anyMatch" + s);
        //     return s.startsWith("A");
        // });
        //
        // Stream.of("d2", "a2", "b1", "b3", "c4").filter(s -> {
        //     System.out.println("filter" + s);
        //     return s.startsWith("a");
        // }).map(s -> {
        //     System.out.println("map" + s);
        //     return s.toUpperCase();
        // }).forEach(s -> System.out.println("forEach: " + s));
        //
        // Supplier<Stream<String>> supplier = ()-> Stream.of("d2", "a2", "b1", "b3", "c4").filter(a->a.startsWith("a"));
        // supplier.get().anyMatch(a->true);
        // supplier.get().noneMatch(a->true);


        // 构建一个 Person 集合
        List<Person> persons =
                Arrays.asList(
                        new Person("Max", 18),
                        new Person("Peter", 23),
                        new Person("Pamela", 23),
                        new Person("David", 12));

        List<Person> newPerson = persons.stream().filter(s -> s.name.startsWith("P")).collect(Collectors.toList());
        System.out.println(newPerson);

        persons.stream().collect(Collectors.groupingBy(a->a.age)).forEach((age,p)->System.out.format("a %s p %s\n",age,p));
        Double collect = persons.stream().collect(Collectors.averagingDouble(a -> a.age));
        System.out.println(collect);

        IntSummaryStatistics summing = persons.stream().collect(Collectors.summarizingInt(a -> a.age));
        System.out.println(summing);

        String summing1 = persons.stream().filter(a->a.age>20).map(a->a.name).collect(Collectors.joining(" and ","dd ","dd "));
        System.out.println(summing1);

    }
    static  class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return name;
        }
    }

}
