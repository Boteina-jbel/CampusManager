package org.mql.campusmanager.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mql.campusmanager.models.Course;
import org.mql.campusmanager.models.Professor;
import org.mql.campusmanager.services.CourseService;

class CourseServiceTests {

	private CourseService service;
	private Course course;
	private Professor professor;
	
	@BeforeEach
	void setUp() throws Exception {
		service = new CourseService();
		professor = new Professor("Loqman", "Loqman", "loqman@gmail.com", "LJ2825");
		course = new Course("J201",  "Java", 2, 30, professor);
	}

	@Test
	void testassignCourseFailure() {
		//Arrange
		professor.addCourse(course);
		//Act
		boolean result = service.assignCourse(professor, course);
		//Assert
		assertFalse(result);
	}
	
	@Test
	void testassignCourseSuccess() {
		//Arrange
		
		//Act
		boolean result = service.assignCourse(professor, course);
		//Assert
		assertTrue(result);
	}
}
