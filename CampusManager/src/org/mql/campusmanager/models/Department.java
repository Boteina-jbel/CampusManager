package org.mql.campusmanager.models;

import java.util.List;
import java.util.Vector;

public class Department {
    private String name;
    private List<Student> students;
    private List<Professor> professors;
    private List<Course> courses;

    public Department(String name) {
        this.name = name;
        this.students = new Vector<>();
        this.professors = new Vector<>();
        this.courses = new Vector<>();
    }

    public String getName() { return name; }
    public List<Student> getStudents() { return students; }
    public List<Professor> getProfessors() { return professors; }
    public List<Course> getCourses() { return courses; }

    public void addStudent(Student student) { students.add(student); }
    public void addProfessor(Professor professor) { professors.add(professor); }
    public void addCourse(Course course) { courses.add(course); }
}
