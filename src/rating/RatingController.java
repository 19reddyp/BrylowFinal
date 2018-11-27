package rating;

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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
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
	@FXML
	private ChoiceBox rate;
	@FXML
	private TextArea explain;
	private String tempName;
	private ObservableList<Review> observableRest;
	private Restaurant restaurant;

	public RatingController() {
		observableRest = FXCollections.observableArrayList();
		// add stuff from file to restList
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		list.setItems(observableRest);
		list.setCellFactory(rating -> new RatingListCell());
	}

	public void addList(Restaurant temp) {
		restaurant = temp;
		name.setText(temp.getName());
		ArrayUnsortedList<Review> reviews = temp.getReview();
		for (int x = 0; x < reviews.size(); x++) {
			observableRest.add(reviews.getNext());
		}
	}

	public void writeReview() throws IOException {
		DatabaseClass database = new DatabaseClass();
		int restID = restaurant.getId();
		String xRating = rate.getValue().toString();
		int rating = Integer.parseInt(xRating);
		String text = explain.getText();
		database.addReview(restID, rating, text);
		
	}
}
