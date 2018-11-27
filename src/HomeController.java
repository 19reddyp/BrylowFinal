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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import models.ArrayUnsortedList;
import models.Restaurant;
import restaurant.RestaurantController;

public class HomeController {

	@FXML
	private ImageView rest;

	@FXML
	private AnchorPane root;

	@FXML
	private TextField term;
	@FXML
	public void home(ActionEvent event) throws IOException{
		FXMLLoader page = new FXMLLoader(getClass().getResource("Home.fxml"));
		AnchorPane pane = page.load();
		root.getChildren().setAll(pane);
	}
	@FXML
	private void redirect(ActionEvent event) throws IOException {
		FXMLLoader page = new FXMLLoader(getClass().getResource("restaurant/Restaurants.fxml"));
		AnchorPane pane = page.load();
		DatabaseClass data = new DatabaseClass();
		ArrayUnsortedList<Restaurant> rest = data.getRestaraunts();
		RestaurantController controller = page.getController();
		controller.setList(rest);
		root.getChildren().setAll(pane);
	}

	@FXML
	public void search() throws IOException {
		String searchTerm = term.getText();
		DatabaseClass data = new DatabaseClass();
		ArrayUnsortedList<Restaurant> restaurants = data.getRestaraunts();
		ArrayUnsortedList<Restaurant> fit = new ArrayUnsortedList<Restaurant>();
		for (int x = 0; x < restaurants.size(); x++) {
			Restaurant temp = restaurants.getNext();
			if(temp.getName().toLowerCase().contains(searchTerm.toLowerCase())) {
				fit.add(temp);
			}
		}
		FXMLLoader page = new FXMLLoader(getClass().getResource("restaurant/Restaurants.fxml"));
		AnchorPane pane = page.load();
		RestaurantController controller = page.getController();
		controller.setList(fit);
		root.getChildren().setAll(pane);
	}
}
