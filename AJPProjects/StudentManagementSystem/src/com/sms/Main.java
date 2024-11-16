package com.sms;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.sql.Date;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		StudentDaoIntrf dao=new StudentDaoImpl();
		System.out.println("**Welcome to Student management Application**\n\n");
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Enter your choice:");
			System.out.println("1. Add Student\n" +
					"2. Show all Students\n" +
					"3. Show Student based on id\n"+
					"4. Update the Student\n"+
					"5. Delete the Student\n"+
					"6. Exit from App");
			int ch= sc.nextInt();
			switch(ch)
			{
			case 1:
				Student stu=new Student();
				System.out.println("Enter ID:");
				String studentId=sc.next();
				System.out.println("Enter first name:");
				String firstName=sc.next();
				System.out.println("Enter last name:");
				String lastName=sc.next();
				System.out.println("Enter date of birth (yyyy-mm-dd):");
				String dob= sc.next();
				Date date1 = parseDate(dob);
				System.out.println("Enter gender:");
				String gender=sc.next();
				System.out.println("Enter email:");
				String email=sc.next();
				System.out.println("Enter phone:");
				String phone=sc.next();
				System.out.println("Enter marks:");
				int marks=sc.nextInt();
				
				stu.setStudentId(studentId);
				stu.setFirstName(firstName);
				stu.setLastName(lastName);
				stu.setDateOfBirth(date1);
				stu.setGender(gender);
				stu.setEmail(email);
				stu.setPhone(phone);
				stu.setMarks(marks);
				dao.createStudent(stu);
				break;
			case 2:
				dao.showAllStudent();
				break;
			case 3:
				System.out.println("Enter id to show the details of the Student:");
				String stuid=sc.next();
				dao.showStudentBasedOnId(stuid);
				break;
			case 4:
				System.out.println("Enter id to update the details of the Student:");
				String stuid1=sc.next();
				System.out.println("Enter the new name of the Student:");
				String name1=sc.next();
				dao.updateStudent(stuid1, name1);
				break;
			case 5:
				System.out.println("Enter id to delete the details of the Student:");
				String id1=sc.next();
				dao.deleteStudent(id1);
				break;
			case 6:
				System.out.println("Thank you to use the App...");
				System.exit(0);
			default:
				System.out.println("Enter valid choice!");
			}
			
		} while (true);
		
	}

	private static Date parseDate(String dob) {
		try {
            LocalDate localDate = LocalDate.parse(dob, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            return Date.valueOf(localDate) ;  // Convert LocalDate to java.sql.Date
        } catch (DateTimeParseException e) {
            return null;  // Return null if the format is incorrect
        }
	}

}
