package rating;

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
import javafx.scene.text.Text;
import javafx.util.Callback;
import models.ArraySortedList;
import models.ArrayUnsortedList;
import models.Item;
import models.Restaurant;
import models.Review;

public class RatingController implements Initializable {
	@FXML
	private ListView<Review> list;
	@FXML
	private AnchorPane root;
	@FXML
	private Text name;
	private String tempName;
	private ObservableList<Review> observableRest;

	public RatingController() {
		observableRest = FXCollections.observableArrayList();
		// add stuff from file to restList
		ArrayUnsortedList<Item> jmenu = new ArrayUnsortedList<Item>();
		ArrayUnsortedList<Review> jreviews = new ArrayUnsortedList<Review>();
		jmenu.add(new Item("#8", 7.85));
		jmenu.add(new Item("#9", 6.85));
		jreviews.add(new Review(4, "good food"));
		jreviews.add(new Review(3, "excellent experience"));
		Restaurant temp = new Restaurant(0, "JERSEY MIKE'S", "17550 W Bluemound Rd #80, Brookfield, WI 53045",
				"(262) 262-2626", "jersey@mikes.com", "M-F 8am-9pm", "Sandwiches", "Casual", "$", jmenu, jreviews,
				"restaurant/Jersey.png");
		ArrayUnsortedList<Review> temp2 = temp.getReview();
		for (int x = 0; x < temp2.size(); x++) {
			observableRest.add(temp2.getNext());
		}
		tempName = temp.getName();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		list.setItems(observableRest);
		list.setCellFactory(rating -> new RatingListCell());
		this.setName(tempName);
	}

	public void setName(String x) {
		name.setText(x);
	}
	public void writeReview() {
		
	}
}
