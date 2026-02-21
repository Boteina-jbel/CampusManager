package org.mql.campusmanager.services;

import org.mql.campusmanager.models.Course;
import org.mql.campusmanager.models.Professor;

public class CourseService {
	
	public boolean assignCourse(Professor professor, Course course) {
		if(professor.getCourses().contains(course)) {
            System.out.println("Professor " + professor.getFullName() + " already teaches " + course.getName());
			return false;
		}
		
		professor.addCourse(course);
        // assign professor to course
		course.setProfessor(professor);
		
        System.out.println("Course " + course.getName() + " assigned to Professor " + professor.getFullName());
		return true;
	}

}
