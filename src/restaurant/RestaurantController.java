package restaurant;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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
		// add stuff from file to restList
		ArraySortedList<Item> menu = new ArraySortedList<Item>();
		ArraySortedList<Review> reviews = new ArraySortedList<Review>();
		menu.add(new Item("#8",7.85));
		menu.add(new Item("#9",6.85));
		reviews.add(new Review(5,"good food"));
		reviews.add(new Review(5,"excellent experience"));
		Restaurant temp = new Restaurant(0, "JERSEY MIKE'S", "17550 W Bluemound Rd #80, Brookfield, WI 53045", "(262) 262-2626", "jersey@mikes.com",
				"M-F 8am-9pm", "Sandwiches", "Casual", "$", menu, reviews,"restaurant/Jersey.png");
		observableRest.add(temp);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		list.setItems(observableRest);
		list.setCellFactory(restaurantList -> new RestaurantListCell());
	}
}
