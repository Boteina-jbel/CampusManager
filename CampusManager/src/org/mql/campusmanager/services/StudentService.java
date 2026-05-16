package org.mql.campusmanager.services;

import java.util.Vector;

import org.mql.campusmanager.models.Student;
import org.mql.campusmanager.repositories.StudentRepository;

public class StudentService {
	
	private StudentRepository repository;

    public StudentService() {
    	repository = new StudentRepository();
    }
    
    public boolean addStudent(Student student) {
    	 if (student == null) {
             return false;
         }

         if (repository.findByCNE(student.getCNE()) != null) {
             return false;
         }

         return repository.save(student);
    }
    

    public boolean removeStudent(Student student) {

    	if (student == null) {
            return false;
        }

        Student existingStudent = repository.findByCNE(student.getCNE());

        if (existingStudent == null) {
            return false;
        }

        return repository.delete(existingStudent);
    }
    
    public Student findStudentByCNE(String cne) {
        return repository.findByCNE(cne);
    }

    public Vector<Student> listAllStudents() {
        return repository.findAll();
    }
    
    
//  public boolean addStudent(Student student) {
//  for (Student s : students) {
//      if (s.getCNE().equals(student.getCNE())) {
//          return false;
//      }
//  }
//  students.add(student);
//  return true;
//}
    
//  public boolean removeStudent(Student student) {
//
//  	if (student == null) {
//          return false;
//      }
//  	
//      for (int i = 0; i < students.size(); i++) {
//
//          if (students.get(i).getCNE().equals(student.getCNE())) {
//              students.remove(i);
//              return true;
//          }
//      }
//      return false;
//  }
    
//    public Student findStudentByCNE(String cne) {
//    	for(Student student : students) {
//    		if(student.getCNE().equals(cne)) {
//    			return student;
//    		}
//    	}
//    	return null;
//    }
//    
//    public Vector<Student> listAllStudents() {
//    	//return students; // Do not return the original list to avoid exposing internal data.
//        return new Vector<>(students); // safe copy
//    }
     
}
