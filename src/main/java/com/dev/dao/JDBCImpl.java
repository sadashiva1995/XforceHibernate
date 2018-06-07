package com.dev.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.dev.beans.Userinfo;




public class JDBCImpl implements UserInfoDAO {

	@Override
	public boolean CreateProfile(Userinfo data) {
		
	        
		 
			
			Connection con = null;
			PreparedStatement pstmt1 = null;
			FileReader reader=null;
			try {
				
				   
				
					// 1.Load the driver....
					// Driver class : com.mysql.jdbc.Driver

					//creating the properties instance...
				    reader= new FileReader("C:\\TestYantra\\UserWebApp\\data1.properties");
					
					Properties properties = new Properties();
					properties.load(reader);
					String	driver_class_name=properties.getProperty("driver_class");
					
					Driver driver = (Driver)Class.forName(driver_class_name).newInstance();
					DriverManager.registerDriver(driver);
					
					//3.issue the sql  queries via connection
					
					String dburl =properties.getProperty("url") ;
				    con = DriverManager.getConnection(dburl,properties);

				    
				    String query1 = " insert into User_info values(?,?,?,?,? ) ";
				  
				 pstmt1 = con.prepareStatement(query1);
				 
				pstmt1.setInt(1,data.getUser_id());
				pstmt1.setString(2,data.getFirstName());
				pstmt1.setString(3,data.getLastName());
				pstmt1.setString(4,data.getEmail_id());
				pstmt1.setString(5,data.getPassword());
				
				pstmt1.executeUpdate();
				
			
				
				return true;
				 
			
			}//try
			
			catch (Exception e)
			{
				e.printStackTrace();
			}
		
			finally
			{
				//5 close all jdbc object
				if(con!=null)
				{
					try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(pstmt1!=null)
				{
					try {
						pstmt1.close();
				    	} 
					catch (SQLException e) {
						
						e.printStackTrace();
					}
				}
			
				
				
			}//end finally


		
		return true;
	}

	
	
	@Override
	public Userinfo Login(int User_id, String Password) {
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		FileReader reader=null;
		 
		Userinfo user=new Userinfo();
			try {
				// 1.Load the driver....
				// Driver class : com.mysql.jdbc.Driver

				//creating the properties instance...
				 reader= new FileReader("E:\\eclipse programs\\sadashiva\\TestYantra\\MyWebProject\\data.properties");
					
				
				Properties properties = new Properties();
				properties.load(reader);
				String	driver_class_name=properties.getProperty("driver_class");
				
				Driver driver = (Driver)Class.forName(driver_class_name).newInstance();
				DriverManager.registerDriver(driver);
				

				String dburl =properties.getProperty("url") ;
			    con = DriverManager.getConnection(dburl,properties);

			String query="select * from User_info where User_id=? and Password=?";
			
			
		    pstmt =con.prepareStatement(query);
		    pstmt.setInt(1,User_id);
		    pstmt.setString(2,Password);
			
		    rs=pstmt.executeQuery();
			
			
			if(rs.next()) 
			{
				
				
				
				int user_id=rs.getInt("User_id");
				user.setUser_id(user_id);
				String FirstName=rs.getString("FirstName");
				user.setFirstName(FirstName);
				String LastName=rs.getString("LastName");
				user.setLastName(LastName);
				String Email_id=rs.getString("Email_id");
				user.setEmail_id(Email_id);
				String password=rs.getString("Password");
				user.setPassword(Password);
				
				
				
			return user;
				
			}//end if loop
			else
			{
				return null;
				//System.out.println("Login Failed");
			}
		}//end try block
					
		catch(Exception e)
		{
			e.printStackTrace();
		}			
	   
		finally 
		{
		  try
		  {
			if (con!=null)
			{
			 con.close();	
			}
			if (pstmt!=null)
			{
			 pstmt.close();	
			}
			if (rs!=null)
			{
			 rs.close();	
			}
		  } //end inside try block
		  
		  catch (Exception e)
		  {
			e.printStackTrace();
		  }
			
		}//end finally
	
	
      
		
		return user;
	}

	
}
