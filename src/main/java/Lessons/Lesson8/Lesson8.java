package Lessons.Lesson8;

import Lessons.Lesson8.HW8.Employee;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Lesson8 {
    public static void main(String[] args) {
        String[] arr = {"A", "B", "C", "D", "E", "F", "F", "A", "B", "D"};
        String result = Arrays.stream(arr).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream().max(Comparator.comparingLong(Map.Entry::getValue)).get().getKey();
        System.out.println(result);

        Employee[] employees = {
                new Employee("Bob", 20, 2000),
                new Employee("Max", 21, 5000),
                new Employee("Anna", 27, 6000),
                new Employee("Valery", 23, 5500),
                new Employee("Alex", 23, 5100),
                new Employee("Sergey", 30, 8000),
                new Employee("Valencia", 42, 15000)
        };
        Arrays.stream(employees).mapToInt(Employee::getSalary).average().stream().forEach(System.out::println);
        seniorEmployee(employees);

    }

    private static void seniorEmployee(Employee[] employees) {
        Arrays.stream(employees).sorted((o1, o2) -> o2.getAge() - o1.getAge()).map(Employee::getName).forEach(System.out::println);
    }
}
