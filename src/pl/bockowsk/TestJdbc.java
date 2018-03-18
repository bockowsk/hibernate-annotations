package pl.bockowsk;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		String url="jdbc:postgresql://localhost/hb_student_tracker?useSSL=false";
		String user="obockows";
		String password="";
		try {
			System.out.println("Connecting to DB...");
			Connection myConnection=DriverManager.getConnection(url,user,password);
			System.out.println("connected!");
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
