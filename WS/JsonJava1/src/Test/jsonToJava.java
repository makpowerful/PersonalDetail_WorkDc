package Test;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;


//import com.fasterxml.jackson.databind.*;



public class jsonToJava {


	public static void main(String[] args) throws ClassNotFoundException, SQLException, JsonGenerationException, JsonMappingException, IOException {
		// TODO Auto-generated method stub
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con=null;

ArrayList<customerDetail> a= new ArrayList<customerDetail>();
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Business", "root", "root");

Statement st=con.createStatement();
ResultSet rs=st.executeQuery("select * from CustomerInfo where Location ='Asia' LIMIT 1;");
while(rs.next()){

	customerDetail c= new customerDetail();
	c.setCourseName(rs.getString(1));
	c.setPurchaseDate(rs.getString(2));
	c.setAmount(rs.getInt(3));
	c.setLocation(rs.getString(4));
	a.add(c);
	
}
//ObjectMapper o=new ObjectMapper();
//o.writeValue(new File("C:\\Users\\mkalamshabaz\\eclipse-workspace2021\\JsonJava\\customerInfo.json"),c);
//con.close();
for(int i=0;i<a.size();i++) {
	
	ObjectMapper o=new ObjectMapper();
	o.writeValue(new File("C:\\Users\\mkalamshabaz\\eclipse-workspace2021\\JsonJava\\customerInfo"+i+".json"),a.get(i));
}

	}

}
