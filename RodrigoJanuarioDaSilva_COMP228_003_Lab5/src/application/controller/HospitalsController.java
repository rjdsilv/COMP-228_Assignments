package application.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import dao.HospitalDao;
import dao.HospitalDaoImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.Font;
import model.Hospital;
import model.exception.ObjectNotFoundException;

/**
 * Controller class for the hospitals application.
 * 
 * @author Rodrigo Januario da Silva
 * @version 1.0.0
 */
public class HospitalsController implements Initializable {
	private static final String EMPTY_STR = "";

	@FXML private ListView<Hospital> hospitalsListView;
	@FXML private TextField nameTextField;
	@FXML private TextField addressTextField;
	@FXML private TextField faxTextField;
	@FXML private TextField phoneTextField;
	@FXML private TextField emailTextField;
	@FXML private TextField ratingTextField;
	@FXML private TextField findByLastNameTextField;
	@FXML private Button deleteButton;
	@FXML private Button updateButton;
	@FXML private Button addButton;
	@FXML private Button findByLastNameButton;
	@FXML private Button browseAllButton;

	// List view data handlers.
	private Hospital selectedHospital;
	private ObservableList<Hospital> hospitals = FXCollections.observableArrayList();

	// DAO for accessing the database.
	private HospitalDao hospitalDao = HospitalDaoImpl.instance();

	/**
	 * Controller initialization.
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setUpListView();
	}

	/**
	 * Method to handle the click event on the browse all button.
	 */
	@FXML
	private void browseAllClick() {
		browseAll();
	}

	/**
	 * Method to handle the click event on the find by last name button.
	 */
	@FXML
	private void findByLastNameClick() {
		browseByLastName();
	}

	/**
	 * Method to handle the click event on the delete entry button.
	 */
	@FXML
	private void deleteEntryClick() {
		if (null == selectedHospital) {
			showWarningAlert("Please, select a Hospital before deleting it!");
		} else {
			if (hospitalDao.delete(selectedHospital)) {
				showInformationAlert(selectedHospital.getName() + " successfully deleted from the system.");
				browseAll();
			}
		}
	}

	/**
	 * Method to handle the click event on the delete entry button.
	 */
	@FXML
	private void updateEntryClick() {
		if (null == selectedHospital) {
			showWarningAlert("Please, select a Hospital before updating it!");
		} else {
			if (isFormValid()) {
				final Hospital hospital = selectedHospital;
				hospital.setName(nameTextField.getText());
				hospital.setAddress(addressTextField.getText());
				hospital.setFaxNumber(faxTextField.getText());
				hospital.setPhoneNumber(phoneTextField.getText());
				hospital.setEmail(emailTextField.getText());
				hospital.setRating(Integer.parseInt(ratingTextField.getText()));
				hospitalDao.update(hospital);
				showInformationAlert(hospital.getName() + " successfully updated in the system.");
				browseAll();
			}
		}
	}

	/**
	 * Method to handle the click event on the insert entry button.
	 */
	@FXML
	private void addEntryClick() {
		if (isFormValid()) {
			final Hospital hospital = new Hospital();
			hospital.setName(nameTextField.getText());
			hospital.setAddress(addressTextField.getText());
			hospital.setFaxNumber(faxTextField.getText());
			hospital.setPhoneNumber(phoneTextField.getText());
			hospital.setEmail(emailTextField.getText());
			hospital.setRating(Integer.parseInt(ratingTextField.getText()));
			if (null != hospitalDao.insert(hospital)) {
				showInformationAlert(hospital.getName() + " successfully added to the system.");
				browseAll();
			} else {
				showWarningAlert(hospital.getName() + " cannot be added, as it already exists in the system.");
			}
		}
	}

	/**
	 * Method created to validate all the forms fields.
	 * 
	 * @return true if all the form fields are valid. false otherwise.
	 */
	private boolean isFormValid() {
		boolean isFormValid = true;
		String errorMessage = "";

		if (isNameInvalid()) {
			isFormValid = false;
			errorMessage += String.format("Please, fill the Hospital's Name before proceeding.%n");
		}

		if (isAddressInvalid()) {
			isFormValid = false;
			errorMessage += String.format("Please, fill the Hospital's Address before proceeding.%n");
		}

		if (isFaxInvalid()) {
			isFormValid = false;
			errorMessage += String.format("Please, fill the Hospital's Fax Number formated as NNN-NNNN before proceeding.%n");
		}

		if (isPhoneInvalid()) {
			isFormValid = false;
			errorMessage += String.format("Please, fill the Hospital's Phone Number formated as NNN-NNNN before proceeding.%n");
		}

		if (isEmailInvalid()) {
			isFormValid = false;
			errorMessage += String.format("Please, fill the Hospital's Email before proceeding.%n");
		}

		if (isRatingInvalid()) {
			isFormValid = false;
			errorMessage += String.format("Please, fill the Hospital's Rating from 0 to 10 before proceeding.%n");
		}

		if (!isFormValid) {
			showWarningAlert(errorMessage);
		}

		return isFormValid;
	}

