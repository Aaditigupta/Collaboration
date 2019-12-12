package com.mindtree.sendandpost.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mindtree.sendandpost.Utility.DbUtil;
import com.mindtree.sendandpost.entity.Student;

public class StudentDao {
	static DbUtil du = new DbUtil();

	public boolean sendDataToDao(Student student) {
		// TODO Auto-generated method stub
		boolean isInserted = false;
		Connection con = du.getConnection();

		String query = "insert into student(studentID,studentName,section) values(?,?,?)";
		try {
			PreparedStatement statement = con.prepareStatement(query);
			statement.setInt(1, student.getStudentId());
			statement.setString(2, student.getStudentName());
			statement.setString(3, student.getStudentSection());
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isInserted;
	}

	public ArrayList<Student> getDataToService() {
		Connection con = du.getConnection();
		ResultSet rs = null;
		ArrayList<Student> studss = new ArrayList<Student>();
		String query2 = "select * from student";
		try {
			PreparedStatement statement = con.prepareStatement(query2);
			rs = statement.executeQuery();
			while (rs.next()) {
				int uid = rs.getInt(1);
				String uname = rs.getString(2);
				String sec = rs.getString(3);
				Student s = new Student(uid, uname, sec);
				studss.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// TODO Auto-generated method stub
		return studss;
	}

	public boolean updateInDao(int id) {
		Connection con = du.getConnection();
		String query3 = "update student set studentName='Nidhi' where studentID='" + id + "'";
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			stmt.executeUpdate(query3);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	public boolean deleteInDao(int id,String name) {
		Connection con = du.getConnection();
		String query3 ="delete from student where studentID='" + id + "' and studentName='"+name+"'";
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			stmt.executeUpdate(query3);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
		
	}
}
