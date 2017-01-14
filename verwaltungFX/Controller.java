package verwaltungFX;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.Vector;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import verwaltung.CalcVerwaltung;

public class Controller implements Initializable {
	
	@FXML
	private Label labelTitel;
	@FXML
	private Label labelJahr;
	@FXML
	private Label labelStory;
	
	@FXML
	private Label labelTitelInhalt;
	@FXML
	private Label labelJahrInhalt;
	@FXML
	private Label labelStoryInhalt;
	
	
	
	
	@SuppressWarnings("rawtypes")
	@FXML
	private ListView<String> filmListe;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Vector x = new Vector();
		
		setLabels(1);
		
		try {
			CalcVerwaltung.connect();
			
			
			
			
			
			
			
			
			x = CalcVerwaltungFX.getData();
			filmListe.getItems().addAll(x);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("alles geladen");
	}
	
	public void beispielRoutineDieVerknuepftWerdenKann(){		
		int index = filmListe.getSelectionModel().getSelectedIndex();
		
		Vector filmDetails = new Vector();
		System.out.println(index);
		filmDetails = CalcVerwaltungFX.getEintragData(index,filmDetails);
		
		labelTitelInhalt.setText((String) filmDetails.get(0));	
		labelJahrInhalt.setText((String) filmDetails.get(2));
		labelStoryInhalt.setText((String) filmDetails.get(1));
	}
	
	@SuppressWarnings("rawtypes")
	public void setLabels(int SprachenID){
		String [] labels= new String[10];
		Vector VectorListe = new Vector();
		
		
		VectorListe = CalcVerwaltungFX.getLabels(SprachenID,VectorListe);
		labelTitel.setText((String) VectorListe.get(4));
		labelJahr.setText((String) VectorListe.get(5));
		labelStory.setText((String) VectorListe.get(6));		
		labelStoryInhalt.setWrapText(true);
	}
	
	
	
	
	
	
	
}
