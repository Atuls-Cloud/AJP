package com.sms;

public interface StudentDaoIntrf {
	public void createStudent(Student stu);
	public void showAllStudent();
	public void showStudentBasedOnId(String id);
	public void updateStudent(String id, String name);
	public void deleteStudent(String id);
}
