package verwaltungFX;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.Vector;

import org.junit.Test;


public class DatenbankTests {

	@Test
	public void test() {
		assertEquals(0,0);			
	}
	
	@Test
	public void verbindungPruefen(){
		try {
					assertTrue(CalcVerwaltungFX.connect("TestMovieDB.db").isValid(0) );
					
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
			}
	
	@Test
	public void EintragHolen(){
		Vector x = new Vector();		
		CalcVerwaltungFX.getEintragData(1, x, "TestMovieDB.db");		
	}
		
	@Test
	public void LabelsHolenDeutsch(){
		Vector x = new Vector();
		CalcVerwaltungFX.getLabels(1, x);
		assertTrue(x.size()>0);
	}

	
	@Test
	public void AlleFilmTitelHolen(){
		
		
		
		
		Vector x = new Vector();
		try {
			x=CalcVerwaltungFX.getData("TestMovieDB.db");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		assertTrue(x.size()>0);
	}
	
}
