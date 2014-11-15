package by.bsuir.psp;

import java.sql.*;
import java.util.Properties;

import javax.swing.JOptionPane;

public class ConnectionSQL {
	Connection connect = null;
	public static Connection dbConnector(String user, String password, String url) {
		//String url= "jdbc:mysql://localhost:3306/DB";
		//String user = "root";
		//String password = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Properties prop = new Properties();
			prop.put("user", user);
			prop.put("password", password);
			Connection connect = DriverManager.getConnection(url, user, password);
			JOptionPane.showMessageDialog(null, "Connection Seccesful");
			return connect;
		}catch(Exception e) {
			System.out.println("asd");
			
			JOptionPane.showMessageDialog(null,  e);
			return null;
		}
	}

}
