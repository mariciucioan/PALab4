package com.ioanmariciuc.compulsory.school;

import com.ioanmariciuc.compulsory.student.Student;

import java.util.*;

public class School implements Comparable<School> {
    private String name;
    private int capacity;

    private Map<School, List<Student>> prefs = new TreeMap<>();
    private List<Student> studying = new LinkedList<>();

    public School(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public School(String name, int capacity, List<Student> preferences) {
        this.name = name;
        this.capacity = capacity;
        this.prefs.put(this, preferences);
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Map<School, List<Student>> getPrefs() {
        return prefs;
    }

    public void setPrefs(List<Student> prefs) {
        this.prefs = new TreeMap<>();
        this.prefs.put(this, prefs);
    }

    public List<Student> getStudying() {
        return studying;
    }

    public void setStudying(List<Student> studying) {
        this.studying = studying;
        this.capacity -= studying.size();
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
