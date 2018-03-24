package application.controller.data;

import application.AppointmentType;
import application.Sex;

public final class AppointmentData {
	private int selectedAge;
	private Sex selectedSex;
	private String selectedExamType;
	private String selectedOfficeLocation;
	private String selectedDescription;
	private AppointmentType selectedRegular;
	private AppointmentType selectedExam;

	public Sex getSelectedSex() {
		return selectedSex;
	}

	public void setSelectedSex(Sex selectedSex) {
		this.selectedSex = selectedSex;
	}

	public AppointmentType getSelectedRegular() {
		return selectedRegular;
	}

	public void setSelectedRegular(AppointmentType selectedRegular) {
		this.selectedRegular = selectedRegular;
	}

	public AppointmentType getSelectedExam() {
		return selectedExam;
	}

	public void setSelectedExam(AppointmentType selectedExam) {
		this.selectedExam = selectedExam;
	}

	public String getSelectedExamType() {
		return selectedExamType;
	}

	public void setSelectedExamType(String selectedExamType) {
		this.selectedExamType = selectedExamType;
	}

	public String getSelectedOfficeLocation() {
		return selectedOfficeLocation;
	}

	public void setSelectedOfficeLocation(String selectedOfficeLocation) {
		this.selectedOfficeLocation = selectedOfficeLocation;
	}

	public int getSelectedAge() {
		return selectedAge;
	}

	public void setSelectedAge(int selectedAge) {
		this.selectedAge = selectedAge;
	}

	public String getSelectedDescription() {
		return selectedDescription;
	}

	public void setSelectedDescription(String selectedDescription) {
		this.selectedDescription = selectedDescription;
	}
}
