package com.student;

import com.student.model.Student;
import com.student.service.StudentService;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        StudentService service = new StudentService();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n== Student Management System ==");
            System.out.println("1. Add student");
            System.out.println("2. View all students");
            System.out.println("3. Update student");
            System.out.println("4. Delete student");
            System.out.println("5. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter email: ");
                    String email = sc.nextLine();
                    System.out.print("Enter course: ");
                    String course = sc.nextLine();
                    System.out.print("Enter age: ");
                    int age = sc.nextInt();
                    sc.nextLine(); // consume newline
                    Student newStudent = new Student(name, email, course, age);
                    service.addStudent(newStudent);
                    System.out.println("✅ Student added!");
                    break;

                case 2:
                    List<Student> list = service.getStudents();
                    System.out.println("\n-- All Students --");
                    for (Student s : list) {
                        System.out.println(s.toString());
                    }
                    break;

                case 3:
                    System.out.print("Enter ID to update: ");
                    int upId = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter new name: ");
                    String upName = sc.nextLine();
                    System.out.print("Enter new email: ");
                    String upEmail = sc.nextLine();
                    System.out.print("Enter new course: ");
                    String upCourse = sc.nextLine();
                    System.out.print("Enter new age: ");
                    int upAge = sc.nextInt();
                    sc.nextLine();
                    Student updated = new Student(upId, upName, upEmail, upCourse, upAge);
                    service.updateStudent(updated);
                    System.out.println("✅ Student updated!");
                    break;

                case 4:
                    System.out.print("Enter ID to delete: ");
                    int delId = sc.nextInt();
                    sc.nextLine();
                    service.deleteStudent(delId);
                    System.out.println("🗑️ Student deleted!");
                    break;

                case 5:
                    System.out.println("👋 Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("❌ Invalid choice!");
            }
        }
    }
}
