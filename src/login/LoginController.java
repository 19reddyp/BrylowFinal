package login;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import restaurant.RestaurantListCell;

public class LoginController implements Initializable{
	@FXML
	private TextField user;

	@FXML
	private PasswordField pass;

	@FXML
	private Button button;

	@FXML
	private Text fapa;

	@FXML
	private AnchorPane root;

	public LoginController() {
	}

	@FXML
	private void login() throws IOException {
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

	@FXML
	public void redirectNewAccount(ActionEvent event) throws IOException {
		FXMLLoader page = new FXMLLoader(getClass().getResource("../newAccount/NewAccount.fxml"));
		AnchorPane pane = page.load();
		root.getChildren().setAll(pane);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		pass.setOnKeyPressed(event -> {
			   if(event.getCode() == KeyCode.ENTER){
				   try {
					login();
				} catch (IOException e) {
					e.printStackTrace();
				}
			   }
			}); 
	}
}