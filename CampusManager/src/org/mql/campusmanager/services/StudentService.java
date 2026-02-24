package org.mql.campusmanager.services;

import java.util.Vector;

import org.mql.campusmanager.models.Student;

public class StudentService {
	
	private Vector<Student> students;

    public StudentService() {
        students = new Vector<>();
    }
    
    public void addStudent(Student student) {
        for (Student s : students) {
            if (s.getCNE().equals(student.getCNE())) {
                System.out.println("Student with this CNE already exists.");
                return;
            }
        }
        students.add(student);
        System.out.println("Student added successfully.");
    }
	
}
