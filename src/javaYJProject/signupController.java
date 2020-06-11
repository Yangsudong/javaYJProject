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

public class signupController implements Initializable {

	@FXML Button btnsignup, btnsignupClose;
	@FXML Button login;
	@FXML ImageView progress;
	@FXML TextField userName;
	@FXML TextField password;
	@FXML TextField phoneNum;
	
	ObservableList<Users> users;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		users = FXCollections.observableArrayList();

		btnsignup.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				buttonAddAction(arg0);
			}
		});
		
//		progress.setVisible(false);
	}
//	@FXML
//	public void signup(ActionEvent ae1) {
//		progress.setVisible(false);
//		PauseTransition pt = new PauseTransition();
//		pt.setDuration(Duration.seconds(3));
//		pt.setOnFinished(e -> {
//			System.out.println("Signup Succesfull");
//		});
//		
//		pt.play();
//		// save data
//		
//		String insert = "Insert INTO DB이름(name,password,gender)"
//				+ "VALUES(?,?,?)" 
//	}

	
	public void buttonAddAction(ActionEvent ae) {
		// 윈도우 Stage의 스타일지정
		Stage addStage = new Stage(StageStyle.UTILITY);
		addStage.initModality(Modality.WINDOW_MODAL);
		addStage.initOwner(btnsignup.getScene().getWindow()); // addStage의 주window설정

		try {
			Parent parent = FXMLLoader.load(getClass().getResource("signUp.fxml"));
			Scene scene = new Scene(parent);
			addStage.setScene(scene);
			addStage.setResizable(false);
			addStage.show();

			Button signup = (Button) parent.lookup("#userName");

			signup.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					TextField username = (TextField) parent.lookup("#userName");
					TextField password = (TextField) parent.lookup("#password");
					TextField phoneNum = (TextField) parent.lookup("#phoneNum");

					Users users = new Users(username.getText(), 
											password.getText(), 
											Integer.parseInt(phoneNum.getText()));
					addStage.close();

				}
			});

			Button signupClose = (Button) parent.lookup("#btnsignupClose");
			signupClose.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					addStage.close();
				}
			});

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
