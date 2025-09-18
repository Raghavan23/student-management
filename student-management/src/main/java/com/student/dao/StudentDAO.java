package com.student.dao;

import com.student.model.Student;
import com.student.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    public void insertStudent(Student student) {
        String sql = "INSERT INTO students (name, email, course, age) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, student.getName());
            pstmt.setString(2, student.getEmail());
            pstmt.setString(3, student.getCourse());
            pstmt.setInt(4, student.getAge());

            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Student student = new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("course"),
                        rs.getInt("age")
                );
                students.add(student);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return students;
    }

    public void deleteStudent(int id) {
    String sql = "DELETE FROM students WHERE id = ?";
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, id);
        stmt.executeUpdate();
        } catch (Exception e) {
        e.printStackTrace();
        }
    }

    public void updateStudent(Student student) {
        String sql = "UPDATE students SET name = ?, email = ?, course = ?, age = ? WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, student.getName());
            stmt.setString(2, student.getEmail());
            stmt.setString(3, student.getCourse());
            stmt.setInt(4, student.getAge());
            stmt.setInt(5, student.getId());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
