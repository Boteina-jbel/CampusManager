package org.mql.campusmanager.services;

import java.util.List;
import java.util.Vector;

import org.mql.campusmanager.models.Course;
import org.mql.campusmanager.models.Department;
import org.mql.campusmanager.models.Professor;
import org.mql.campusmanager.repositories.DepartmentRepository;

public class DepartmentService {
	
	private DepartmentRepository repository;
	
	public DepartmentService() {
		repository = new DepartmentRepository();
	}
	
	public boolean addDepartment(Department department) {
		if(department == null) {
			return false;
		}
		
		if(repository.findByName(department.getName()) != null) {
			return false;
		}
		
		return repository.save(department);
	}
	
	public boolean removeDepartment(Department department) {
		if(department == null) {
			return false;
		}
		
		Department existingDepartment = repository.findByName(department.getName());
		
		if(existingDepartment == null) {
			return false;
		}
		
		return repository.delete(existingDepartment);
	}
	
	public Department findDepartmentByName(String name) {
		return repository.findByName(name);
	}
	
	public Vector<Department> listAllDepartments(){
		return repository.findAll();
	}
	
	public boolean assignProfessorToDepartment(Professor professor, Department department) {
	    if (professor == null || department == null) {
	        return false;
	    }

	    if(department.getProfessors().contains(professor)) {
	    	return false;
	    }
	    
	    department.addProfessor(professor);
	    return true;
	}
	
	public boolean addCourseToDepartment(Course course, Department department) {
		if (course == null || department == null) {
	        return false;
	    }

		if(department.getCourses().contains(course)) {
			return false;
		}
		
	    department.addCourse(course);
	    
	    return true;
	}
	
	public List<Professor> listDepartmentProfessors(Department department) {
	    return new Vector<>(department.getProfessors());
	}
	
	public List<Course> listDepartmentCourses(Department department){
		return new Vector<>(department.getCourses());
	}
}

