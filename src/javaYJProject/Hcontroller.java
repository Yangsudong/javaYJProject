package javaYJProject;
package javaYJProject;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class Hcontroller implements Initializable{
@FXML AnchorPane holderPane;
	AnchorPane home;
	@FXML Button btnH,btnK,btnB,btnBW,btnA;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		createPage();
	}
	
	private void setNode(Node node) {
		holderPane.getChildren().clear();
		holderPane.getChildren().add((Node) node);
		
		FadeTransition ft = new FadeTransition();
		ft.setNode(node);
		ft.setFromValue(0.1);
		ft.setToValue(1);
		ft.setCycleCount(1);
		ft.setAutoReverse(false);
		ft.play();
	}
	private void createPage() {
		try {
			home = FXMLLoader.load(getClass().getResource("/FXML/home.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
