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
	
	@FXML
	Button btnSignup, btnLogin, btnReturn;
	@FXML
	TextField userName;
	@FXML
	ImageView progress;
	@FXML
	TextField password;

	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	public LoginController() {
		conn = ConnectionUtil.conDB();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		if (conn == null) {
			System.out.println("Server Error : Check");
		} else {
			System.out.println("Server is up : Good to go");
		}

		btnSignup.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				buttonSginupAction();
			}
		});

		btnLogin.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				handleButtonAction(event);
			}
		});

		progress.setVisible(false);

	}
	
	public void handleButtonAction(MouseEvent event) {

		progress.setVisible(true);
		PauseTransition pt = new PauseTransition();
		pt.setDuration(Duration.seconds(3));		
		pt.setOnFinished(event1 -> {

			System.out.println(event.getSource());

			if (event.getSource() == btnLogin) {
				// login here
				System.out.println(loginAction().toString());
				if (loginAction().equals("Success")) {

					System.out.println("succ");
					btnLogin.getScene().getWindow().hide();

					Stage login = new Stage();
					Parent root;
					try {
						root = FXMLLoader.load(getClass().getResource("CarHome.fxml"));
						Scene scene = new Scene(root);
						login.setScene(scene);
						login.show();
						login.setResizable(false);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}

			} else {
				System.out.println("error.");
				pt.stop();
			}
		});
		pt.play();
	}

	public String loginAction() {

		String status = "Success";
		String un = userName.getText();
		String ps = password.getText();
		if (un.isEmpty() || ps.isEmpty()) {
			status = "Error";
		} else {
			// query
			String sql = "SELECT * FROM users Where name = ? and password = ?";
			try {
				pst = conn.prepareStatement(sql);
				pst.setString(1, userName.getText());
				pst.setString(2, password.getText());
				rs = pst.executeQuery();
				if (!rs.next()) {
					status = "Error";
					System.out.println("Login fail");
				} else {
					System.out.println("Login succes");

				}
			} catch (SQLException ex) {
				System.err.println(ex.getMessage());
				status = "Exception";
			}
		}

		return status;
	}

	public void buttonSginupAction() {
		progress.setVisible(true);
		PauseTransition pt = new PauseTransition();
		pt.setDuration(Duration.seconds(3));
		pt.setOnFinished(event1 -> {

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
		});
		pt.play();
	}
	public void buttonReturnAction() {
		btnSignup.getScene().getWindow().hide();

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
