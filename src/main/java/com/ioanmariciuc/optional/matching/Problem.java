package com.ioanmariciuc.optional.matching;

import com.github.javafaker.Faker;
import com.ioanmariciuc.compulsory.school.School;
import com.ioanmariciuc.compulsory.student.Student;

import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Problem {

    private final int MAX_STUDENTS;
    private final int MAX_SCHOOLS;
    private final int MAX_CAPACITY;
    private final double MAX_SCORE;

    private List<Student> students;
    private List<School> schools;

    public Problem() {
        MAX_STUDENTS = 10000;
        MAX_SCHOOLS = 15;
        MAX_CAPACITY = 1000;
        MAX_SCORE = 100.0;

        students = new LinkedList<>();
        schools = new LinkedList<>();
    }

    public Problem(List<Student> students, List<School> schools) {
        MAX_STUDENTS = 10000;
        MAX_SCHOOLS = 15;
        MAX_CAPACITY = 1000;
        MAX_SCORE = 100.0;

        this.students = students;
        this.schools = schools;
    }

    public Problem(int MAX_STUDENTS, int MAX_SCHOOLS, int MAX_CAPACITY, double MAX_SCORE) {
        this.MAX_STUDENTS = MAX_STUDENTS;
        this.MAX_SCHOOLS = MAX_SCHOOLS;
        this.MAX_CAPACITY = MAX_CAPACITY;
        this.MAX_SCORE = MAX_SCORE;

        students = new LinkedList<>();
        schools = new LinkedList<>();
    }

    public Problem(int MAX_STUDENTS, int MAX_SCHOOLS, int MAX_CAPACITY, double MAX_SCORE, List<Student> students, List<School> schools) {
        this.MAX_STUDENTS = MAX_STUDENTS;
        this.MAX_SCHOOLS = MAX_SCHOOLS;
        this.MAX_CAPACITY = MAX_CAPACITY;
        this.MAX_SCORE = MAX_SCORE;

        this.students = students;
        this.schools = schools;
    }

    public void generateRandomProblem() {
        DecimalFormat df2 = new DecimalFormat("#.##");

        StringBuilder sb = new StringBuilder();
        students = new LinkedList<>();
        schools = new LinkedList<>();

        int studentRand = (int) (Math.random() * MAX_STUDENTS);
        int schoolRand = (int) (Math.random() * MAX_SCHOOLS);
        int capacity = 0;

        Faker faker = new Faker();

        sb.append("Generating ").append(schoolRand).append(" schools...\n");

        for(int i=0; i<schoolRand; i++) {
            String name = faker.university().name();
            int randCapacity = (int) (Math.random()*MAX_CAPACITY);
            capacity += randCapacity;
            schools.add(new School(name, randCapacity));
            sb.append(name).append(" (capacity: ").append(randCapacity).append(")\n");
        }

        sb.append("\nDone.\n\n");

        sb.append("Generating ").append(studentRand).append(" students...\n\n");

        if(studentRand < capacity/2 || studentRand > capacity) {
            generateRandomProblem();
            return;
        }

        for(int i=0; i<studentRand; i++) {
            String name = faker.name().fullName();
            double randomScore = Math.random()*MAX_SCORE;

            Student stud = new Student(name);
            stud.setScore(randomScore);

            List<School> pref = schools.stream()
                    .filter(e -> faker.bool().bool())
                    .distinct()
                    .collect(Collectors.toList());

            stud.setPrefs(pref);
            students.add(stud);
            sb.append(name).append(" (").append(df2.format(randomScore)).append("/").append(MAX_SCORE)
            .append(") prefers ").append(pref.size()).append(" schools: (");
            pref.forEach(scl -> sb.append(scl.getName()).append("; "));
            sb.append(")\n");
        }

        sb.append("\nDone.\n\n\n");

        sb.append("Total schools: ").append(schoolRand);
        sb.append("\nTotal capacity: ").append(capacity);
        sb.append("\nTotal students: ").append(studentRand);

        System.out.println(sb.toString());
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<School> getSchools() {
        return schools;
    }

    public void setSchools(List<School> schools) {
        this.schools = schools;
    }
}
