package application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.AppointmentType;
import application.Sex;
import application.controller.data.AppointmentData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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

	// The age slider.
	@FXML
	private Slider ageSlider;

	// The age text field.
	@FXML
	private TextField ageTextField;

	// Regular appointment check box.
	@FXML
	private CheckBox appointmentRegular;

	// Exam appointment.
	@FXML
	private CheckBox appointmentExam;

	// Exam type.
	@FXML
	private ListView<String> examTypeListView;

	// The office location combo box.
	@FXML
	private ComboBox<String> officeLocationComboBox;

	// The description text area.
	@FXML
	private TextArea descriptionTextArea;

	// The submit button.
	@FXML
	private Button submitButton;
	

	// Lists
	private ObservableList<String> exams = FXCollections.observableArrayList();
	private ObservableList<String> locations = FXCollections.observableArrayList();

	// The user selected values.
	private AppointmentData data = new AppointmentData();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		sexMale.setUserData(Sex.MALE);
		sexFemale.setUserData(Sex.FEMALE);

		appointmentRegular.setUserData(AppointmentType.REGULAR);
		appointmentExam.setUserData(AppointmentType.EXAM);

		// Exam types.
		exams.add("X Ray");
		exams.add("MRI");
		exams.add("Ultrasound");
		exams.add("Echocardiogram");
		examTypeListView.setItems(exams);
		examTypeListView.getSelectionModel().selectedItemProperty().addListener(
			(observable, oldValue, newValue) -> data.setSelectedExamType(newValue)
		);

		// Office locations.
		locations.add("1398 Danforth Road");
		locations.add("5 Bloor Street");
		locations.add("542 Bay Street");
		locations.add("1200 Finch Avenue East");
		locations.add("540 Burnhamthorpe Road West");
		officeLocationComboBox.setItems(locations);
		officeLocationComboBox.getSelectionModel().selectedItemProperty().addListener(
			(observable, oldValue, newValue) -> data.setSelectedOfficeLocation(newValue)
		);

		ageSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
				ageSlider.setValue(newValue.intValue());
				ageTextField.setText("" + newValue.intValue());
				data.setSelectedAge(newValue.intValue());
			}
		);
	}

	@FXML
	private void sexRadioButtonSelected(ActionEvent e) {
		data.setSelectedSex((Sex) sexToggleGroup.getSelectedToggle().getUserData());
	}

	@FXML
	private void handleCheckboxAction(ActionEvent e) {
		if (appointmentRegular.isSelected()) {
			data.setSelectedRegular((AppointmentType) appointmentRegular.getUserData());
		} else {
			data.setSelectedRegular(null);
		}

		if (appointmentExam.isSelected()) {
			data.setSelectedExam((AppointmentType) appointmentExam.getUserData());
			examTypeListView.setDisable(false);
		} else {
			data.setSelectedExam(null);
			data.setSelectedExamType("");
			examTypeListView.setDisable(true);
		}
	}

	@FXML
	private void handleSubmit(ActionEvent e) {
		try {
			if (validateForm()) {
				data.setSelectedDescription(descriptionTextArea.getText());
				final Stage stage = new Stage();
				final FXMLLoader loader = new FXMLLoader(getClass().getResource("../DoctorOfficeViewer.fxml"));
				final Parent root = loader.load();
				final Scene scene = new Scene(root);
				stage.setScene(scene);
				stage.setTitle("Appointment Details");
				final DoctorOfficeViewerController controller = loader.<DoctorOfficeViewerController>getController();
				controller.displaySelectedValues(data);
				stage.show();
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	private boolean validateForm() {
		final Alert alert;
		String text = "";
		boolean isValid = false;

		if (null == data.getSelectedSex()) {
			text = "Please, select the patient gender!";
		} else if(data.getSelectedAge() < 14) {
			text = "Please, select the patient's age!";
		} else if (null == data.getSelectedExam() && null == data.getSelectedRegular()) {
			text = "Please, select at least one appointment type!";
		} else if ((null == data.getSelectedExamType() || "".equals(data.getSelectedExamType())) && null != data.getSelectedExam()) {
			text = "Please, select the exam the patient is doing!";
		} else if(null == data.getSelectedOfficeLocation()) {
			text = "Please, select the office you want to be attended!";
		} else {
			isValid = true;
		}

		if (!isValid) {
			alert = new Alert(AlertType.WARNING, text, ButtonType.OK);
			alert.showAndWait();
		}

		return isValid;
	}
}
