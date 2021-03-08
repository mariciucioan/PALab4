package com.ioanmariciuc.school;

import com.ioanmariciuc.student.Student;

import java.util.List;

public class School implements Comparable<School> {
    private String name;
    private int capacity;

    private List<Student> preferences;

    public School(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public School(String name, int capacity, List<Student> preferences) {
        this.name = name;
        this.capacity = capacity;
        this.preferences = preferences;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getPreferences() {
        return preferences;
    }

    public void setPreferences(List<Student> preferences) {
        this.preferences = preferences;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(School o) {
        return this.toString().compareTo(o.toString());
    }
}
