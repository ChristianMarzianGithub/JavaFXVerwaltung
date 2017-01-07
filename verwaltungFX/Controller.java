package verwaltungFX;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

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

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		labelTitel.setText("Titel:");
		labelJahr.setText("Erscheinungsjahrasdfasdfasdfsadfasdf:");
		labelStory.setText("Story:");		
		labelTitelInhalt.setText("test");
		labelJahrInhalt.setText("test");
		labelStoryInhalt.setText("test");
		
		System.out.println("alles geladen");
	}
	
	public void beispielRoutineDieVerknuepftWerdenKann(){
		
	}

}
