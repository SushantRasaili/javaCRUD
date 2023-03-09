import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseCon{

	private static final String DB_NAME = "studentform";
	private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost/";
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "";
	
	public static Connection getConnection() throws Exception{
		Class.forName(DRIVER_NAME);
		return DriverManager.getConnection(URL+DB_NAME,USER_NAME,PASSWORD);
	}
}

