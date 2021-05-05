package gui;

import java.util.Locale;

import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ViewController {

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

}
