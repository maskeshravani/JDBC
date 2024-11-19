package com.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementEx {

	public void insertDemo() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch1197", "root", "root");
		Statement s = c.createStatement();
		s.executeUpdate("insert into employees values (123,'Ram',4)");
		System.out.println("Data is inserted Succesfully....");
	}

	public void updateDemo() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch1197", "root", "root");
		Statement s = c.createStatement();
		s.executeUpdate("update employees set name = 'Sagar' where emp_id =  105");
		System.out.println("Data is Updated Succesfully......");

	}

	public void deleteDemo() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch1197", "root", "root");
		Statement s = c.createStatement();
		s.executeUpdate("delete from employees where emp_id = 109");
		System.out.println("Data is Deleted Succesfully....");
	}

	public void fetchData() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch1197", "root", "root");
		Statement s = c.createStatement();
		ResultSet rs = s.executeQuery("select * from employees");

		while (rs.next()) {
			System.out.println("Emp_Id: " + rs.getInt(1) + "  Name:  " + rs.getString(2) + "  Depat_Id:  " + rs.getInt(3));

		}
		c.close();
	}
}
