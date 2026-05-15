package org.mql.campusmanager.tests;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Vector;

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
		boolean result = service.addProfessor(newprofessor);
		//Assert
		assertTrue(result);
		assertEquals(2, service.listAllProfessors().size());
	}
	
	@Test
	void testAddProfessorFailure() {
		//Arrange
		service.addProfessor(professor);
		//Act
		boolean result = service.addProfessor(professor);
		//Assert
		assertFalse(result);
	}
	
	@Test
	void testRemoveProfessorSuccess() {
		//Arrange
		Professor newprofessor = new Professor("Kamal", "Kamal", "kamal@gmail.com", "KF2378");
		service.addProfessor(newprofessor);
		//Act
		service.removeProfessor(newprofessor);
		//Assert
		assertEquals(1, service.listAllProfessors().size());
	}
	
	@Test
	void testRemoveProfessorFailure() {
		//Arrange
		Professor newprofessor = new Professor("Kamal", "Kamal", "kamal@gmail.com", "KF2378");
		//Act
		boolean result = service.removeProfessor(newprofessor);
		//Assert
		assertFalse(result);
	}
	
	@Test
	void testFindProfessorByMatriculeSuccess() {
		//Arrange
		
		//Act
		Professor found = service.findProfessorByMatricule("LJ2825");
		
		//Assert
		assertNotNull(found);
		assertEquals(professor.getMatricule(), found.getMatricule());
	}
	
	@Test
	void testFindProfessorByMatriculeFailure() {
		//Arrange
		
		//Act
		Professor found = service.findProfessorByMatricule("AB1234");
		//Assert
		assertNull(found);
	}
	
	@Test
	void testListAllProfessors() {
		//Arrange
		Professor newprofessor = new Professor("Kamal", "Kamal", "kamal@gmail.com", "KF2378");
		service.addProfessor(newprofessor);
		//Act
		Vector<Professor> professors = service.listAllProfessors();
		//Assert
		assertNotNull(professors);
		assertEquals(2, professors.size());
	}

}
