package org.mql.campusmanager.models;

import java.util.List;
import java.util.Vector;

public class Student extends Person {
    private String CNE;  // unique ID
    private List<Enrollment> enrollments;

    public Student(String firstName, String lastName, String email, String CNE) {
        super(firstName, lastName, email);
        this.CNE = CNE;
        this.enrollments = new Vector<>();
    }

    public String getCne() { 
    	return CNE; 
    }
    
    public void setCne(String CNE) { 
    	this.CNE = CNE; 
    }

    public List<Enrollment> getEnrollments() { 
    	return enrollments; 
    }
    
    public void addEnrollment(Enrollment enrollment) { 
    	enrollments.add(enrollment); 
    }
}
