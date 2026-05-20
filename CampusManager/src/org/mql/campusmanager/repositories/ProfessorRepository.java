package org.mql.campusmanager.repositories;

import java.util.Vector;

import org.mql.campusmanager.models.Professor;

public class ProfessorRepository {

	private Vector<Professor> professors;

    public ProfessorRepository() {
        professors = new Vector<>();
    }
    
    public boolean save(Professor professor) {
    	return professors.add(professor);
    }
    
    public boolean delete(Professor professor) {
    	return professors.remove(professor);
    }
}
