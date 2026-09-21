package org.mql.campusmanager.repositories;

import java.util.Vector;

import org.mql.campusmanager.models.Department;


public class DepartmentRepository {

	private Vector<Department> departments;
	
	public DepartmentRepository() {
		departments = new Vector<>();
	}
	
	public boolean save(Department department) {
		return departments.add(department);
	}
	
	public boolean delete(Department department) {
		return departments.remove(department);
	}
	
	public Department findByName(String name) {
		for(Department department : departments) {
			if(department.getName().equals(name)) {
				return department;
			}
		}
		return null;
	}
	
	public Vector<Department> findAll(){
		return new Vector<>(departments);
	}
}
