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
}