	/**
	 * Method to validate the hospital's name.
	 * 
	 * @return true if the name is invalid. false otherwise.
	 */
	private boolean isNameInvalid() {
		return null == nameTextField.getText() || EMPTY_STR.equals(nameTextField.getText());
	}

	/**
	 * Method to validate the hospital's address.
	 * 
	 * @return true if the address is invalid. false otherwise.
	 */
	private boolean isAddressInvalid() {
		return null == addressTextField.getText() || EMPTY_STR.equals(addressTextField.getText());
	}

	/**
	 * Method to validate the hospital's fax.
	 * 
	 * @return true if the fax is invalid. false otherwise.
	 */
	private boolean isFaxInvalid() {
		return null == faxTextField.getText() || EMPTY_STR.equals(faxTextField.getText());
	}

	/**
	 * Method to validate the hospital's phone.
	 * 
	 * @return true if the phone is invalid. false otherwise.
	 */
	private boolean isPhoneInvalid() {
		return null == phoneTextField.getText() || EMPTY_STR.equals(phoneTextField.getText());
	}

	/**
	 * Method to validate the hospital's email.
	 * 
	 * @return true if the email is invalid. false otherwise.
	 */
	private boolean isEmailInvalid() {
		return null == emailTextField.getText() || EMPTY_STR.equals(emailTextField.getText());
	}

	/**
	 * Method to validate the hospital's rating.
	 * 
	 * @return true if the rating is invalid. false otherwise.
	 */
	private boolean isRatingInvalid() {
		try {
			String rating = ratingTextField.getText();
			return null == rating || 
					EMPTY_STR.equals(rating) ||
					Integer.parseInt(rating) < 0 ||
					Integer.parseInt(rating) > 10;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Method created to set up the window list view.
	 */
	private void setUpListView() {
		browseAll();
		setUpListViewCellFactory();
		setUpOnSelectEvent();
	}

	/**
	 * Method created to browse all the hospitals from the database.
	 */
	private void browseAll() {
		setListViewItems(hospitalDao.findAll());
	}

	/**
	 * Method created to browse all hospitals by last name. If no hospitals are found with the given last name,
	 * a message will be displayed and the hospital list will not be changed.
	 */
	private void browseByLastName() {
		if (null == findByLastNameTextField.getText() || EMPTY_STR.equals(findByLastNameTextField.getText().trim())) {
			showWarningAlert("Please, enter the last name to be found.");
		} else {
			try {
				setListViewItems(hospitalDao.findByLastName(findByLastNameTextField.getText()));
			} catch (ObjectNotFoundException e) {
				showWarningAlert(e.getMessage());
			}
		}
	}

	/**
	 * Method created to set the list view items with the given list of items.
	 * 
	 * @param items The items to be set.
	 */
	private void setListViewItems(List<Hospital> items) {
		clearSelection();
		hospitals.clear();
		hospitals.addAll(items);
		hospitalsListView.setItems(hospitals);
	}

	/**
	 * Method created to clear the selection when the list view items are going to be set with new values.
	 */
	private void clearSelection() {
		selectedHospital = null;
		nameTextField.setText("");
		addressTextField.setText("");
		faxTextField.setText("");
		phoneTextField.setText("");
		emailTextField.setText("");
		ratingTextField.setText("");
		findByLastNameTextField.setText("");
	}

	/**
	 * Method to show a warning alert window with the given text.
	 * 
	 * @param text The text to be shown.
	 */
	private void showWarningAlert(String text) {
		final Alert alert = new Alert(AlertType.WARNING, text, ButtonType.OK);
		alert.showAndWait();
	}

	/**
	 * Method to show a information alert window with the given text.
	 * 
	 * @param text The text to be shown.
	 */
	private void showInformationAlert(String text) {
		final Alert alert = new Alert(AlertType.INFORMATION, text, ButtonType.OK);
		alert.showAndWait();
	}

	/**
	 * Sets the list view cell factory to deal with hospitals instead of strings.
	 */
	private void setUpListViewCellFactory() {
		hospitalsListView.setCellFactory(param -> new ListCell<Hospital>() {
			@Override
		    protected void updateItem(Hospital hospital, boolean empty) {
		        super.updateItem(hospital, empty);

		        if (empty) {
		            setText("");
		        } else {
		            setText(hospital.getName());
		        }
	            setFont(Font.font("Calibri", 18));
		    }
		});
	}

	/**
	 * Method created to set up the select event for the list view.
	 */
	private void setUpOnSelectEvent() {
		hospitalsListView.getSelectionModel().selectedItemProperty().addListener(
			(observable, oldValue, newValue) -> {
				selectedHospital = newValue;
				fillTextBoxes();
			}
		);
	}

	/**
	 * Method created to fill all the window text boxes with the selected hospital data.
	 */
	private void fillTextBoxes() {
		if (null != selectedHospital) {
			nameTextField.setText(selectedHospital.getName());
			addressTextField.setText(selectedHospital.getAddress());
			faxTextField.setText(selectedHospital.getFaxNumber());
			phoneTextField.setText(selectedHospital.getPhoneNumber());
			emailTextField.setText(selectedHospital.getEmail());
			ratingTextField.setText("" + selectedHospital.getRating());
		}
	}
}
