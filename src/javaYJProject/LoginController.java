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
	public void initialize(URL location, ResourceBundle resources) {
		
		users = FXCollections.observableArrayList();

		btnSignup.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				buttonSginupAction();
			}
		});
		
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
	
	
	public void buttonSginupAction() {
		// 윈도우 Stage의 스타일지정
		Stage sginupStage = new Stage(StageStyle.UTILITY);
		sginupStage.initModality(Modality.WINDOW_MODAL);
		sginupStage.initOwner(btnSignup.getScene().getWindow()); // addStage의 주window설정

		try {
			Parent parent = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
			Scene scene = new Scene(parent);
			sginupStage.setScene(scene);
			sginupStage.setResizable(false);
			sginupStage.show();

			Button btnSignup = (Button) parent.lookup("#btnSignup");

			btnSignup.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					

				}
			});

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
