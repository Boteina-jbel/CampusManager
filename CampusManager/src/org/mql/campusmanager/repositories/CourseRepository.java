package org.mql.campusmanager.repositories;

import java.util.Vector;

import org.mql.campusmanager.models.Course;

public class CourseRepository {

	private Vector<Course> courses;
	
	public CourseRepository() {
		courses = new Vector<>();
	}
	
	public boolean save(Course course) {
		return courses.add(course);
	}
	
	public boolean delete(Course course) {
		return courses.remove(course);
	}
	
	public Course findByCode(String code) {
		for(Course course : courses) {
			if(course.getCode().equals(code)) {
				return course;
			}
		}
		return null;
	}
	
	public Vector<Course> findAll(){
		return new Vector<>(courses);
	}
}
