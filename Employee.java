package com.dev.dto;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {

	@Column(name="Emp_ID")
	@Id
	private	String  emp_ID; 

	@Column(name="Emp_first_name")
	private	String  emp_First_Name ;



	@Column(name="Emp_last_name")
	private	String  emp_Last_Name ;   

	@Column(name="Emp_Date_of_Birth")
	private	Date    emp_Date_of_Birth ;

	@Column(name="Emp_Date_of_Joining")
	private	Date    emp_Date_of_Joining;

	@Column(name="Emp_Dept_ID")
	private	int     emp_Dept_ID  ; 

	@Column(name=" Emp_Grade")
	private	String  emp_Grade ; 

	@Column(name="Emp_Designation")
	private	String  emp_Designation;

	@Column(name="Emp_Basic")
	private	int     emp_Basic  ;  

	@Column(name="Emp_Gender")
	private	String  emp_Gender ;     

	@Column(name="Emp_Marital_Status")
	private	String  emp_Marital_Status;

	@Column(name=" Emp_Home_Address")
	private	String  emp_Home_Address ;

	@Column(name=" Emp_Contact_Num")
	private    String  emp_Contact_Num;
	
	@OneToOne(cascade = CascadeType.ALL) 
	@JoinColumn(name = "Emp_ID", referencedColumnName = "User_Id")// to add the foreign key
	private User_Master user;
	
	

	public User_Master getUser() {
		return user;
	}

	public void setUser(User_Master user) {
		this.user = user;
	}

	public String getEmp_ID() {
		return emp_ID;
	}

	public void setEmp_ID(String emp_ID) {
		this.emp_ID = emp_ID;
	}

	public String getEmp_First_Name() {
		return emp_First_Name;
	}

	public void setEmp_First_Name(String emp_First_Name) {
		this.emp_First_Name = emp_First_Name;
	}

	public String getEmp_Last_Name() {
		return emp_Last_Name;
	}

	public void setEmp_Last_Name(String emp_Last_Name) {
		this.emp_Last_Name = emp_Last_Name;
	}

	public Date getEmp_Date_of_Birth() {
		return emp_Date_of_Birth;
	}

	public void setEmp_Date_of_Birth(Date emp_Date_of_Birth) {
		this.emp_Date_of_Birth = emp_Date_of_Birth;
	}

	public Date getEmp_Date_of_Joining() {
		return emp_Date_of_Joining;
	}

	public void setEmp_Date_of_Joining(Date emp_Date_of_Joining) {
		this.emp_Date_of_Joining = emp_Date_of_Joining;
	}

	public int getEmp_Dept_ID() {
		return emp_Dept_ID;
	}

	public void setEmp_Dept_ID(int emp_Dept_ID) {
		this.emp_Dept_ID = emp_Dept_ID;
	}

	public String getEmp_Grade() {
		return emp_Grade;
	}

	public void setEmp_Grade(String emp_Grade) {
		this.emp_Grade = emp_Grade;
	}

	public String getEmp_Designation() {
		return emp_Designation;
	}

	public void setEmp_Designation(String emp_Designation) {
		this.emp_Designation = emp_Designation;
	}

	public int getEmp_Basic() {
		return emp_Basic;
	}

	public void setEmp_Basic(int emp_Basic) {
		this.emp_Basic = emp_Basic;
	}

	public String getEmp_Gender() {
		return emp_Gender;
	}

	public void setEmp_Gender(String emp_Gender) {
		this.emp_Gender = emp_Gender;
	}

	public String getEmp_Marital_Status() {
		return emp_Marital_Status;
	}

	public void setEmp_Marital_Status(String emp_Marital_Status) {
		this.emp_Marital_Status = emp_Marital_Status;
	}

	public String getEmp_Home_Address() {
		return emp_Home_Address;
	}

	public void setEmp_Home_Address(String emp_Home_Address) {
		this.emp_Home_Address = emp_Home_Address;
	}

	public String getEmp_Contact_Num() {
		return emp_Contact_Num;
	}

	public void setEmp_Contact_Num(String emp_Contact_Num) {
		this.emp_Contact_Num = emp_Contact_Num;
	}

	@Override
	public String toString() {
		return "Employee [emp_ID=" + emp_ID + ", emp_First_Name=" + emp_First_Name + ", emp_Last_Name=" + emp_Last_Name
				+ ", emp_Date_of_Birth=" + emp_Date_of_Birth + ", emp_Date_of_Joining=" + emp_Date_of_Joining
				+ ", emp_Dept_ID=" + emp_Dept_ID + ", emp_Grade=" + emp_Grade + ", emp_Designation=" + emp_Designation
				+ ", emp_Basic=" + emp_Basic + ", emp_Gender=" + emp_Gender + ", emp_Marital_Status="
				+ emp_Marital_Status + ", emp_Home_Address=" + emp_Home_Address + ", emp_Contact_Num=" + emp_Contact_Num
				+ "]";
	}


}