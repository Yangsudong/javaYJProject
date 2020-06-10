package javaYJProject;

import java.io.IOException;
import java.net.URL;
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

public class SignupController implements Initializable {

	@FXML Button signup;
	@FXML TextField username;
	@FXML Button login;
	@FXML ImageView progress;
	@FXML TextField password;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		progress.setVisible(false);
	}
	@FXML
	public void signup(ActionEvent ae1) {
		progress.setVisible(false);
		PauseTransition pt = new PauseTransition();
		pt.setDuration(Duration.seconds(3));
		pt.setOnFinished(e -> {
			System.out.println("Signup Succesfull");
		});
		
		pt.play();
		// save data
//		
//		String insert = "Insert INTO DB이름(name,password,gender)"
//				+ "VALUES(?,?,?)" 
	}
	@FXML
	public void loginAction(ActionEvent ae2) throws IOException {
		signup.getScene().getWindow().hide();
		
		Stage login = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/FXML/LoginMain.fxml"));
		Scene scene = new Scene(root);
		login.setScene(scene);
		login.show();
		login.setResizable(false);
	}

}
