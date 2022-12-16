package connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static DBConnection instance;
	private Connection connection;
	public String database = "tp7db?autoReconnect=true&useSSL=false";
    public String hostname = "localhost";
    public String port = "3306";
    public String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database;
    public String username = "root";
    public String password = "sidi1212";
    String Driver = "com.mysql.cj.jdbc.Driver";
    
    private DBConnection() {
    	try {
			Class.forName(Driver);
			this.connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
                
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
    public Connection getConnection() {
    	return this.connection;
    }
    
    public static DBConnection getInstance() throws SQLException{
    	if(instance == null) {
    		instance = new DBConnection();
    	}else if(instance.getConnection().isClosed()) {
    		instance = new DBConnection();
    	}
    	return instance;
    }
}
