package restaurant;
import java.net.URL;
import java.util.*;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.ComboBoxListCell;
import models.Restaurant;
import javafx.collections.ListChangeListener;
import javafx.collections.FXCollections;
public class RestaurantController implements Initializable{
	@FXML private ListView<String> listview;
	public RestaurantController() {
		
		//listview.setCellFactory(ComboBoxListCell.forListView(list));
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
//		listview = new ListView<String>();
		ObservableList<String> list = FXCollections.observableArrayList("Mark","Tom","Joe");
		listview.setItems(list);
	}
}
