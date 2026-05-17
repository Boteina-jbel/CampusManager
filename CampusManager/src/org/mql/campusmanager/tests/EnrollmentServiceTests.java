package org.mql.campusmanager.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Vector;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mql.campusmanager.models.Course;
import org.mql.campusmanager.models.Enrollment;
import org.mql.campusmanager.models.Professor;
import org.mql.campusmanager.models.Student;
import org.mql.campusmanager.services.EnrollmentService;

@DisplayName("Senario de test pour la classe metier Enrollment Service")
class EnrollmentServiceTests {
	private EnrollmentService service;
	private Student student;
	private Course course;
	private Professor professor;
	private Enrollment enrollment;

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
	
	@Test
	void testAssignGradeSuccess() {
		//Arrange
	    Course javaCourse = new Course("J101","Java", 2, 10, professor);
	    service.enrollStudent(student, javaCourse);
		service.enrollStudent(student, course);
		//Act
		boolean result = service.assignGrade(student, course, 15);
		//Assert
		assertTrue(result);
	}
	
	@Test
	void testAssignGradeFailure() {
		//Arrange
		
		//Act
		boolean result = service.assignGrade(student, course, 17);
		//Assert
		assertFalse(result);
	}
	
	@Test
	void testCalculateAverageSuccess() {
		//Arrange
		Course javaCourse = new Course("J101","Java", 2, 10, professor);
	    service.enrollStudent(student, javaCourse);
		service.enrollStudent(student, course);
		service.assignGrade(student, javaCourse, 15);
		service.assignGrade(student, course, 17);
		//Act
		double result = service.calculateAverage(student);
		//Assert
		assertEquals(16.00, result);
	}
	
	@Test
	void testCalculateAverageNoGradesYet() {
		//Arrange
		service.enrollStudent(student, course);
		//Act
		double result = service.calculateAverage(student);
		//Assert
		assertEquals(0.0, result);
		
	}
	
	@Test
	void testIsAdmitedSuccess() {
		//Arrange
		Course javaCourse = new Course("J101","Java", 2, 10, professor);
	    service.enrollStudent(student, javaCourse);
		service.enrollStudent(student, course);
		service.assignGrade(student, javaCourse, 18);
		service.assignGrade(student, course, 19);
		//Act
		boolean result = service.isAdmitted(student);
		//Assert
		assertTrue(result);
		
	}
	
	@Test
	void testIsAdmitedFailure() {
		//Arrange
		Course javaCourse = new Course("J101","Java", 2, 10, professor);
	    service.enrollStudent(student, javaCourse);
		service.enrollStudent(student, course);
		service.assignGrade(student, javaCourse, 9);
		service.assignGrade(student, course, 8);
		//Act
		boolean result = service.isAdmitted(student);
		//Assert
		assertFalse(result);
	}
	
	@Test
	void testListStudentCoursesSuccess() {
		//Arrange
		Course javaCourse = new Course("J101","Java", 2, 10, professor);
	    service.enrollStudent(student, javaCourse);
		service.enrollStudent(student, course);
		//Act
		Vector<Course> result = service.listStudentCourses(student);
		//Assert
		assertNotNull(result);
		assertEquals(2, result.size());
	    assertTrue(result.contains(javaCourse));
	    assertTrue(result.contains(course));
	}
	
	@Test
	void testListStudentCourseFailure() {
		//Arrange
		Student student = null;
		//Act
		Vector<Course> result = service.listStudentCourses(student);
		//Assert
		assertNotNull(result);
	    assertTrue(result.isEmpty());
	}
	
	@Test
	void testListCourseStudentsSuccess() {
		//Arrange
		Course course = new Course("JS123", "JavaScript", 2, 10, professor);
		Student student2 = new Student("Salma", "Salma", "salma@gmail.com", "K222222222");
		service.enrollStudent(student2, course);
		service.enrollStudent(student, course);
		//Act
		Vector<Student> result = service.listCourseStudents(course);
		//Assert
		assertNotNull(result);
		assertEquals(2, result.size());
		assertTrue(result.contains(student));
		assertTrue(result.contains(student2));
	}
	
	@Test
	void testListCourseStudentFailure() {
		//Arrange
		
		//Act
		Vector<Student> result = service.listCourseStudents(course);
		//Assert
		assertNotNull(result);
		assertEquals(0, result.size());
	}
}
