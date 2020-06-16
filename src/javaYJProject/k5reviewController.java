package javaYJProject;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class k5reviewController implements Initializable {
	@FXML
	TableView<reviewBoard> tableView;
	@FXML
	TextField title;
	@FXML
	DatePicker writeDate;
	@FXML
	TextArea content;
	@FXML
	Button btnAdd, btnClose;
	@FXML
	TableColumn<String, reviewBoard> tableTitle, tableDate, tableContent;
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
		
		ObservableList<reviewBoard> reviewBoardList = getReivewBoardList();

		TableColumn<reviewBoard, ?> tcName = tableView.getColumns().get(0);
		tcName.setCellValueFactory(new PropertyValueFactory("title"));
		TableColumn<reviewBoard, ?> tcKorean = tableView.getColumns().get(1);
		tcKorean.setCellValueFactory(new PropertyValueFactory("writeDate"));
		TableColumn<reviewBoard, ?> tcMath = tableView.getColumns().get(2);
		tcMath.setCellValueFactory(new PropertyValueFactory("content"));

		tableView.setItems(reviewBoardList);

	}

	public ObservableList<reviewBoard> getReivewBoardList() {
		ObservableList<reviewBoard> list = FXCollections.observableArrayList();
		String sql = "select title, writedate, content from kiareview";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				reviewBoard board = new reviewBoard(rs.getString("title"), rs.getString("writedate"),
						rs.getString("content"));
				list.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public void buttonWriteAction(ActionEvent e) {
		if (title.getText() == null || title.getText().equals("")) {
			messageDialog("제목을 입력하세요.");
		} else if (writeDate.getValue() == null || writeDate.getValue().equals("")) {
			messageDialog("작성일을 입력하세요");
		} else if (content.getText() == null || content.getText().equals("")) {
			messageDialog("내용 입력하세요");
		} else {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			String sql = "insert into kiareview(title,writedate,content)" + " values(?,?,?)";
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, title.getText());
				pstmt.setString(2, writeDate.getValue().format(formatter));
				pstmt.setString(3, content.getText());
				
				int r = pstmt.executeUpdate();
				System.out.println(r + "건 입력됨");
				tableView.setItems(getReivewBoardList());
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			// 각 필드 초기화
			title.setText(null);
			writeDate.setValue(null);
			content.setText(null);
		}
	}
 
	public void btnClose() throws IOException {
		btnClose.getScene().getWindow().hide();
	}

	public void messageDialog(String message) {
		Stage customStage = new Stage(StageStyle.UTILITY);
		customStage.initModality(Modality.WINDOW_MODAL);
		customStage.initOwner(btnAdd.getScene().getWindow()); // 주인 window
		customStage.setTitle("확인");

		AnchorPane ap = new AnchorPane();
		ap.setPrefSize(400, 150); // 외부 컨테이너 size 설정

		ImageView imageView = new ImageView();
//		imageView.setImage(new Image("/panes/icons/dialog-info.png"));
		imageView.setFitHeight(50);
		imageView.setPreserveRatio(true); // 크기에 맞춤
		imageView.setLayoutX(15);
		imageView.setLayoutY(15);

		Button button = new Button("확인");
		button.setLayoutX(336);
		button.setLayoutY(104);
		button.setOnAction(e -> customStage.close()); // 확인 누르면 닫기

		Label label = new Label(message);
		label.setLayoutX(87);
		label.setLayoutY(33);
		label.setPrefHeight(15);
		label.setPrefWidth(290);

		ap.getChildren().add(imageView);
		ap.getChildren().add(button);
		ap.getChildren().add(label);

		Scene scene = new Scene(ap);
		customStage.setScene(scene);
		customStage.show();

	}

}
