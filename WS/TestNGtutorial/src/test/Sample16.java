package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class Sample16 {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Qadbt","root","root");
		Statement s=con.createStatement();
		ResultSet rs= s.executeQuery("Select * from Employeeinfo");
		while(rs.next())
		{
		System.out.println(rs.getString("name"));
		}
	}

}
