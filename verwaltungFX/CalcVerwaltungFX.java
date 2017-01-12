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
	
	public static String[] getEintragData(int id){
		
		String rueck = "";
		
		String[] rueckArray = new String[5];		
		try {
			Connection conn =connect();
			Statement statement = conn.createStatement();
			rs = statement.executeQuery("Select * from film where FilmID =" + Integer.toString(id+1));
			rueckArray[0] = rs.getString("Titel");
			rueckArray[1] = rs.getString("StoryLine");
			rueckArray[2] =  rs.getString("ReleaseDate"); 
			rueckArray[3] =  rs.getString("RunTimeMin");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rueckArray;
	}
	
public static String[] getLabels(int SprachenID){
		
		String rueck = "";
		int i = 0;
		
		String[] rueckArray = new String[10];		
		try {
			Connection conn =connect();
			Statement statement = conn.createStatement();
			rs = statement.executeQuery("Select * from Uebersetzung where SprachenID =" + Integer.toString(SprachenID));
			
			while(rs.next()){
				rueckArray[i] = rs.getString("Bezeichnung");
				i++;
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rueckArray;
	}
	
	
	
	
	
	
	
	public static Vector getLanguageVector() throws ClassNotFoundException, SQLException{
		Connection conn =connect();
		try {
			conn = DriverManager.getConnection("jdbc:sqlite:MovieDB.db");
			Statement statement = conn.createStatement();
		      statement.setQueryTimeout(30);  // set timeout to 30 sec.
		      rs = statement.executeQuery("select * from film");
		      
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      
		
		
		
		Vector rueck = new Vector();
		while(rs.next()){
			try {
				rueck.add(rs.getString("Titel"));
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return rueck;	
	}

}
