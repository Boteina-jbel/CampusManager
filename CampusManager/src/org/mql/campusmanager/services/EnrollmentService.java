package org.mql.campusmanager.services;

import org.mql.campusmanager.models.Student;
import org.mql.campusmanager.models.Course;
import org.mql.campusmanager.models.Enrollment;

public class EnrollmentService {

	// 1. Enroll a student in a course
    public boolean enrollStudent(Student student, Course course) {
        // 1️ Check if student is already enrolled
        for (Enrollment e : student.getEnrollments()) {
            if (e.getCourse().equals(course)) {
                System.out.println("Student " + student.getFullName() + " is already enrolled in " + course.getName());
                return false;
            }
        }
        // 2️ Check if course is full
        if (course.getEnrollments().size() >= course.getCapacity()) {
            System.out.println("Course " + course.getName() + " is full!");
            return false;
        }
        // 3️ Create enrollment
        Enrollment enrollment = new Enrollment(student, course);
        // 4️ Add enrollment to student & course
        student.addEnrollment(enrollment);
        course.addEnrollment(enrollment);
        System.out.println("Student " + student.getFullName() + " enrolled in " + course.getName());
        return true;
    }
    
 // 2. Assign or update a grade (including rattrapage)
    public void assignGrade(Student student, Course course, double grade) {
        // 1️ Find existing enrollment
        for (Enrollment enrollment : student.getEnrollments()) {
            if (enrollment.getCourse().equals(course)) {
                // 2️ Update grade (first session or rattrapage)
                enrollment.setGrade(grade);

                System.out.println("Grade " + grade + " assigned to "
                        + student.getFullName() + " for course "
                        + course.getName());
                return; // stop after finding it
            }
        }
        // 3️ If no enrollment found
        System.out.println("Student is not enrolled in this course.");
    }


    // 3. Calculate the average grade for a student
    public double calculateAverage(Student student) {

        double sum = 0;
        int count = 0;

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
    
}
