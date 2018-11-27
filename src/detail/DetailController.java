package detail;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import models.Restaurant;
import rating.RatingController;

public class DetailController {
	@FXML
	private ImageView logo;
	@FXML
	private Text name;
	@FXML
	private ImageView rating;
	@FXML
	private Text price;
	@FXML
	private Text address;
	@FXML
	private Text type;
	@FXML
	private Text dining;
	@FXML
	private Text phone;
	@FXML
	private Text email;
	@FXML
	private Text hours;
	@FXML
	protected AnchorPane root;
	@FXML
	private Button review;

	public DetailController() {
		logo = new ImageView();
		rating = new ImageView();
		name = new Text();
		price = new Text();
		address = new Text();
		type = new Text();
		dining = new Text();
		phone = new Text();
		email = new Text();
		hours = new Text();
		review = new Button();
	}
	public void changeInfo(Restaurant toDisplay) {
		logo.setImage(new Image(toDisplay.getImageURL()));
		if (toDisplay.getRating() == 1)
			rating.setImage(new Image("detail/one.png"));
		else if (toDisplay.getRating() == 2)
			rating.setImage(new Image("detail/two.png"));
		else if (toDisplay.getRating() == 3)
			rating.setImage(new Image("detail/three.png"));
		else if (toDisplay.getRating() == 4)
			rating.setImage(new Image("detail/four.png"));
		else
			rating.setImage(new Image("detail/five.png"));
		name.setText(toDisplay.getName());
		price.setText(toDisplay.getPriceRange());
		address.setText(toDisplay.getAddress());
		type.setText(toDisplay.getType());
		dining.setText(toDisplay.getCuisine());
		phone.setText(toDisplay.getPhone());
		email.setText(toDisplay.getEmail());
		hours.setText(toDisplay.getHours());
		review.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Parent pane = null;
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("../rating/Rating.fxml"));
					pane = loader.load();
					RatingController ratings = loader.getController();
					ratings.addList(toDisplay);
				} catch (IOException e) {

				}
				Scene table = new Scene(pane);
				Stage x = new Stage();
				x.setScene(table);
				x.show();
			}
		});
	}

}
