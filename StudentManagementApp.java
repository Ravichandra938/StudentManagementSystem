package com.student.management;

import java.util.Scanner;
import java.util.List;
public class StudentManagementApp {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		StudentDAO studentDAO = new StudentDAO();
		
		while(true) {
			System.out.println("\n---Student Management System ---");
			System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Search Student");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch(choice) {
            case 1:
            	System.out.print("Enter Name: ");
            	String name = scanner.nextLine();
            	System.out.print("Enter Age: ");
            	int age = scanner.nextInt();
            	scanner.nextLine();
            	System.out.print("Enter Course: ");
            	String course = scanner.nextLine();
            	
            	studentDAO.addStudent(name, age, course);
            	break;
            case 2:
            	List<Student> students = studentDAO.getAllStudents();
            	System.out.println("\nStudent List:");
            	System.out.printf("| %-5s | %-15s | %-5s | %-10s |\n", "ID", "Name", "Age", "Course");
            	System.out.println("+-------+-----------------+-------+------------+");
            	for(Student s : students) {
            		System.out.printf("| %-5d | %-15s | %-5d | %-10s |\n", s.getId(), s.getName(), s.getAge(), s.getCourse());
            	}
            	break;
            	
            case 3:
            	System.out.print("Enter The student Id to update: ");
            	int updateId = scanner.nextInt();
            	scanner.nextLine();
            	System.out.print("Enter New Name: ");
            	String newName = scanner.nextLine();
            	System.out.print("Enter New Age: ");
            	int newAge = scanner.nextInt();
            	scanner.nextLine();
            	System.out.print("Enter New Course: ");
            	String newCourse = scanner.nextLine();
            	studentDAO.updateStudent(updateId, newName, newAge, newCourse);
            	break;
            case 4:
            	System.out.print("Enter Student Id to Delete: ");
            	int delId = scanner.nextInt();
            	studentDAO.deleteStudent(delId);
            	break;
            case 5:
            	System.out.print("Enter Student ID to Search:");
            	int searchId = scanner.nextInt();
            	Student student = studentDAO.getStudentById(searchId);
            	if(student !=null) {
            		System.out.println("\nStudent Found:"+ student.getName() + " | " + student.getAge() + " | " + student.getCourse());
            	}else {
            		System.out.println("Student not found.");
            	}
            	break;
            case 6:
            	System.out.println("Existing...");
            	scanner.close();
            	return;
            	
            default:
            	System.out.println("Inavalid option! Try again");
            }
            }
	}
}
