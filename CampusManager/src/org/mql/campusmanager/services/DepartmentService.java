package org.mql.campusmanager.services;

import java.util.Vector;

import org.mql.campusmanager.models.Course;
import org.mql.campusmanager.models.Department;
import org.mql.campusmanager.models.Professor;

public class DepartmentService {
	
	private Vector<Department> departments;
	
	public DepartmentService() {
		departments = new Vector<>();
	}
	
	public boolean addDepartment(Department department) {
		for(Department d : departments) {
			if(d.getName().equals(department.getName())) {
				return false;
			}
		}
		departments.add(department);
		return true;
	}
	
	public boolean removeDepartment(String name) {
		for(int i = 0; i < departments.size(); i++) {
			if(departments.get(i).getName().equals(name)) {
				departments.remove(i);
                return true;
			}
		}
		return false;
	}
	
	public Department findDepartmentByName(String name) {
		for(Department d : departments) {
			if(d.getName().equals(name)) {
				return d;
			}
		}
		return null;
	}
	
	public Vector<Department> listAllDepartments(){
		return new Vector<>(departments);
	}
	
	public boolean assignProfessorToDepartment(Professor professor, Department department) {
	    if (professor == null || department == null) {
	        return false;
	    }
	    for (Professor p : department.getProfessors()) {
	        if (p.getMatricule().equals(professor.getMatricule())) {
	            return false; // already assigned
	        }
	    }
	    department.addProfessor(professor);
	    return true;
	}
	
	public void addCourseToDepartment(Course course, Department department) {
		
	}
	
	public Vector<Professor> listDepartmentProfessors(Department department){
		return null;
		
	}
	
	public Vector<Course> listDepartmentCourses(Department department){
		return null;
		
	}
}
