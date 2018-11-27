package rating;

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

public class RatingListCell extends ListCell<Review> {
	@FXML
	protected ImageView stars;
	@FXML
	protected Text explain;
	@FXML
	protected HBox box;
	@FXML
	protected String user;
	@FXML
	protected ActionEvent event;
	@FXML
	protected AnchorPane root;
	@FXML
	protected Stage thisStage;

	public RatingListCell() {

	}

	@Override
	public void updateItem(Review item, boolean empty) {
		super.updateItem(item, empty);
		if (empty || item == null)
			setGraphic(null);
		else {
			stars = new ImageView();
			explain = new Text();
			if (item.getRating() == 1)
				stars.setImage(new Image("rating/one.png"));
			else if (item.getRating() == 2)
				stars.setImage(new Image("rating/two.png"));
			else if (item.getRating() == 3)
				stars.setImage(new Image("rating/three.png"));
			else if (item.getRating() == 4)
				stars.setImage(new Image("rating/four.png"));
			else
				stars.setImage(new Image("rating/five.png"));
			explain.setText(item.getExplanation());
			explain.setWrappingWidth(200);
			stars.setPreserveRatio(true);
			stars.setFitHeight(20);
			VBox fors = new VBox(stars);
			fors.setPrefWidth(150);
			VBox fore = new VBox(explain);
			fors.setAlignment(Pos.CENTER);
			fore.setAlignment(Pos.CENTER);
			box = new HBox(fors,fore);
			box.setSpacing(10);
			setGraphic(box);
		}
	}

}
