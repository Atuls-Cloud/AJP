package com.empapp;

public interface EmployeeDaoIntrf {
	public void createEmployee(Employee emp);
	public void showAllEmployee();
	public void showEmployeeBasedOnId(int id);
	public void updateEmployee(int id, String name);
	public void deleteEmployee(int id);

}
