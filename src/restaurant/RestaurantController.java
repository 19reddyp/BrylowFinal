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
		ArraySortedList<Double> reviewNum = new ArraySortedList<Double>();
		reviewNum.add(4.7);
		reviewNum.add(5.0);
		Restaurant temp = new Restaurant(0, "Jersey Mike's", "1234 Street", "(262) 262-2626", "jersey@mikes.com",
				"M-F 8am-9pm", "Sandwiches", "Casual", "$", menu, reviews, reviewNum,"restaurant/Jersey.png");
		observableRest.add(temp);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		list.setItems(observableRest);
		list.setCellFactory(restaurantList -> new RestaurantListCell());
	}
}
