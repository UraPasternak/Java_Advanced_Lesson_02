package ua.lviv.lgs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	private static String USER_NAME = "root";
	private static String USER_PASSWORD = "root";
	private static String URL = "jdbc:mysql://localhost:3306/magasin?useSSL=false&useUnicode=true&characterEncoding=UTF-8";
	
	public static Connection openConnection() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		return DriverManager.getConnection(URL, USER_NAME, USER_PASSWORD);
	}
}
