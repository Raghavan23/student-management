package com.student.service;

import com.student.dao.StudentDAO;
import com.student.model.Student;

import java.util.List;

public class StudentService {
    
    private final StudentDAO studentDAO = new StudentDAO();

    public void addStudent(Student student) {
        studentDAO.insertStudent(student);
    }

    public List<Student> getStudents() {
        return studentDAO.getAllStudents();
    }

    public void deleteStudent(int id) {
        studentDAO.deleteStudent(id);
    }

    public void updateStudent(Student student) {
        studentDAO.updateStudent(student);
    }
    
}
