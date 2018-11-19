package restaurant;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import models.ArraySortedList;
import models.Item;
import models.Restaurant;
import models.Review;

public class RestaurantListCell extends ListCell<Restaurant> {
	protected static int id = 0;
	@FXML
	protected Text name;
	@FXML
	protected Text address;
	@FXML
	protected Text phone;
	@FXML
	protected Text email;
	@FXML
	protected Text hours;
	@FXML
	protected Text cuisine;
	@FXML
	protected Text type;
	@FXML
	protected Text price;
	@FXML
	protected HBox box;
	@FXML
	protected String user;
	@FXML
	protected Text ratings;
	@FXML
	protected Restaurant restaurant;
	@FXML
	protected ActionEvent event;
	@FXML
	protected Button open;
	@FXML
	protected ImageView logo;

	public RestaurantListCell() {

	}

	@Override
	public void updateItem(Restaurant item, boolean empty) {
		super.updateItem(item, empty);
		if (empty || item == null)
			setGraphic(null);
		else {
			id++;
			name = new Text();
			address = new Text();
			phone = new Text();
			email = new Text();
			hours = new Text();
			cuisine = new Text();
			type = new Text();
			price = new Text();
			ratings = new Text();
			open = new Button();
			logo = new ImageView();
			HBox contact = new HBox(phone, email);
			HBox food = new HBox(cuisine, type);
			HBox pandr = new HBox(price, ratings);
			VBox info = new VBox(name, address, contact, hours, food, pandr);
			box = new HBox(logo, info, open);
			logo.setImage(new Image(item.getImageURL()));
			name.setText(item.getName());
			address.setText(item.getAddress());
			phone.setText(item.getPhone());
			email.setText(item.getEmail());
			hours.setText(item.getHours());
			cuisine.setText(item.getCuisine());
			type.setText(item.getType());
			price.setText(item.getPrice());
			ratings.setText(item.getRating());
			box.setMinWidth(600);
			setGraphic(box);
		}
	}

}
