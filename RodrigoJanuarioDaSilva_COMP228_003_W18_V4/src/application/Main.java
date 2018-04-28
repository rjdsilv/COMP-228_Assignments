package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Main class for the application.
 * 
 * @author Rodrigo Januario da Silva
 * @version 1.0.0
 */
public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			final Scene scene = new Scene(FXMLLoader.load(getClass().getResource("Tools.fxml")));

			// Setting the window properties.
			primaryStage.setScene(scene);
			primaryStage.setTitle("Tools Management App");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
