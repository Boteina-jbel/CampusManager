package org.mql.campusmanager.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mql.campusmanager.models.Course;
import org.mql.campusmanager.models.Department;
import org.mql.campusmanager.models.Professor;
import org.mql.campusmanager.services.DepartmentService;

@DisplayName("Senario de test pour la classe metier Department Service")
class DepartmentServiceTests {

	private DepartmentService service;
	private Department department;
	private Professor professor;
	private Course course;
	
	@BeforeEach
	void setUp() throws Exception {
		service = new DepartmentService();
		department = new Department("Departement Informatique");
		professor = new Professor("Boteina", "Boteina", "boteina@gmail.com", "BJ2323");
		course = new Course("DP01",  "Design Pattern", 2, 30);
	}

	@Test
	void testAssignProfessorToDepartmentSuccess() {
		//Arrange
		
		//Act
		boolean result = service.assignProfessorToDepartment(professor, department);
		//Assert
		assertTrue(result);
		assertTrue(department.getProfessors().contains(professor));
	}
	
	@Test
	void testAssignProfessorToDepartmentFailure() {
		//Arrange
		department.addProfessor(professor);
		//Act
		boolean result = service.assignProfessorToDepartment(professor, department);
		//Assert
		assertFalse(result);
	}
	
	@Test
	void testAddCourseToDepartmentSuccess() {
		//Arrange
		
		//Act
		boolean result = service.addCourseToDepartment(course, department);
		//Assert
		assertTrue(result);
		assertTrue(department.getCourses().contains(course));
	}
	
	@Test
	void testAddCourseToDepartmentFailure() {
		//Arrange
		department.addCourse(course);
		//Act
		boolean result = service.addCourseToDepartment(course, department);
		//Assert
		assertFalse(result);
	}

}
