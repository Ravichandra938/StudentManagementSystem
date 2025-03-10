package com.student.management;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class StudentDAO {
	private Connection conn;
	
	public StudentDAO() {
		conn = DBConnection.getConnection();
	}
	
	//Adding Student
	public void addStudent(String name, int age, String course) {
		String sql = "INSERT INTO students (name,age,course) values(?, ?, ?)";
		try(PreparedStatement stmt = conn.prepareStatement(sql)){
			stmt.setString(1, name);
			stmt.setInt(2, age);
			stmt.setString(3, course);
			stmt.executeUpdate();
			System.out.println("student added successfully!");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//View All Students
	public List<Student> getAllStudents() {
		List<Student> students = new ArrayList<>();
		String sql = "SELECT * from students";
		try(Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql)){
			while(rs.next()) {
				students.add(new Student(rs.getInt("id"),rs.getString("name"),rs.getInt("age"),rs.getString("course")));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return students;
	}
	//Update Student
	public void updateStudent(int id, String name, int age, String course) {
		String sql = "update students set name = ?,age=?, course=? where id = ?";
		try(PreparedStatement stmt = conn.prepareStatement(sql)){
			stmt.setString(1, name);
			stmt.setInt(2, age);
			stmt.setString(3, course);
			stmt.setInt(4, id);
			stmt.executeUpdate();
			System.out.println("Student updated succesfully!");
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//Delete Student
	public void deleteStudent(int id) {
		String sql = "delete from students where id=?";
		try(PreparedStatement stmt = conn.prepareStatement(sql)){
			stmt.setInt(1, id);
			stmt.executeUpdate();
			System.out.println("Student Deleted Successfully!");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	//Search Student
	public Student getStudentById(int id) {
		String sql = "select * from students where id = ?";
		try(PreparedStatement stmt = conn.prepareStatement(sql)){
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				return new Student(rs.getInt("id"),rs.getString("name"),rs.getInt("age"),rs.getString("course"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
