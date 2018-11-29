package detail;

import java.io.IOException;
import java.text.DecimalFormat;

import detail.DetailController;
import javafx.event.ActionEvent;
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

public class MenuListCell extends ListCell<Item> {
	@FXML
	protected Text name;
	@FXML
	protected Text price;
	@FXML
	protected String user;
	@FXML
	protected ActionEvent event;
	@FXML
	protected AnchorPane root;
	@FXML
	protected Stage thisStage;

	public MenuListCell() {

	}

	@Override
	public void updateItem(Item item, boolean empty) {
		super.updateItem(item, empty);
		if (empty || item == null)
			setGraphic(null);
		else {
			name = new Text();
			price = new Text();
			name.setText(item.getName());
			Double x = item.getPrice();
			DecimalFormat df = new DecimalFormat("#0.00");
			String xPrice=df.format(x);
			price.setText("$"+xPrice);
			VBox one = new VBox(name);
			VBox two = new VBox(price);
			one.setAlignment(Pos.CENTER);
			two.setAlignment(Pos.CENTER);
			HBox box = new HBox(one, two);
			box.setAlignment(Pos.CENTER);
			box.setSpacing(20);
			setGraphic(box);
		}
	}

}