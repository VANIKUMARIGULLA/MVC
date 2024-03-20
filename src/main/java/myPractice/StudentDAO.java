package myPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class StudentDAO {

	String status = null;
	
	public String create(Student s) {
		
		String username = s.getUsername();
		String firstname = s.getFirstname();
		String lastname = s.getLastname();
		String email = s.getEmail();
		String password = s.getPassword();
		String confirmpassword = s.getConfirmpassword();
		
		System.out.println("Data of DAO : " + username + " " + firstname + " " + lastname + " " + email + " " + password + " " + confirmpassword);
		
		try {
			//Loading the driver.
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Connection establishment
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practical", "root", "root");
			
			
			
			//preparedStatement
			PreparedStatement ps = con.prepareStatement("insert into students values(?,?,?,?,?,?)");
			ps.setString(1, username);
			ps.setString(2, firstname);
			ps.setString(3, lastname);
			ps.setString(4, email);
			ps.setString(5, password);
			ps.setString(6, confirmpassword);
			
			int n = ps.executeUpdate();
			
			if(n>0) {
				status = "SUCCESS";
				System.out.println(n + "row(s) inserted");
			}
			else {
				status = "FAILURE";
				System.out.println("something went wrong!!!");
			}
		}
		catch(Exception e) {
			System.out.println("Exception : " + e);
		}
		
		return status;
	}
}
