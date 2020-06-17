package com.prac.gui;

import java.util.List;

import com.prac.business.EmployeeManager;
import com.prac.model.Employee;

public class MyGui {

	EmployeeManager emp;
	
	public MyGui() {
		emp = new EmployeeManager();
	}

	public static void main(String[] args) {
		
		MyGui mGui = new MyGui();
		//mGui.showData();
		mGui.addData();
		mGui.showData();
	}
	
	
	public void addData(){
		emp.addData("birju", "33333", "dipen@gmial.com");
	}
	
	public void showData(){
		List<Employee> listEmp = emp.getData();
		String spacer = "       ";
		String formatter = "===========================================================";
		System.out.println(formatter);
		for (Employee employee : listEmp) {
			System.out.println(employee.getId()+spacer+ employee.getEmpName() + spacer + employee.getEmpMailId());
		}
		System.out.println(formatter);
		
	}
	

}
