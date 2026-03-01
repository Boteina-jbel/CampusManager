package org.mql.campusmanager.services;

import java.util.Vector;

import org.mql.campusmanager.models.Department;

public class DepartmentService {
	
	private Vector<Department> departments;
	
	public DepartmentService() {
		departments = new Vector<>();
	}
	
	public void addDepartment(Department department) {
		for(Department d : departments) {
			if(d.getName().equals(department.getName())) {
				System.out.println("Department " + department.getName() + "already exists");
				return;
			}
		}
		departments.add(department);
		System.out.println("Department added successfully.");
	}
	
	public void removeDepartment(String name) {
		for(int i = 0; i < departments.size(); i++) {
			if(departments.get(i).getName().equals(name)) {
				departments.remove(i);
				System.out.println("Department removed successfully.");
                return;
			}
		}
		System.out.println("Department not found.");
	}
	
	public Department findDepartmentByName(String name) {
		for(Department d : departments) {
			if(d.getName().equals(name)) {
				return d;
			}
		}
		return null;
	}
	
	
}
