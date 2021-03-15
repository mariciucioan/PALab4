package com.ioanmariciuc.optional.matching;

import com.ioanmariciuc.compulsory.school.School;
import com.ioanmariciuc.compulsory.student.Student;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    Problem problem;

    public Solution(Problem problem) {
        this.problem = problem;
    }

    public Problem getProblem() {
        return problem;
    }

    public void setProblem(Problem problem) {
        this.problem = problem;
    }

    public void solve() {
        var schools = problem.getSchools();
        var students = problem.getStudents();

        schools.forEach(scl -> {
            if(scl.getCapacity() == 0)
                return;

            System.out.println(scl.getName() + ": ");

            List<Student> potentialStudents = new LinkedList<>();
            var schoolPrefs = scl.getPrefs();
            students.forEach(std -> {
                var studPrefs = std.getPrefs();
                if(studPrefs.get(std).contains(scl) && schoolPrefs.get(scl).contains(std))
                    potentialStudents.add(std);
            });

            List<Student> willStudy = potentialStudents.stream()
                    .sorted((s1, s2) -> Double.compare(s1.getScore(), s2.getScore()))
                    .limit(scl.getCapacity())
                    .collect(Collectors.toList());

            scl.setStudying(willStudy);
            System.out.println(willStudy);
        });
    }

    public List<Student> studentsFindsSchoolsAcceptable(List<Student> students, List<School> school) {
        return students.stream()
                .filter(std -> std.getPrefs().get(std).containsAll(school))
                .collect(Collectors.toList());
    }

    public List<School> schoolsFindStudentsAcceptable(List<School> schools, List<Student> student) {
        return schools.stream()
                .filter(scl -> scl.getPrefs().get(scl).containsAll(student))
                .collect(Collectors.toList());
    }
}
