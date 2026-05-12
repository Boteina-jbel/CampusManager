package org.mql.campusmanager.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mql.campusmanager.models.Professor;
import org.mql.campusmanager.services.ProfessorService;

@DisplayName("Senario de test pour la classe metier Professor Service")
class ProfessorServiceTests {
	
	private ProfessorService service;
	private Professor professor;

	@BeforeEach
	void setUp() throws Exception {
		service = new ProfessorService();
		professor = new Professor("Loqman", "Loqman", "loqman@gmail.com", "LJ2825");
		service.addProfessor(professor);
	}

	@Test
	void testAddProfessorSuccess() {
		//Arrange
		Professor newprofessor = new Professor("Kamal", "Kamal", "kamal@gmail.com", "KF2378");
		//Act
		service.addProfessor(newprofessor);
		//Assert
		assertEquals(2, service.listAllProfessors().size());
	}
	
	@Test
	void testRemoveProfessorSuccess() {
		//Arrange
		
		//Act
		
		//Assert
	}

}
