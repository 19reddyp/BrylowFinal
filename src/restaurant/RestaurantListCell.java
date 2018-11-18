package restaurant;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
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
	protected Text name;
	protected Text address;
	protected Text phone;
	protected Text email;
	protected Text hours;
	protected Text cuisine;
	protected Text type;
	protected Text price;
	protected HBox box;
	protected String user;
	protected Text ratings;
	protected Restaurant restaurant;
	protected ActionEvent event;
	protected Button open;

	public RestaurantListCell() {
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
		HBox contact = new HBox(phone, email);
		HBox food = new HBox(cuisine, type);
		HBox pandr = new HBox(price, ratings);
		VBox info = new VBox(name, address, contact, hours, food, pandr);
		box = new HBox(info,open);
	}

	public void updateItem(Restaurant item, boolean empty) {
		super.updateItem(item, empty);
		if(empty) setGraphic(null);
		else {
		name.setText(item.getName());
		address.setText(item.getAddress());
		phone.setText(item.getPhone());
		email.setText(item.getEmail());
		hours.setText(item.getHours());
		cuisine.setText(item.getCuisine());
		type.setText(item.getType());
		price.setText(item.getPrice());
		ratings.setText(item.getRating());
		setGraphic(box);
		}
	}

}
