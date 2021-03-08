package com.ioanmariciuc;

import com.ioanmariciuc.school.School;
import com.ioanmariciuc.student.Student;

import java.util.*;

public class Main {
    public static void main(String [] args) {
        School h0 = new School("H0", 1);
        School h1 = new School("H1", 2);
        School h2 = new School("H2", 2);

        Student s0 = new Student("S0");
        Student s1 = new Student("S1");
        Student s2 = new Student("S2");
        Student s3 = new Student("S3");

        s0.setPreferences(Arrays.asList(h0, h1, h2));
        s1.setPreferences(Arrays.asList(h0, h1, h2));
        s2.setPreferences(Arrays.asList(h0, h1));
        s3.setPreferences(Arrays.asList(h0, h2));

        h0.setPreferences(Arrays.asList(s3, s0, s1, s2));
        h1.setPreferences(Arrays.asList(s0, s2, s1));
        h2.setPreferences(Arrays.asList(s0, s1, s3));

        Set<School> schools = new TreeSet<>(Arrays.asList(h0, h1, h2));
        List<Student> students = new LinkedList<>(Arrays.asList(s0, s1, s2, s3));

        students.stream()
                .sorted((o1, o2) -> o1.toString().compareTo(o2.toString()))
                .forEach(System.out::println);


    }
}
