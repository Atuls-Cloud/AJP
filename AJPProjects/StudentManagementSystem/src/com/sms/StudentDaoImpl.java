package com.sms;

import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDaoImpl implements StudentDaoIntrf{
	
	Connection con;

	@Override
	public void createStudent(Student stu) {
		con=DBConnection.createDBConnection();
		String query="insert into student values(?,?,?,?,?,?,?,?)";
		try
		{
			PreparedStatement pstm=con.prepareStatement(query);
			pstm.setString(1,stu.getStudentId());
			pstm.setString(2, stu.getFirstName());
			pstm.setString(3, stu.getLastName());
			pstm.setDate(4, (Date) stu.getDateOfBirth());
			pstm.setString(5,stu.getGender());
			pstm.setString(6, stu.getEmail());
			pstm.setString(7, stu.getPhone());
			pstm.setInt(8, stu.getMarks());
			int cnt=pstm.executeUpdate();
			if(cnt!=0)
				System.out.println("Data inserted successfully!!!");
				
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public void showAllStudent() {
		con=DBConnection.createDBConnection();
		String query="select * from student";
		System.out.println("--------------------------------------------");		
		System.out.println("Student Details:");
		System.out.println("--------------------------------------------");
		System.out.print("StudentID\tFirstName\tLastName\tDateOfBirth\t\tGender\tEmail\t\tPhone\t\tMarks\n");

		try
		{
		Statement stmt=con.createStatement();		
		ResultSet result=stmt.executeQuery(query);
		while(result.next())
		{
			System.out.format("%s\t\t%s\t\t%s\t%s\t\t%s\t%s\t\t%s\t\t%d\n",result.getString(1),result.getString(2),result.getString(3),result.getDate(4),result.getString(5),result.getString(6),result.getString(7),result.getInt(8));
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void showStudentBasedOnId(String id) {
		con=DBConnection.createDBConnection();
		String query="select * from student where studentId="+id;
		System.out.println("--------------------------------------------");		
		System.out.println("Student Details:");
		System.out.println("--------------------------------------------");
		System.out.print("StudentID\tFirstName\tLastName\tDateOfBirth\t\tGender\tEmail\t\tPhone\t\tMarks\n");

		try
		{
		Statement stmt=con.createStatement();		
		ResultSet result=stmt.executeQuery(query);
		while(result.next())
		{
			System.out.format("%s\t%s\t%s\t%s\t\t%s\t%s\t\t%s\t\t%d\n",result.getString(1),result.getString(2),result.getString(3),result.getDate(4),result.getString(5),result.getString(6),result.getString(7),result.getInt(8));
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void updateStudent(String id, String name) {
		con=DBConnection.createDBConnection();
		String query="update student set firstName=? where studentId=?";
		try
		{
			PreparedStatement pstm=con.prepareStatement(query);
			pstm.setString(1, name);
			pstm.setString(2, id);
			int cnt=pstm.executeUpdate();
			if(cnt!=0)
				System.out.println("Data updated successfully!!!");
				
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void deleteStudent(String id) {
		con=DBConnection.createDBConnection();
		String query="delete from student where studentId=?";
		try
		{
			PreparedStatement pstm=con.prepareStatement(query);
			pstm.setString(1, id);
			int cnt=pstm.executeUpdate();
			if(cnt!=0)
				System.out.println("Data deleted successfully!!!");
				
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
