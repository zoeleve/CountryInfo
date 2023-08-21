import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Main {


public static void main(String[] args) {

	// This was my primary workaround for connecting the MariaDB database to the spring boot application.
	//obviously you didn't want it to work out that way.
	Connection connection = null;
	String url = "jdbc:mariadb://localhost:3306/nation";
	String user = "root";
	String pwd = "password";
	
	try {
		connection = DriverManager.getConnection(url, user, pwd);
		System.out.println("Successfully connected to Maria DB database");

	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	
}
}