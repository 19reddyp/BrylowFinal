package newAccount;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import database.DatabaseClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class NewAccountController {
	@FXML
	private TextField user;

	@FXML
	private PasswordField pass;

	@FXML
	private Button button;
	DatabaseClass database;
	@FXML
	private AnchorPane root;
	
	public NewAccountController() {
		database = new DatabaseClass();
	}
	@FXML
	private void createAccount(ActionEvent event) throws IOException {
		database.addNewAccount(user.getText(), pass.getText());
		AnchorPane pane = FXMLLoader.load(getClass().getClassLoader().getResource("Home.fxml"));
		root.getChildren().setAll(pane);
	}
}
