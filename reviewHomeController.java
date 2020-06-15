package javaYJProject;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class reviewHomeController implements Initializable {
	@FXML
	Button btnLogout;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

		
	public void logoutAction(ActionEvent ae1) {

		btnLogout.getScene().getWindow().hide();

		Stage login = new Stage();
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("login.fxml"));
			Scene scene = new Scene(root);
			login.setScene(scene);
			login.show();
			login.setResizable(false);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
