package application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.AppointmentType;
import application.Sex;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * @author Rodrigo Januario da Silva
 * @version 1.0.0
 */
public class DoctorOfficeController implements Initializable {
	// Toggle group for working with the sex radio buttons.
	@FXML
	private ToggleGroup sexToggleGroup;
	
	// Male radio button..
	@FXML
	private RadioButton sexMale;

	// Female radio button.
	@FXML
	private RadioButton sexFemale;
	
	// Regular appointment check box.
	@FXML
	private CheckBox appointmentRegular;
	
	// Exam appointment.
	@FXML
	private CheckBox appointmentExam;
	
	// Exam type.
	@FXML
	private ListView<String> examTypeListView;
	
	@FXML
	private Button submitButton;
	
	// The user selected values.
	private Sex selectedSex;
	private AppointmentType selectedRegular;
	private AppointmentType selectedExam;
	private String selectedExamType;
	private ObservableList<String> exams = FXCollections.observableArrayList();

	public Sex getSelectedSex() {
		return selectedSex;
	}
	
	public AppointmentType getSelectedRegular() {
		return selectedRegular;
	}

	public AppointmentType getSelectedExam() {
		return selectedExam;
	}
	
	public String getSelectedExamType() {
		return selectedExamType;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		sexMale.setUserData(Sex.MALE);
		sexFemale.setUserData(Sex.FEMALE);
		
		appointmentRegular.setUserData(AppointmentType.REGULAR);
		appointmentExam.setUserData(AppointmentType.EXAM);
		
		exams.add("X Ray");
		exams.add("MRI");
		exams.add("Ultrasound");
		exams.add("Echocardiogram");
		examTypeListView.setItems(exams);
		examTypeListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				selectedExamType = newValue;
			}
		});
	}

	@FXML
	private void sexRadioButtonSelected(ActionEvent e) {
		selectedSex = (Sex) sexToggleGroup.getSelectedToggle().getUserData();
	}
	
	@FXML
	private void handleCheckboxAction(ActionEvent e) {
		if (appointmentRegular.isSelected()) {
			selectedRegular = (AppointmentType) appointmentRegular.getUserData();
		} else {
			selectedRegular = null;
		}

		if (appointmentExam.isSelected()) {
			selectedExam = (AppointmentType) appointmentExam.getUserData();
			examTypeListView.setDisable(false);
		} else {
			selectedExam = null;
			selectedExamType = "";
			examTypeListView.setDisable(true);
		}
	}
	
	@FXML
	private void handleSubmit(ActionEvent e) {
		try {
			final Stage stage = new Stage();
			final FXMLLoader loader = new FXMLLoader(getClass().getResource("../DoctorOfficeViewer.fxml"));
			final Parent root = loader.load();
			final Scene scene = new Scene(root);
			stage.setScene(scene);
			final DoctorOfficeViewerController controller = loader.<DoctorOfficeViewerController>getController();
			controller.displaySelectedValues(selectedSex, selectedRegular, selectedExam, selectedExamType);
			stage.show();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
