package com.prac.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name = "empName")
	private String empName;
	
	@Column(name = "empMailId")
	private String empMailId;
	
	@Column(name = "empContactNumber")
	private String empContactNumber;
	
	public Employee(){
		
	}
	
	public Employee(String empName, String empMailId, String emplContactNumber){
		this.empName = empName;
		this.empMailId = empMailId;
		this.empContactNumber = emplContactNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpMailId() {
		return empMailId;
	}

	public void setEmpMailId(String empMailId) {
		this.empMailId = empMailId;
	}

	public String getEmpContactNumber() {
		return empContactNumber;
	}

	public void setEmpContactNumber(String empContactNumber) {
		this.empContactNumber = empContactNumber;
	}

	@Override
	public String toString() {
		String data = "{\"empName\":" + empName + ",\"empMailId:\"" + empMailId + ",\"empContactNumber:\""
				+ empContactNumber + "}";
		return data;
	}

}
