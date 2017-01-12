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
		
		String[] eintraegeArray = new String[5];	 
		System.out.println(index);
		eintraegeArray = CalcVerwaltungFX.getEintragData(index);
		
		labelTitelInhalt.setText(eintraegeArray[0]);	
		labelJahrInhalt.setText(eintraegeArray[2]);
		labelStoryInhalt.setText(eintraegeArray[1]);
	}
	
	public void setLabels(int SprachenID){
		String [] labels= new String[10];
		labels = CalcVerwaltungFX.getLabels(SprachenID);
		labelTitel.setText(labels[4]);
		labelJahr.setText(labels[5]);
		labelStory.setText(labels[6]);		
		labelTitelInhalt.setText("test");
		labelJahrInhalt.setText("test");
		labelStoryInhalt.setText("test");
		labelStoryInhalt.setWrapText(true);
		
		
		
		
		
		
	}
	
	
	
	
	
}
