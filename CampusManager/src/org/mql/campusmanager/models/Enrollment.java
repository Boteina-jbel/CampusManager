package org.mql.campusmanager.models;

public class Enrollment {
    private Student student;
    private Course course;
    private Double grade; // nullable, can be assigned later

    public Enrollment(Student student, Course course) {
        this.student = student;
        this.course = course;
        this.grade = null;
    }

    public Student getStudent() { return student; }
    public Course getCourse() { return course; }
    public Double getGrade() { return grade; }
    public void setGrade(Double grade) { this.grade = grade; }
}
