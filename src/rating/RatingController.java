package rating;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import database.DatabaseClass;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;
import models.ArraySortedList;
import models.ArrayUnsortedList;
import models.Item;
import models.Restaurant;
import models.Review;
import restaurant.RestaurantController;

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
	@FXML
	private Button submit;
	@FXML
	private ImageView overall;
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
	@FXML
	public void home(ActionEvent event) throws IOException{
		FXMLLoader page = new FXMLLoader(getClass().getResource("../Home.fxml"));
		AnchorPane pane = page.load();
		root.getChildren().setAll(pane);
	}
	@FXML
	private void redirect(ActionEvent event) throws IOException {
		FXMLLoader page = new FXMLLoader(getClass().getResource("../restaurant/Restaurants.fxml"));
		AnchorPane pane = page.load();
		DatabaseClass data = new DatabaseClass();
		ArrayUnsortedList<Restaurant> rest = data.getRestaraunts();
		RestaurantController controller = page.getController();
		controller.setList(rest);
		root.getChildren().setAll(pane);
	}
	public void addList(Restaurant temp) {
		restaurant = temp;
		name.setText(temp.getName());
		if (temp.getRating() == 1)
			overall.setImage(new Image("rating/one.png"));
		else if (temp.getRating() == 2)
			overall.setImage(new Image("rating/two.png"));
		else if (temp.getRating() == 3)
			overall.setImage(new Image("rating/three.png"));
		else if (temp.getRating() == 4)
			overall.setImage(new Image("rating/four.png"));
		else
			overall.setImage(new Image("rating/five.png"));
		ArrayUnsortedList<Review> reviews = temp.getReview();
		for (int x = 0; x < reviews.size(); x++) {
			observableRest.add(reviews.getNext());
		}
		submit.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Stage temporary = (Stage) ((Node) event.getSource()).getScene().getWindow();
				temporary.close();
				Parent pane = null;
				try {
					DatabaseClass database = new DatabaseClass();
					int restID = restaurant.getId();
					String xRating = rate.getValue().toString();
					int rating = Integer.parseInt(xRating);
					String text = explain.getText();
					database.addReview(restID, rating, text);
					FXMLLoader loader = new FXMLLoader(getClass().getResource("../rating/Rating.fxml"));
					pane = loader.load();
					DatabaseClass database2 = new DatabaseClass();
					ArrayUnsortedList<Restaurant> newList = database2.getRestaraunts();
					for (int x = 0; x < newList.size(); x++) {
						Restaurant temp = newList.getNext();
						if (restaurant.getName().equals(temp.getName())) {
							RatingController ratings = loader.getController();
							ratings.addList(temp);
						}
					}

				} catch (IOException e) {

				}
				Scene table = new Scene(pane);
				Stage x = new Stage();
				x.setScene(table);
				x.show();
			}
		});
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
