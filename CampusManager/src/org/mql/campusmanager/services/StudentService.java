package org.mql.campusmanager.services;

import java.util.Vector;

import org.mql.campusmanager.models.Student;

public class StudentService {
	
	private Vector<Student> students;

    public StudentService() {
        students = new Vector<>();
    }
    
    public boolean addStudent(Student student) {
        for (Student s : students) {
            if (s.getCNE().equals(student.getCNE())) {
                return false;
            }
        }
        students.add(student);
        return true;
    }
	
    public boolean removeStudent(Student student) {

    	if (student == null) {
            return false;
        }
    	
        for (int i = 0; i < students.size(); i++) {

            if (students.get(i).getCNE().equals(student.getCNE())) {
                students.remove(i);
                return true;
            }
        }
        return false;
    }
    
    public Student findStudentByCNE(String cne) {
    	for(Student student : students) {
    		if(student.getCNE().equals(cne)) {
    			return student;
    		}
    	}
    	return null;
    }
    
    public Vector<Student> listAllStudents() {
    	//return students; // Do not return the original list to avoid exposing internal data.
        return new Vector<>(students); // safe copy
    }
}
