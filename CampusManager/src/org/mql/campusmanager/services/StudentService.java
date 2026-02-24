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
	
    public void removeStudent(Student student) {

        for (int i = 0; i < students.size(); i++) {

            if (students.get(i).getCNE().equals(student.getCNE())) {
                students.remove(i);
                System.out.println("Student removed successfully.");
                return;
            }
        }
        System.out.println("Student not found.");
    }
    
    public Student findStudentByCNE(String cne) {
    	for(Student student : students) {
    		if(student.getCNE().equals(cne)) {
    			return student;
    		}
    	}
    	return null;
    }
    
    public Vector<Student> listAllStudents(){
		return students;
    }
}
