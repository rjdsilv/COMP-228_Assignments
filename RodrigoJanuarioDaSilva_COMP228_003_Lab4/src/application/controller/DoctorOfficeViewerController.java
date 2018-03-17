package application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.AppointmentType;
import application.Sex;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

public class DoctorOfficeViewerController implements Initializable {
	@FXML
	private TextArea selectedValuesTextArea;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}
	
	public void displaySelectedValues(Sex sex, AppointmentType regular, AppointmentType exam, String examType) {
		String value = "";
		
		if (null != sex) {
			value += "Gender: " + sex + "\n";
		}
		
		if (null != regular || null != exam) {
			value += "Appointment Type: " + (null != regular ? regular + ", ": "") + (null != exam ? exam : "") + "\n";
		}
		
		if (null != examType && examType.trim().length() > 0) {
			value += "Exam Type: " + examType;			
		}
		
		selectedValuesTextArea.setText(value);
	}
}
