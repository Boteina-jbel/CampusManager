package org.mql.campusmanager.tests;

import static org.junit.jupiter.api.Assertions.*;

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
	void test() {
		fail("Not yet implemented");
	}

}
