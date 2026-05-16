package org.mql.campusmanager.repositories;

import java.util.Vector;

import org.mql.campusmanager.models.Student;

public class StudentRepository {

    private Vector<Student> students;

    public StudentRepository() {
        students = new Vector<>();
    }

    // Save student
    public boolean save(Student student) {
        return students.add(student);
    }

    // Delete student
    public boolean delete(Student student) {
        return students.remove(student);
    }

    // Find student by CNE
    public Student findByCNE(String cne) {

        for (Student student : students) {

            if (student.getCNE().equals(cne)) {
                return student;
            }
        }

        return null;
    }

    // Return all students
    public Vector<Student> findAll() {
        return new Vector<>(students);
    }
}