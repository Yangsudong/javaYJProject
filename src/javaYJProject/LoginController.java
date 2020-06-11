package javaYJProject;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


import javafx.animation.PauseTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class LoginController implements Initializable{
	
	@FXML Button btnSignup;
	@FXML TextField userName;
	@FXML Button btnLogin;
	@FXML ImageView progress;
	@FXML TextField password;
	
	ObservableList<Users> users;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		users = FXCollections.observableArrayList();

		btnSignup.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				buttonSginupAction();
			}
		});
		
		btnLogin.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				loginAction();
			}
		});
		
		progress.setVisible(false);
	}
	public void loginAction() {
		//로딩바 
		progress.setVisible(true);
		PauseTransition pt = new PauseTransition();
		pt.setDuration(Duration.seconds(3));
		pt.setOnFinished(event1 -> {
			btnLogin.getScene().getWindow().hide();
			
			Stage login = new Stage();
			Parent root;
			try {
				root = FXMLLoader.load(getClass().getResource("carReviewHome.fxml"));
				Scene scene = new Scene(root);
				login.setScene(scene);
				login.show();
				login.setResizable(false);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});		
		pt.play();
		
	}
	
	
	public void buttonSginupAction() {
		// 윈도우 Stage의 스타일지정
		
		btnSignup.getScene().getWindow().hide();
		
		Stage login = new Stage();
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("signUp.fxml"));
			Scene scene = new Scene(root);
			login.setScene(scene);
			login.show();
			login.setResizable(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void buttonLoginAction() {
		
		btnLogin.getScene().getWindow().hide();
		
		Stage login = new Stage();
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("carReviewHome.fxml"));
			Scene scene = new Scene(root);
			login.setScene(scene);
			login.show();
			login.setResizable(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
