package detail;

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
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import login.SignOutConfirmationController;
import models.ArrayUnsortedList;
import models.Item;
import models.Restaurant;
import rating.RatingController;
import restaurant.RestaurantController;

public class DetailController implements Initializable{
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
	@FXML
	private ListView<Item> menu;
	private ObservableList<Item> menuList;


	public DetailController() {
		menuList = FXCollections.observableArrayList();
		menu = new ListView<Item>();
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
	public void changeInfo(Restaurant toDisplay) {
		ArrayUnsortedList<Item> menu = toDisplay.getMenu();
		for(int x=0; x<menu.size(); x++) {
			menuList.add(menu.getNext());
		}
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
				Stage temp = (Stage) ((Node) event.getSource()).getScene().getWindow();
				temp.close();
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
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		menu.setItems(menuList);
		menu.setCellFactory(menuLists -> new MenuListCell());
	}
	@FXML
	public void redirectLogOut(ActionEvent event) throws IOException {
		FXMLLoader page = new FXMLLoader(getClass().getResource("../login/SignOutConfirmation.fxml"));
		AnchorPane pane = page.load();
		SignOutConfirmationController controller = page.getController();
		Stage temp = (Stage) ((Node) event.getSource()).getScene().getWindow();
		controller.setStage(temp);
		Scene scene = new Scene(pane);
		Stage temp2 = new Stage();
		temp2.setTitle("Restaurant Advisor");
		temp2.setScene(scene);
		temp2.show();
	}

}
