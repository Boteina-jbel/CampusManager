package org.mql.campusmanager.models;

import java.util.List;
import java.util.Vector;

public class Professor extends Person {
    private String matricule; // unique ID
    private List<Course> courses;

    public Professor(String firstName, String lastName, String email, String matricule) {
        super(firstName, lastName, email);
        this.matricule = matricule;
        this.courses = new Vector<>();
    }

    public String getMatricule() { return matricule; }
    public void setMatricule(String matricule) { this.matricule = matricule; }

    public List<Course> getCourses() { return courses; }
    public void addCourse(Course course) { courses.add(course); }
}
