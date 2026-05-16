package org.mql.campusmanager.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Vector;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mql.campusmanager.models.Student;
import org.mql.campusmanager.services.StudentService;

@DisplayName("Senario de test pour la classe metier Student Service")
class StudentServiceTests {
	private StudentService service;
	private Student student;

	@BeforeEach
	void setUp() throws Exception {
		service = new StudentService();
		student = new Student("Boteina", "JBEL", "boteinajbel@gmail.com", "K111111111");
		service.addStudent(student);
	}

	@Test
	void testAddStudentSuccess() {
		// Arrange
	    Student newStudent = new Student(
	        "Sara",
	        "Ali",
	        "sara@gmail.com",
	        "K222222222"
	    );
	    // Act
	    boolean result = service.addStudent(newStudent);
	    
	    // Assert
	    assertTrue(result);
	    assertEquals(2, service.listAllStudents().size());
	}
	
	@Test
	void testAddStudentFailure() {
		//Arrange
		service.addStudent(student);
		//Act
		boolean result = service.addStudent(student);
		//Assert
		assertFalse(result);
	}
	
	@Test
	void testAddStudentNotFound() {
		//Arrange
		Student student = null;
		//Act
		boolean result = service.addStudent(student);
		//Assert
		assertFalse(result);
	}
	
	@Test
	void testFindStudentByCNESuccess() {
		//Arrange
		
		//Act
		Student found = service.findStudentByCNE("K111111111");
		//Assert
		assertNotNull(found);
		assertEquals(student.getCNE(), found.getCNE());
	}
	
	@Test
	void testFindStudentByCNEFailure() {
		//Arrange
		
		//Act
		Student found = service.findStudentByCNE("K222222222");
		//Assert
		assertNull(found);
	}

	@Test
	void testRemoveStudentSuccess() {
		//Arrange
		Student newStudent = new Student(
		        "Sara",
		        "Ali",
		        "sara@gmail.com",
		        "K222222222"
		    );
		service.addStudent(newStudent);
		//Act
		service.removeStudent(student);
		//Assert
		assertEquals(1, service.listAllStudents().size());
	}
	
	@Test
	void testRemoveStudentNotFound() {
		//Arrange
		Student student = null;
		//Act
		boolean result = service.removeStudent(student);
		//Assert
		assertFalse(result);
	}
	
	@Test
	void testRemoveStudentFailure() {
		//Arrange
		Student newStudent = new Student(
		        "Sara",
		        "Ali",
		        "sara@gmail.com",
		        "K222222222"
		    );
		//Act
		boolean result = service.removeStudent(newStudent);
		//Assert
		assertFalse(result);
	}
	
	@Test
	void testlistAllStudent() {
		//Arrange
		 Student newStudent = new Student(
			        "Sara",
			        "Ali",
			        "sara@gmail.com",
			        "K222222222"
			    );

		 service.addStudent(newStudent);
			    
		//Act
		Vector<Student> students = service.listAllStudents();
		//Assert
		assertNotNull(service);
		assertEquals(2, students.size());
	}
}
