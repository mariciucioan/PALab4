package com.ioanmariciuc.compulsory;

import com.github.javafaker.Faker;
import com.ioanmariciuc.compulsory.school.School;
import com.ioanmariciuc.compulsory.student.Student;
import com.ioanmariciuc.optional.matching.Problem;
import com.ioanmariciuc.optional.matching.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String [] args) {
        var students = IntStream.rangeClosed(0,3)
                .mapToObj(i -> new Student("S" + i))
                .collect(Collectors.toList());

        var schools = IntStream.rangeClosed(0,2)
                .mapToObj(i -> new School("H" + i, i==0 ? 1:2))
                .collect(Collectors.toSet());

        students.get(0).setPrefs(new ArrayList<>(schools));
        students.get(1).setPrefs(new ArrayList<>(schools));
        students.get(2).setPrefs
                (schools.stream().filter(e -> !e.getName().equals("H2")).collect(Collectors.toList()));
        students.get(3).setPrefs
            (schools.stream().filter(e -> !e.getName().equals("H1")).collect(Collectors.toList()));
        
        schools.forEach(scl -> {
            Faker fake = new Faker();
            var studs = students.stream().filter(e -> fake.bool().bool()).collect(Collectors.toList());
            scl.setPrefs(studs);
        });

        System.out.println("Studenti: ");

        students.stream()
                .sorted((o1, o2) -> o1.toString().compareTo(o2.toString()))
                .forEach(System.out::println);

        System.out.println("Scoli: ");

        schools.stream()
                .sorted((o1, o2) -> o1.toString().compareTo(o2.toString()))
                .forEach((System.out::println));

        System.out.println();
        System.out.println();

        students.forEach(std -> {
            System.out.println(std.getName() + ": ");
            std.getPrefs().forEach((k, v) -> System.out.print(v.toString() + " "));
            System.out.println();
        });

        System.out.println();
        System.out.println();

        schools.forEach(scl -> {
            System.out.println(scl.getName() + ": ");
            scl.getPrefs().forEach((k, v) -> System.out.print(v.toString() + " "));
            System.out.println();
        });

        System.out.println();
        System.out.println();

        Problem problem = new Problem(students, new ArrayList<>(schools));
        Solution solution = new Solution(problem);
        solution.solve();
    }
}
