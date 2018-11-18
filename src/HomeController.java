import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class HomeController {

	@FXML
	private ImageView rest;

	@FXML
	private AnchorPane root;

	@FXML
	private void redirect(ActionEvent event) throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getClassLoader().getResource("restaurant/Restaurants.fxml"));
		root.getChildren().setAll(pane);
	}
}
