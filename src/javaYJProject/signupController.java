package javaYJProject;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class signupController implements Initializable {

	@FXML Button btnsignup, btnsignupClose;
	@FXML Button login;
	@FXML ImageView progress;
	@FXML TextField userName;
	@FXML PasswordField password;
	@FXML TextField phoneNum;
	@FXML ToggleGroup gender;
	@FXML RadioButton Male, Female;

	Connection conn;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, "hr", "hr");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
		public void btnsignup(ActionEvent e) {		
			
				String sql = "insert into users(name,password,gender,phone_number)" 
						+ " values(?,?,?,?)";
				try {
					PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, userName.getText());
					pstmt.setString(2, password.getText());
					pstmt.setString(3, getGender());
					pstmt.setString(4, phoneNum.getText());
									
				}
				catch(SQLException e1) {
					e1.printStackTrace();
				}
				// 각 필드 초기화
				userName.setText(null);
				password.setText(null);
				phoneNum.setText(null);
		}
	

	@FXML
	public void loginAction(ActionEvent ae1) {
	
		btnsignup.getScene().getWindow().hide();
		
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
	
	public String getGender() {
		
		String gen = "";
		if(Male.isSelected()) {
			gen = "Male";
		}
		else if(Female.isSelected()) {
			gen = "Female";
		}
		
		return gen;
	}
	
	
}

