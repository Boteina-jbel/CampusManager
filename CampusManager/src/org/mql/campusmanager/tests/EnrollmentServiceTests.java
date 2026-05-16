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
		course = new Course("JS123", "JavaScript", 2, 30, professor);
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

}
