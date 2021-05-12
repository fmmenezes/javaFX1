package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import gui.util.Alerts;
import gui.util.Constraints;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.util.Callback;
import model.entities.Person;

public class ViewController implements Initializable {

	@FXML
	private TextField txtFirstNumber;

	@FXML
	private TextField txtSecondNumber;

	@FXML
	private Label lblResult;

	@FXML
	private Button btnSum;

	@FXML
	private ComboBox<Person> comboBoxPerson;

	private ObservableList<Person> obslist;
	
	@FXML
	private Button btnAll;

	public void onBtSumAction() {

		try {

			Locale.setDefault(Locale.US);

			double num1 = Double.parseDouble(txtFirstNumber.getText());
			double num2 = Double.parseDouble(txtSecondNumber.getText());
			double sum = num1 + num2;

			lblResult.setText(String.format("%.2f", sum));

		} catch (NumberFormatException e) {
			Alerts.showAlert("Error", "Parse error", e.getMessage(), AlertType.ERROR);
		}

	}
	
	@FXML
	public void onComboBoxPersonAction() {
		Person person = comboBoxPerson.getSelectionModel().getSelectedItem();
		System.out.println(person);
		
	}
	
	@FXML
	public void onBtAllAction() {
		for (Person person : comboBoxPerson.getItems()) {
			System.out.println(person);
		}
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		Constraints.setTextFieldDouble(txtFirstNumber);
		Constraints.setTextFieldMaxLength(txtFirstNumber, 10);
		Constraints.setTextFieldDouble(txtSecondNumber);
		Constraints.setTextFieldMaxLength(txtSecondNumber, 10);

		List<Person> list = new ArrayList<>();
		list.add(new Person(1, "Branca", "branca@dogmail.com"));
		list.add(new Person(2, "Uli", "uli@dogmail.com"));
		list.add(new Person(3, "Jin", "jin@dgomail.com"));

		obslist = FXCollections.observableArrayList(list);
		comboBoxPerson.setItems(obslist);

		Callback<ListView<Person>, ListCell<Person>> factory = lv -> new ListCell<Person>() {
			@Override
			protected void updateItem(Person item, boolean empty) {
				super.updateItem(item, empty);
				setText(empty ? "" : item.getName());
			}
		};
		
		comboBoxPerson.setCellFactory(factory);
		comboBoxPerson.setButtonCell(factory.call(null));

	}

}
