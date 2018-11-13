package login;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginController {
	@FXML
	// The reference of inputText will be injected by the FXML loader
	private TextField user;

	// The reference of outputText will be injected by the FXML loader
	@FXML
	private PasswordField pass;

	@FXML
	// The reference of inputText will be injected by the FXML loader
	private Button button;

	@FXML
	// The reference of inputText will be injected by the FXML loader
	private Text fapa;

	@FXML
	// The reference of inputText will be injected by the FXML loader
	private AnchorPane root;

	// Add a public no-args constructor
	public LoginController() {
	}

	@FXML
	private void login(ActionEvent event) throws IOException {
		File temp = new File("logindata.txt");
		Scanner scanner = new Scanner(temp);
		while (scanner.hasNext()) {
			if (scanner.next().equals(user.getText()) && scanner.next().equals(pass.getText())) {
				AnchorPane pane = FXMLLoader.load(getClass().getClassLoader().getResource("Home.fxml"));
				root.getChildren().setAll(pane);
			} else {
				fapa.setText("Invalid Email/Password");
			}
		}

	}
}