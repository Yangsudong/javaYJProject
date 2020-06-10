package javaYJProject;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

public class LoginController implements Initializable{
	
	@FXML Button signup;
	@FXML TextField username;
	@FXML Button login;
	@FXML ImageView progress;
	@FXML TextField password;
	
	private Connection conn;
	private String users;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		progress.setVisible(false);
	}
	public void loginAction(ActionEvent event) {
		//로딩바 
		progress.setVisible(true);
		PauseTransition pt = new PauseTransition();
		pt.setDuration(Duration.seconds(3));
		pt.setOnFinished(event1 -> {
		});
		
		pt.play();
	}
	public void signup(ActionEvent evnet2) throws IOException {
		Stage signup = new Stage();
		login.getScene().getWindow().hide();
		Parent root = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
		Scene scene = new Scene(root);
		signup.setScene(scene);
		signup.show();
		signup.setResizable(false);
	}
}
