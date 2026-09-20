package org.mql.campusmanager.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mql.campusmanager.models.Course;
import org.mql.campusmanager.models.Professor;
import org.mql.campusmanager.services.CourseService;

@DisplayName("Senario de test pour la classe metier Course Service")
class CourseServiceTests {

	private CourseService service;
	private Course course;
	private Professor professor;
	
	@BeforeEach
	void setUp() throws Exception {
		service = new CourseService();
		professor = new Professor("Loqman", "Loqman", "loqman@gmail.com", "LJ2825");
		course = new Course("J201",  "Java", 2, 30);
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
		// Assert
	    assertTrue(result);
	    assertEquals(professor, course.getProfessor());
	    assertTrue(professor.getCourses().contains(course));
	}
	
	@Test
	void testAssignCourseAlreadyAssignedToAnotherProfessor() {

	    Professor professor2 =
	            new Professor("Sara", "Amrani", "sara@gmail.com", "SA1234");

	    service.assignCourse(professor, course);

	    boolean result = service.assignCourse(professor2, course);

	    assertFalse(result);
	}
	
	@Test
	void testAssignCourseNull() {
	    assertFalse(service.assignCourse(null, course));
	    assertFalse(service.assignCourse(professor, null));
	}
} 
