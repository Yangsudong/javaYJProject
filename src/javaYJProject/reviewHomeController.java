package javaYJProject;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;

public class reviewHomeController implements Initializable {

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
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
