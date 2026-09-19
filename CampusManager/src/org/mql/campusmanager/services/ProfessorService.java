package org.mql.campusmanager.services;

import java.util.Vector;

import org.mql.campusmanager.models.Professor;
import org.mql.campusmanager.repositories.ProfessorRepository;

public class ProfessorService {

	private ProfessorRepository repository;
	
	public ProfessorService() {
		repository = new ProfessorRepository();
	}
	
	public boolean addProfessor(Professor professor) {
		if(professor == null) {
			return false;
		}
		
		if(repository.findByMatricule(professor.getMatricule()) != null) {
			return false;
		}
		
		return repository.save(professor);
	}
	
	public boolean removeProfessor(Professor professor) {
		if(professor == null) {
			return false;
		}
		
		Professor existingProfessor = repository.findByMatricule(professor.getMatricule());
		
		if(existingProfessor == null) {
			return false;
		}
		return repository.delete(existingProfessor);
	}
	
	public Professor findProfessorByMatricule(String matricule) {
		return repository.findByMatricule(matricule);
	}
	
	public Vector<Professor> listAllProfessors(){
		return repository.findAll();
	} 
	
}





//
//private Vector<Professor> professors;
//
//public ProfessorService() {
//	professors = new Vector<>();
//}
//
//public boolean addProfessor(Professor professor) {
//	for(Professor p : professors) {
//		if(p.getMatricule().equals(professor.getMatricule())) {
//			return false;
//		}
//	}
//	professors.add(professor);
//	return true;
//}
//
//public boolean removeProfessor(Professor professor) {
//	for(int i = 0; i<professors.size(); i++) {
//		if(professors.get(i).getMatricule().equals(professor.getMatricule())) {
//			professors.remove(i);
//            return true;
//		}
//	}
//	return false;
//}
//
//public Professor findProfessorByMatricule(String matricule) {
//	for(Professor p : professors) {
//		if(p.getMatricule().equals(matricule)) {
//			return p;
//		}
//	}
//	return null;
//}
//
//public Vector<Professor> listAllProfessors(){
//	//return professors;
//	return new Vector<>(professors);
//} 
