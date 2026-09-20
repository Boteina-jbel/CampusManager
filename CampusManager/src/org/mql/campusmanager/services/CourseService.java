package org.mql.campusmanager.services;

import java.util.Vector;

import org.mql.campusmanager.models.Course;
import org.mql.campusmanager.models.Professor;
import org.mql.campusmanager.repositories.CourseRepository;

public class CourseService {
	
	private CourseRepository repository;
	
	public CourseService() {
		repository = new CourseRepository();
	}
	
	public boolean addCourse(Course course) {
		if(course == null) {
			return false;
		}
		
		if(repository.findByCode(course.getCode()) != null) {
			return false;
		}
		
		return repository.save(course);
	}
	
	public boolean removeCourse(Course course) {
		if(course == null) {
			return false;
		}
		
	    Course existingCourse = repository.findByCode(course.getCode());
	    
	    if (existingCourse == null) {
	    	return false;
	    }
		
		return repository.delete(existingCourse);
	}
	
	public Course findCourseByCode(String code) {
		return repository.findByCode(code);
	}
	
	public Vector<Course> listAllCourses(){
		return repository.findAll();
	}
	
	public boolean assignCourse(Professor professor, Course course) {

	    if (professor == null || course == null) {
	        return false;
	    }

	    if (professor.getCourses().contains(course)) {
	        System.out.println("Professor " + professor.getFullName() + " already teaches " + course.getName());
	        return false;
	    }

	    if (course.getProfessor() != null) {
	        System.out.println("Course " + course.getName()+ " is already assigned to a professor.");
	        return false;
	    }

	    professor.addCourse(course);
	    course.setProfessor(professor);

	    System.out.println("Course " + course.getName() + " assigned to Professor " + professor.getFullName());

	    return true;
	}

}
