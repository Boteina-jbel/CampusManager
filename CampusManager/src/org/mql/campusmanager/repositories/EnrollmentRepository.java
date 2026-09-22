package org.mql.campusmanager.repositories;

import java.util.Vector;

import org.mql.campusmanager.models.Course;
import org.mql.campusmanager.models.Enrollment;
import org.mql.campusmanager.models.Student;

public class EnrollmentRepository {

	private Vector<Enrollment> enrollments;
	
	public EnrollmentRepository() {
		enrollments = new Vector<>();
	}
	
	public boolean save(Enrollment enrollment) {
		return enrollments.add(enrollment);
	}
	
	public boolean delete(Enrollment enrollment) {
		return enrollments.remove(enrollment);
	}
	
	public Enrollment findByStudentAndCourse(Student student, Course course) {
		for(Enrollment enrollment : enrollments) {
			if(enrollment.getCourse().equals(course) && enrollment.getStudent().equals(student)) {
				return enrollment;
			}
		}
		return null;
	}
	
	public Vector<Enrollment> findAll(){
		return new Vector<>(enrollments);
	}
}
