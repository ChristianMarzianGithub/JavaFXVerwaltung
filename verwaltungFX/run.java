package verwaltungFX;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class run extends Application{
	private Scene scene ;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("Layout.fxml"));
		
		scene = new Scene(root,1000,500);
		scene.getStylesheets().add("verwaltungFX/Style.css");		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
