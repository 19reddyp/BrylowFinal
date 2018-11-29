package login;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import detail.DetailController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import restaurant.RestaurantListCell;

public class SignOutConfirmationController implements Initializable {

	@FXML
	private AnchorPane root;
	@FXML
	private Button yesButton;
	@FXML
	private Button noButton;
	@FXML
	private Stage stage;

	public SignOutConfirmationController() {
		
	}

	public void setStage(Stage x) {
		stage = x;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		yesButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Parent pane = null;
				Stage temp = (Stage) ((Node) event.getSource()).getScene().getWindow();
				temp.close();
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
					pane = loader.load();
				} catch (IOException e) {

				}
				Scene table = new Scene(pane);
				stage.setScene(table);
				stage.show();
			}
		});
		noButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Parent pane = null;
				Stage temp = (Stage) ((Node) event.getSource()).getScene().getWindow();
				temp.close();
			}
		});
	}

}
