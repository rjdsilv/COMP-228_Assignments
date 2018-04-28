package application;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import dao.ToolDao;
import dao.ToolDaoImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import model.Tool;

/**
 * Controller class for the tools application.
 * 
 * @author Rodrigo Januario da Silva
 * @version 1.0.0
 */

public class ToolsController implements Initializable {
	private static final String EMPTY_STR = "";

	@FXML private ListView<Tool> toolsListView;
	@FXML private TextField brandTextField;
	@FXML private TextField typeTextField;
	@FXML private TextField categoryTextField;
	@FXML private TextField priceTextField;
	@FXML private Button deleteButton;
	@FXML private Button updateButton;
	@FXML private Button browseAllButton;

	// List view data handlers.
	private Tool selectedTool;
	private ObservableList<Tool> tools = FXCollections.observableArrayList();

	// DAO for accessing the database.
	private ToolDao toolDao = ToolDaoImpl.instance();

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
	 * Method to handle the click event on the delete entry button.
	 */
	@FXML
	private void deleteEntryClick() {
		if (null == selectedTool) {
			showWarningAlert("Please, select a Tool before deleting it!");
		} else {
			if (toolDao.delete(selectedTool)) {
				showInformationAlert(selectedTool.getBrand() + " - " + selectedTool.getType() + " successfully deleted from the system.");
				browseAll();
			}
		}
	}

	/**
	 * Method to handle the click event on the delete entry button.
	 */
	@FXML
	private void updateEntryClick() {
		if (null == selectedTool) {
			showWarningAlert("Please, select a Tool before updating it!");
		} else {
			if (isFormValid()) {
				final Tool tool = selectedTool;
				tool.setBrand(brandTextField.getText());
				tool.setType(typeTextField.getText());
				tool.setCategory(categoryTextField.getText());
				tool.setPrice(Integer.valueOf(priceTextField.getText()));
				toolDao.update(tool);
				showInformationAlert(tool.getBrand() + " - " + tool.getType() + " successfully updated in the system.");
				browseAll();
			}
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
		setListViewItems(toolDao.findAll());
	}

	/**
	 * Method created to set the list view items with the given list of items.
	 * 
	 * @param items The items to be set.
	 */
	private void setListViewItems(List<Tool> items) {
		clearSelection();
		tools.clear();
		tools.addAll(items);
		toolsListView.setItems(tools);
	}

	/**
	 * Method created to clear the selection when the list view items are going to be set with new values.
	 */
	private void clearSelection() {
		selectedTool = null;
		brandTextField.setText("");
		typeTextField.setText("");
		categoryTextField.setText("");
		priceTextField.setText("");
	}
	
	/**
	 * Sets the list view cell factory to deal with hospitals instead of strings.
	 */
	private void setUpListViewCellFactory() {
		toolsListView.setCellFactory(param -> new ListCell<Tool>() {
			@Override
		    protected void updateItem(Tool tool, boolean empty) {
		        super.updateItem(tool, empty);

		        if (empty) {
		            setText("");
		        } else {
		            setText(tool.getBrand() + " - " + tool.getType());
		        }
		    }
		});
	}

	/**
	 * Method created to set up the select event for the list view.
	 */
	private void setUpOnSelectEvent() {
		toolsListView.getSelectionModel().selectedItemProperty().addListener(
			(observable, oldValue, newValue) -> {
				selectedTool = newValue;
				fillTextBoxes();
			}
		);
	}

	/**
	 * Method created to fill all the window text boxes with the selected hospital data.
	 */
	private void fillTextBoxes() {
		if (null != selectedTool) {
			brandTextField.setText(selectedTool.getBrand());
			typeTextField.setText(selectedTool.getType());
			categoryTextField.setText(selectedTool.getCategory());
			priceTextField.setText(Integer.toString(selectedTool.getPrice()));
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

		if (isBrandInvalid()) {
			isFormValid = false;
			errorMessage += String.format("Please, fill the Tool's Brand before proceeding.%n");
		}

		if (isTypeInvalid()) {
			isFormValid = false;
			errorMessage += String.format("Please, fill the Tool's Type before proceeding.%n");
		}

		if (isCategoryInvalid()) {
			isFormValid = false;
			errorMessage += String.format("Please, fill the Tool's Category before proceeding.%n");
		}

		if (isPriceInvalid()) {
			isFormValid = false;
			errorMessage += String.format("Please, fill the Tool's Price must be filled and be a number.%n");
		}

		if (!isFormValid) {
			showWarningAlert(errorMessage);
		}

		return isFormValid;
	}

	/**
	 * Method to validate the tool's brand.
	 * 
	 * @return true if the brand is invalid. false otherwise.
	 */
	private boolean isBrandInvalid() {
		return null == brandTextField.getText() || EMPTY_STR.equals(brandTextField.getText());
	}

	/**
	 * Method to validate the tool's type.
	 * 
	 * @return true if the type is invalid. false otherwise.
	 */
	private boolean isTypeInvalid() {
		return null == typeTextField.getText() || EMPTY_STR.equals(typeTextField.getText());
	}

	/**
	 * Method to validate the tool's category.
	 * 
	 * @return true if the category is invalid. false otherwise.
	 */
	private boolean isCategoryInvalid() {
		return null == categoryTextField.getText() || EMPTY_STR.equals(categoryTextField.getText());
	}

	/**
	 * Method to validate the tool's price.
	 * 
	 * @return true if the price is invalid. false otherwise.
	 */
	private boolean isPriceInvalid() {
		try {
			Integer.parseInt(priceTextField.getText());
			return null == priceTextField.getText() || EMPTY_STR.equals(priceTextField.getText());
		} catch (NumberFormatException nfe) {
			return true;
		}
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
}
