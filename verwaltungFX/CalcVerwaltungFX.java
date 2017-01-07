package verwaltungFX;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class CalcVerwaltungFX {
	static ResultSet rs;
	
	public static Vector getData() throws ClassNotFoundException, SQLException{
		Connection conn =connect();
		
		Vector rueck = new Vector();
		while(rs.next()){
			rueck.add(rs.getString("Titel"));
		}
		
		
		conn.close();
		
		
		return rueck;		
	}
	
	
	
	
	public static Connection connect() throws ClassNotFoundException{
		// load the sqlite-JDBC driver using the current class loader
	    
		Class.forName("org.sqlite.JDBC");
	    Connection connection = null;
	        
	      // create a database connection
	      try {
			connection = DriverManager.getConnection("jdbc:sqlite:MovieDB.db");
			Statement statement = connection.createStatement();
		      statement.setQueryTimeout(30);  // set timeout to 30 sec.

		      rs = statement.executeQuery("select * from film");
		      
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      
	  return connection; 
	   
	}

}
