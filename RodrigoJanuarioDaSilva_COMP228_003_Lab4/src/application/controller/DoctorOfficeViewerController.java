package application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.controller.data.AppointmentData;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

public class DoctorOfficeViewerController implements Initializable {
	@FXML
	private TextArea selectedValuesTextArea;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}
	
	public void displaySelectedValues(AppointmentData data) {
		String value = "";

		if (null != data.getSelectedSex()) {
			value += "Patient Gender: " + data.getSelectedSex() + "\n";
		}

		if (data.getSelectedAge() >= 14) {
			value += "Patient Age: " + data.getSelectedAge() + "\n";
		}

		if (null != data.getSelectedExamType() || null != data.getSelectedExam()) {
			value += "Appointment Type: " + 
					(null != data.getSelectedRegular() ? data.getSelectedRegular() + ", ": "") + 
					(null != data.getSelectedExam() ? data.getSelectedExam() : "");
			
			if (value.endsWith(", ")) {
				value = value.substring(0, value.length() - 2);
			}
			value += "\n";
		}

		if (null != data.getSelectedExamType() && data.getSelectedExamType().trim().length() > 0) {
			value += "Exam Type: " + data.getSelectedExamType() + "\n";
		}

		if (null != data.getSelectedOfficeLocation() && data.getSelectedOfficeLocation().trim().length() > 0) {
			value += "Office Location: " + data.getSelectedOfficeLocation();
		}

		if (null != data.getSelectedDescription() && data.getSelectedDescription().trim().length() > 0) {
			value += "\n\nAppointmentDescription:\n\t" + data.getSelectedDescription() + "\n";
		}
		
		selectedValuesTextArea.setText(value);
	}
}
