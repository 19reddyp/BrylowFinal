import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import database.DatabaseClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import login.SignOutConfirmationController;
import models.ArrayUnsortedList;
import models.Restaurant;
import restaurant.RestaurantController;

public class HomeController implements Initializable{

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
	@FXML
	public void redirectLogOut(ActionEvent event) throws IOException {
		FXMLLoader page = new FXMLLoader(getClass().getResource("login/SignOutConfirmation.fxml"));
		AnchorPane pane = page.load();
		SignOutConfirmationController controller = page.getController();
		Stage temp = (Stage) ((Node) event.getSource()).getScene().getWindow();
		controller.setStage(temp);
		Scene scene = new Scene(pane);
		Stage temp2 = new Stage();
		temp2.setTitle("Restaurant Advisor");
		temp2.setScene(scene);
		temp2.show();
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		term.setOnKeyPressed(event -> {
			   if(event.getCode() == KeyCode.ENTER){
				   try {
					search();
				} catch (IOException e) {
					e.printStackTrace();
				}
			   }
			}); 
	}
}
