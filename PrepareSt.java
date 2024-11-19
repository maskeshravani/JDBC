package com.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PrepareSt {

	public void insertDemo() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch1197", "root", "root");
		PreparedStatement ps = c.prepareStatement("insert into sales (SalesId, product, Amount) values (?,?,?)");
		ps.setInt(1, 8);
		ps.setString(2, "A");
		ps.setInt(3, 190);

		ps.executeUpdate();
		System.out.println("Data is Inserted Succesfully....");

	}

	public void updateDemo() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch1197", "root", "root");

		PreparedStatement ps = c.prepareStatement("update sales set Amount =?  where SalesId =?");
		ps.setInt(1, 570);
		ps.setInt(2, 6);

		ps.executeUpdate();
		System.out.println("Data is Updated Succesfully......");

	}

	public void deleteDemo() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch1197", "root", "root");

		PreparedStatement ps = c.prepareStatement("delete from sales where SalesId =?");
		ps.setInt(1, 4);
		ps.executeUpdate();
	
		System.out.println("Data is Deleted Succesfully......");
	}
	public void fetchData() throws Exception{
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch1197", "root", "root");
			PreparedStatement ps = c.prepareStatement("select * from employees");
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				System.out.println("SalesId_Id: " + rs.getInt(1) + "  product:  " + rs.getString(2) + "  Amount:  " + rs.getInt(3));

			}
			c.close();
	}

}


