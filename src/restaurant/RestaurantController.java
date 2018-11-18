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
import models.Restaurant;

public class RestaurantController {
	@FXML
	private ListView<Restaurant> list;
	@FXML
	private AnchorPane root;
	private ActionEvent event;
	private String user;

	public RestaurantController(String user, ActionEvent event) throws IOException {
		this.user = user;
		this.event = event;
		list = new ListView<Restaurant>();
		AnchorPane pane = FXMLLoader.load(getClass().getClassLoader().getResource("/restaurant/Restaurant.fxml"));
		root.getChildren().setAll(pane);
		ObservableList<Restaurant> list2 = FXCollections.observableArrayList();
		// add stuff from file to restList
		list.setItems(list2);
		list.setCellFactory(new Callback<ListView<Restaurant>, ListCell<Restaurant>>() {
			@Override
			public ListCell<Restaurant> call(ListView<Restaurant> listView) {
				return new RestaurantListCell();
			}
		});

	}
}
