package com.dev.test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.dev.dao.EmpInfoDAO;
import com.dev.dto.Employee;
import com.dev.dto.User_Master;
import com.dev.factory.EmpInfoDAOFactory;
import com.dev.factory.HibernateUtils;
import com.dev.json.User;

public class SearchEmpTestObjectToJson {
	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		System.out.println("enter the UserID");
		String userId=scn.nextLine();
		SessionFactory factory=HibernateUtils.getSessionFactory();
		Session session=  factory.openSession();
		EmpInfoDAO emp1=EmpInfoDAOFactory.getDatabase();
		Employee emp=null;

		emp =emp1.searchEmp(userId);
		//System.out.println(emp);

		ObjectMapper mapper = new ObjectMapper();

		//For testing
		//User user = createDummyUser();

		try {
			//Convert object to JSON string and save into file directly 
			mapper.writeValue(new File("Employee.json"), emp);

			//Convert object to JSON string
			String jsonInString = mapper.writeValueAsString(emp);
			System.out.println(jsonInString);

			//Convert object to JSON string and pretty print
			jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(emp);
			System.out.println(jsonInString);


		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		//		System.out.println(emp.getEmp_Contact_Num());	
		//		System.out.println(emp.getEmp_Designation());

		//	session.save(emp);

		session.beginTransaction().commit();

	}	
	private static Employee createDummyUser(){

		Employee emp = new Employee();
		
		User_Master user=new User_Master();
		
		user.setUserId("16");
		user.setUserName("sada");
		user.setUserPassword("1234");
		user.setUserType("softwre engineer");
		emp.setUser(user);

		return emp;


	}
}

