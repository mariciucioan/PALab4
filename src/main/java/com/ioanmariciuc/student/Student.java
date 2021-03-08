package com.ioanmariciuc.student;

import com.ioanmariciuc.school.School;

import java.util.LinkedList;
import java.util.List;

public class Student {
    private String name;
    private List<School> preferences = new LinkedList<>();

    public Student(String name) {
        this.name = name;
    }

    public Student(String name, List<School> preferences) {
        this.name = name;
        this.preferences = preferences;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<School> getPreferences() {
        return preferences;
    }

    public void setPreferences(List<School> preferences) {
        this.preferences = preferences;
    }

    @Override
    public String toString() {
        return name;
    }
}