package com.academy.student;

import java.util.Scanner;

public class StudentManager {

    private static final int MAX_STUDENTS = 20;

    private final Student[] students = new Student[MAX_STUDENTS];
    private int studentCount = 0;
    private final Scanner scanner;

    public StudentManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public void displayMenu() {
        System.out.println("====================================");
        System.out.println("Student Management System");
        System.out.println("====================================");
        System.out.println("1. Add Student");
        System.out.println("2. Display Students");
        System.out.println("3. Search Student");
        System.out.println("4. Average Marks");
        System.out.println("5. Exit");
        System.out.print("Enter Choice : ");
    }

    // Methods addStudent, displayStudents, searchStudent, calculateAverage
    // will be filled in later steps.
    public void addStudent() {
        if (studentCount >= MAX_STUDENTS) {
            System.out.println("full");
            return;
        }
        System.out.println("Student ID: ");
        int studentID = Integer.parseInt(scanner.nextLine());
        while (studentID < 0) {
            System.out.println("Please enter a valid positive ID");
            studentID = Integer.parseInt(scanner.nextLine());
        }

        for (int i = 0; i < studentCount; i++) {
            if (students[i].getStudentId() == studentID) {
                System.out.println("Student ID already exists");
                return;
            }
        }

        System.out.println("Name: ");
        String studentName = scanner.nextLine();
        while (studentName.length() <= 0) {
            System.out.println("Please enter a valid Name: ");
            studentName = scanner.nextLine();
        }

        System.out.println("Course: ");
        String studentCourse = scanner.nextLine();
        while (studentCourse.length() <= 0) {
            System.out.println("Please enter a valid Course: ");
            studentCourse = scanner.nextLine();
        }

        System.out.println("Marks: ");
        double studentGrade = Double.parseDouble(scanner.nextLine());
        while (studentGrade < 0 || studentGrade > 100) {
            System.out.println("Please enter marks between 0 and 100: ");
            studentGrade = Double.parseDouble(scanner.nextLine());
        }
        students[studentCount] = new Student(studentID, studentName, studentCourse, studentGrade);
        studentCount++;
        System.out.println("Successfully Added Student");

    }

    public void displayStudents() {
        if (studentCount == 0) {
            System.out.println("There are no students to display.");
            return;
        }
        System.out.println("---------------------------------------------------");
        System.out.printf("%-8s %-20s %-15s %-8s%n",
            "ID",
            "Name",
            "Course",
            "Marks");
        for (int i = 0; i < studentCount; i++){
            System.out.println("---------------------------------------------------");
            System.out.printf("%-8d %-20s %-15s %-8.2f%n",
                    students[i].getStudentId(),
                    students[i].getName(),
                    students[i].getCourse(),
                    students[i].getMarks());
        }
        System.out.println("---------------------------------------------------");
    }

    public void searchStudent() {
        if (studentCount == 0) {
            System.out.println("There are no students to search for");
            return;
        }
        System.out.println("Please enter student ID: ");
        int studentID = Integer.parseInt(scanner.nextLine());
        while (studentID < 0) {
            System.out.println("Please enter a valid positive student ID");
            studentID = Integer.parseInt(scanner.nextLine());
        }
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getStudentId() == studentID) {
                students[i].display();
                return;
            }
        }
        System.out.println("Student Not Found.");
    }

    public void calculateAverage() {
       if(studentCount == 0) {
           System.out.println("No students available.");
           return;
       }

       double sum = 0;
       for (int i = 0; i < studentCount; i++) {
           sum += students[i].getMarks();
       }
       double average = sum / studentCount;
       System.out.print("Average Grades: ");
       System.out.printf("%.2f", average);
       System.out.println();

    }

}