package gui;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import gui.util.Alerts;
import gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ViewController implements Initializable {

	@FXML
	private TextField txtFirstNumber;

	@FXML
	private TextField txtSecondNumber;

	@FXML
	private Label lblResult;

	@FXML
	private Button btnSum;

	public void onBtSumAction() {
		
		try {
			
			Locale.setDefault(Locale.US);

			double num1 = Double.parseDouble(txtFirstNumber.getText());
			double num2 = Double.parseDouble(txtSecondNumber.getText());
			double sum = num1 + num2;

			lblResult.setText(String.format("%.2f", sum));
			
		} catch(NumberFormatException e) {
			Alerts.showAlert("Error", "Parse error", e.getMessage(), AlertType.ERROR);
		}

	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		Constraints.setTextFieldDouble(txtFirstNumber);
		Constraints.setTextFieldMaxLength(txtFirstNumber, 10);
		Constraints.setTextFieldDouble(txtSecondNumber);
		Constraints.setTextFieldMaxLength(txtSecondNumber, 10);
		
	}

}
