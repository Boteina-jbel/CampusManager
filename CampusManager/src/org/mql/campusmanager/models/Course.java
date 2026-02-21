package org.mql.campusmanager.models;

import java.util.List;
import java.util.Vector;

public class Course {
	
    private String name;
    private int credits;
    private int capacity;
    private Professor professor;
    private List<Enrollment> enrollments;

    public Course(String name, int credits, int capacity, Professor professor) {
        this.name = name;
        this.credits = credits;
        this.capacity = capacity;
        this.professor = professor;
        this.enrollments = new Vector<>();
    }

    public String getName() { return name; }
    public int getCredits() { return credits; }
    public int getCapacity() { return capacity; }
    public Professor getProfessor() { return professor; }
    
    public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public List<Enrollment> getEnrollments() { return enrollments; }

    public void addEnrollment(Enrollment enrollment) { enrollments.add(enrollment); }

    public boolean isFull() { return enrollments.size() >= capacity; }
}
