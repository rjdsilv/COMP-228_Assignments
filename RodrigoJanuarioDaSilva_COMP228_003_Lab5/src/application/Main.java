package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			final Scene scene = new Scene(FXMLLoader.load(getClass().getResource("Hospitals.fxml")));

			// Setting the window properties.
			primaryStage.setScene(scene);
			primaryStage.setTitle("Hospital Management App");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
