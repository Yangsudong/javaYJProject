package javaYJProject;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

public class exchangeRateController implements Initializable{
	@FXML ListView<String> listView1, listView2;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<String> list = FXCollections.observableArrayList(
				);
		list.add("한국  KRW ");
		list.add("미국  USD");
		list.add("유럽  EUR");
		list.add("중국  CHY");
		list.add("일본  JPY");
		listView1.setItems(list); 
		
		
	
	}
	
	
	
}
