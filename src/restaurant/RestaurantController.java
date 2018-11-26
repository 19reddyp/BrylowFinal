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
		// add stuff from file to restList
		ArrayUnsortedList<Item> jmenu = new ArrayUnsortedList<Item>();
		ArrayUnsortedList<Review> jreviews = new ArrayUnsortedList<Review>();
		jmenu.add(new Item("#8",7.85));
		jmenu.add(new Item("#9",6.85));
		jreviews.add(new Review(5,"good food"));
		jreviews.add(new Review(5,"excellent experience"));
		Restaurant temp = new Restaurant(0, "JERSEY MIKE'S", "17550 W Bluemound Rd #80, Brookfield, WI 53045", "(262) 262-2626", "jersey@mikes.com",
				"M-F 8am-9pm", "Sandwiches", "Casual", "$", jmenu, jreviews,"restaurant/Jersey.png");
		ArrayUnsortedList<Item> fmenu = new ArrayUnsortedList<Item>();
		ArrayUnsortedList<Review> freviews = new ArrayUnsortedList<Review>();
		fmenu.add(new Item("Cheeseburger",9.95));
		fmenu.add(new Item("Hamburger",8.85));
		freviews.add(new Review(3,"good food"));
		freviews.add(new Review(5,"excellent experience"));
		Restaurant five = new Restaurant(1, "FIVE GUYS", "95 N. Moorland Rd, Brookfield, WI 53005", "(262) 786-2580", "five@guys.com",
				"M-F 8am-10pm", "Burgers", "Casual", "$", fmenu, freviews,"restaurant/Guys.png");
		observableRest.addAll(five,temp);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		list.setItems(observableRest);
		list.setCellFactory(restaurantList -> new RestaurantListCell());
	}
}
