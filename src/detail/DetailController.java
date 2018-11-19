package detail;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import models.Restaurant;

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
	}

}
