package org.mql.campusmanager.services;

import org.mql.campusmanager.models.Student;
import org.mql.campusmanager.repositories.EnrollmentRepository;

import java.util.Vector;

import org.mql.campusmanager.models.Course;
import org.mql.campusmanager.models.Enrollment;

public class EnrollmentService {

	private EnrollmentRepository repository;
	
	public EnrollmentService() {
		repository = new EnrollmentRepository();
	}
	
	// 1. Enroll a student in a course
    public boolean enrollStudent(Student student, Course course) {
    	
    	if(student == null || course== null) {
    		return false;
    	}
    	
    	Enrollment existingEnrollment =  repository.findByStudentAndCourse(student, course);
    	if(existingEnrollment != null) {
    		return false;
    	}
    	        
        if (course.getEnrollments().size() >= course.getCapacity()) {
            return false;
        }
        
        Enrollment enrollment = new Enrollment(student, course);
        
        repository.save(enrollment);
        
        student.addEnrollment(enrollment);
        course.addEnrollment(enrollment);

        return true;
    }
    
 // 2. Assign or update a grade (including rattrapage)
    public boolean assignGrade(Student student, Course course, double grade) {
    	
    	if (student == null || course == null) {
    	    return false;
    	}
    	
    	Enrollment existingEnrollment = repository.findByStudentAndCourse(student, course);
    	
    	if(existingEnrollment == null) {    		
    		return false;
    	}
    	
		existingEnrollment.setGrade(grade);
        return true;
    }


    // 3. Calculate the average grade for a student
    public double calculateAverage(Student student) {

        double sum = 0;
        int count = 0;
        
        if (student == null) {
            return 0;
        }

        for (Enrollment enrollment : student.getEnrollments()) {

            if (enrollment.getGrade() != null) {
                sum += enrollment.getGrade();
                count++;
            }
        }

        if (count == 0) {
            return 0; // no grades yet
        }

        return sum / count;
    }
    
    // 4. Check if student is admitted
    public boolean isAdmitted(Student student) {

    	if (student == null) {
    	    return false;
    	}
    	
        double average = calculateAverage(student);
        if (average >= 10) {
            System.out.println("Student " + student.getFullName() +
                    " is admitted with average " + average);
            return true;
        }
        System.out.println("Student " + student.getFullName() +
                " is not admitted. Average: " + average);

        return false;
    }
    
    // 5. List all courses of a student
    public Vector<Course> listStudentCourses(Student student) {
    	
    	Vector<Course> courses = new Vector<>();
    	
    	if (student == null) {
            return courses;
        }

        for (Enrollment enrollment : student.getEnrollments()) {
            courses.add(enrollment.getCourse());
        }

        return courses;
    }

    // 6. List all students in a course
    public Vector<Student> listCourseStudents(Course course) {

    	Vector<Student> students = new Vector<>();
    	
    	if (course == null) {
    	    return students;
    	}

        for (Enrollment enrollment : course.getEnrollments()) {
            students.add(enrollment.getStudent());
        }
        return students;
    }
}
