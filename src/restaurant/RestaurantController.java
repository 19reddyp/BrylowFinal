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
		DatabaseClass data = new DatabaseClass();
		ArrayUnsortedList<Restaurant> temp;
		try {
			temp = data.getRestaraunts();
			for(int x=0; x<temp.size(); x++) {
				observableRest.add(temp.getNext());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		list.setItems(observableRest);
		list.setCellFactory(restaurantList -> new RestaurantListCell());
	}
}
