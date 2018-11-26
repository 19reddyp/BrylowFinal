package restaurant;

import java.io.IOException;

import detail.DetailController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
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
	protected Text price;
	@FXML
	protected HBox box;
	@FXML
	protected String user;
	@FXML
	protected ImageView ratings;
	@FXML
	protected ActionEvent event;
	@FXML
	protected Button open;
	@FXML
	protected ImageView logo;
	@FXML
	protected AnchorPane root;
	@FXML
	protected Stage thisStage;

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
			name.setStyle("-fx-font: 18 System;");
			address = new Text();
			price = new Text();
			ratings = new ImageView();
			open = new Button();
			logo = new ImageView();
			HBox one = new HBox(name, ratings);
			open.setAlignment(Pos.BASELINE_CENTER);
			one.setSpacing(5);
			address.setWrappingWidth(250);
			VBox info = new VBox(one, address, price);
			info.setSpacing(5);
			info.setAlignment(Pos.CENTER);
			HBox button = new HBox(open);
			logo.setImage(new Image(item.getImageURL()));
			logo.setPreserveRatio(true);
			logo.setFitWidth(125);
			HBox img = new HBox(logo);
			img.setFillHeight(true);
			img.setAlignment(Pos.CENTER_LEFT);
			box = new HBox(img, info, button);
			button.setFillHeight(true);
			button.setAlignment(Pos.CENTER_LEFT);
			name.setText(item.getName());
			address.setText(item.getAddress());
			price.setText(item.getPriceRange());
			if (item.getRating() == 1)
				ratings.setImage(new Image("restaurant/one.png"));
			else if (item.getRating() == 2)
				ratings.setImage(new Image("restaurant/two.png"));
			else if (item.getRating() == 3)
				ratings.setImage(new Image("restaurant/three.png"));
			else if (item.getRating() == 4)
				ratings.setImage(new Image("restaurant/four.png"));
			else
				ratings.setImage(new Image("restaurant/five.png"));
			ratings.setPreserveRatio(true);
			ratings.setFitHeight(18);
			box.setSpacing(50);
			open.setText("Details");
			open.setStyle("-fx-background-color: #aaaaaa; -fx-border-color: black");
			open.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					Parent pane = null;
					try {
						FXMLLoader loader = new FXMLLoader(getClass().getResource("../detail/RestaurantDetail.fxml"));
						pane = loader.load();
						DetailController restaurantView = loader.getController();
						restaurantView.changeInfo(item);
					} catch (IOException e) {

					}
					Scene table = new Scene(pane);
					Stage x = new Stage();
					x.setScene(table);
					x.show();
				}
			});
			setGraphic(box);
		}
	}

}
