package com.ioanmariciuc.compulsory.student;

import com.ioanmariciuc.compulsory.school.School;

import java.util.*;

public class Student {
    private String name;
    private double score;

    private Map<Student, List<School>> prefs = new HashMap<>();

    public Student(String name) {
        this.name = name;
    }

    public Student(String name, List<School> preferences) {
        this.name = name;
        this.prefs.put(this, preferences);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Student, List<School>> getPrefs() {
        return prefs;
    }

    public void setPrefs(List<School> prefs) {
        this.prefs = new HashMap<>();
        this.prefs.put(this, prefs);
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return name;
    }
}