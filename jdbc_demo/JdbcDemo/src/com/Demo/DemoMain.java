package com.Demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DemoMain 
{
	private static final String url="jdbc:mysql://localhost:3306/mydb";
	private static final String username = "root";
	
	private static final  String password = "098AKsh@#";

	public static void main(String[] args) 
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			try 
			{
				Connection con = DriverManager.getConnection(url,username,password);
				String query = String.format("INSERT INTO student(name,age) VALUES ( ?,? )");
				
				PreparedStatement ps =con.prepareStatement(query);
				ps.setString(1,"Shyamala");
				ps.setInt(2, 22);
				
				int x = ps.executeUpdate();
			}
			catch(SQLException e)
			{
				System.out.println(e.getMessage());
			}
				
				
		} 
		catch(ClassNotFoundException e) 
		{
			System.out.println(e.getMessage());
		}
	}

}
