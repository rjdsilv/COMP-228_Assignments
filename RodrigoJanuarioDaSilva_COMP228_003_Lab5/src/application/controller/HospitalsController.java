package application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * Controller class for the hospitals application.
 * 
 * @author Rodrigo Januario da Silva
 * @version 1.0.0
 */
public class HospitalsController implements Initializable {
	@FXML
	private ListView<String> hospitalsListView;

	@FXML
	private TextField nameTextField;

	@FXML
	private TextField addressTextField;

	@FXML
	private TextField faxTextField;

	@FXML
	private TextField phoneTextField;

	@FXML
	private TextField emailTextField;

	@FXML
	private TextField ratingTextField;

	@FXML
	private TextField findByLastNameTextField;

	@FXML
	private Button deleteButton;

	@FXML
	private Button updateButton;

	@FXML
	private Button addButton;

	@FXML
	private Button findByLastNameButton;

	@FXML
	private Button browseAllButton;

	public HospitalsController() {
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
}
