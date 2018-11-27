package restaurant;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import database.DatabaseClass;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;
import models.ArraySortedList;
import models.ArrayUnsortedList;
import models.Item;
import models.Restaurant;
import models.Review;

public class RestaurantController implements Initializable {
	@FXML
	private ListView<Restaurant> list;
	@FXML
	private AnchorPane root;
	private ObservableList<Restaurant> observableRest;

	public RestaurantController() {
		observableRest = FXCollections.observableArrayList();

	}

	public void setList(ArrayUnsortedList<Restaurant> temp) throws IOException {
		for (int x = 0; x < temp.size(); x++) {
			observableRest.add(temp.getNext());
		}
	}
	@FXML
	public void home(ActionEvent event) throws IOException{
		FXMLLoader page = new FXMLLoader(getClass().getResource("../Home.fxml"));
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
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		list.setItems(observableRest);
		list.setCellFactory(restaurantList -> new RestaurantListCell());
	}
}