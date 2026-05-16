package org.mql.campusmanager.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mql.campusmanager.models.Course;
import org.mql.campusmanager.models.Professor;
import org.mql.campusmanager.models.Student;
import org.mql.campusmanager.services.EnrollmentService;

@DisplayName("Senario de test pour la classe metier Enrollment Service")
class EnrollmentServiceTests {
	private EnrollmentService service;
	private Student student;
	private Course course;
	private Professor professor;

	@BeforeEach
	void setUp() throws Exception {
		service = new EnrollmentService();
		student = new Student("Boteina", "JBEL", "boteinajbel@gmail.com", "K111111111");
		professor = new Professor("Loqman", "Loqman", "loqman@gmail.com", "LJ2825");
		course = new Course("JS123", "JavaScript", 2, 1, professor);
	}

	@Test
	void testEnrollStudentAlreadyEnrolled() {
		//Arrange
		service.enrollStudent(student, course);
		//Act
		boolean result = service.enrollStudent(student, course);
		//Assert
		assertFalse(result);
	}

	@Test
	void testEnrollStudentCourseIsFull() {
		//Arrange
		Student student2 = new Student("Salma", "Salma", "salma@gmail.com", "K222222222");
		service.enrollStudent(student, course);
		//Act
		boolean result = service.enrollStudent(student2, course);
		//Assert
		assertFalse(result);
	}
	
	@Test
	void testEnrollStudentSuccess() {
		//Arrange
		
		//Act
		boolean result = service.enrollStudent(student, course);
		//Assert
		assertTrue(result);
	}
	
	@Test
	void testEnrollStudentWithDifferentCourse() {
	    // Arrange
	    Course javaCourse = new Course("J101","Java", 2, 10, professor);
	    Course jsCourse = new Course("JS123", "JavaScript", 2, 10, professor);

	    // Student enrolled in Java
	    service.enrollStudent(student, javaCourse);

	    // Act
	    boolean result = service.enrollStudent(student, jsCourse);

	    // Assert
	    assertTrue(result);
	}
}
