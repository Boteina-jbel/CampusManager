package org.mql.campusmanager.services;

import java.util.Vector;

import org.mql.campusmanager.models.Professor;

public class ProfessorService {

	private Vector<Professor> professors;
	
	public ProfessorService() {
		professors = new Vector<>();
	}
	
	public void addProfessor(Professor professor) {
		for(Professor p : professors) {
			if(p.getMatricule().equals(professor.getMatricule())) {
				System.out.println("Professor " + professor.getFullName() + "already exists");
				return;
			}
		}
		professors.add(professor);
		System.out.println("Professor added successfully.");
	}
	
	public void removeProfessor(Professor professor) {
		for(int i = 0; i<professors.size(); i++) {
			if(professors.get(i).getMatricule().equals(professor.getMatricule())) {
				professors.remove(i);
				System.out.println("Professor removed successfully.");
                return;
			}
		}
		System.out.println("Professor not found.");
	}
	
	
	
}
