package javaYJProject;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class HyundaiController implements Initializable {
	@FXML
	Button btnbmw3, btnbmw5, btnbmw7, btnbmwX, btna4, btna6, btna7, btnq7, btnc, btne, btns, btnX, btnavante, btnsonata,
			btngrandure, btnsantafe, btnK5, btnK7, btnK3, btnSorrento, btnHyundai, btnKIA, btnBMW, btnBenz, btnAudi,
			btnLogout, btng,avanteReview;

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
		String url = "jdbc:oracle:thin:@192.168.0.76:1521:xe";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, "hr", "hr");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	public void AvantebuttonAction(ActionEvent av) {
		btnavante.getScene().getWindow();
		Stage avante = new Stage();
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/javaYJProject/Hyundai/Avante.fxml"));
			Scene scene = new Scene(root);
			avante.setScene(scene);
			avante.show();
			avante.setResizable(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void SonatabuttonAction(ActionEvent sn) {
		btnsonata.getScene().getWindow();
		Stage sonata = new Stage();
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/javaYJProject/Hyundai/Sonata.fxml"));
			Scene scene = new Scene(root);
			sonata.setScene(scene);
			sonata.show();
			sonata.setResizable(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void grandurebuttonAction(ActionEvent gr) {
		btngrandure.getScene().getWindow();
		Stage gran = new Stage();
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/javaYJProject/Hyundai/Grandure.fxml"));
			Scene scene = new Scene(root);
			gran.setScene(scene);
			gran.show();
			gran.setResizable(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void SantafebuttonAction(ActionEvent sf) {
		btnsantafe.getScene().getWindow();
		Stage santafe = new Stage();
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/javaYJProject/Hyundai/Santafe.fxml"));
			Scene scene = new Scene(root);
			santafe.setScene(scene);
			santafe.show();
			santafe.setResizable(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void logoutAction(ActionEvent ae1) {

		btnLogout.getScene().getWindow().hide();

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

	public void K5buttonAction(ActionEvent K5) {
		btnK5.getScene().getWindow();
		Stage K51 = new Stage();
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/javaYJProject/Kia/K5.fxml"));
			Scene scene = new Scene(root);
			K51.setScene(scene);
			K51.show();
			K51.setResizable(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void K3buttonAction(ActionEvent K3) {
		btnK3.getScene().getWindow();
		Stage K31 = new Stage();
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/javaYJProject/Kia/K3.fxml"));
			Scene scene = new Scene(root);
			K31.setScene(scene);
			K31.show();
			K31.setResizable(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void K7buttonAction(ActionEvent K7) {
		btnK7.getScene().getWindow();
		Stage K71 = new Stage();
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/javaYJProject/Kia/K7.fxml"));
			Scene scene = new Scene(root);
			K71.setScene(scene);
			K71.show();
			K71.setResizable(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void SorrentobuttonAction(ActionEvent Sorrento) {
		btnSorrento.getScene().getWindow();
		Stage sorrento = new Stage();
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/javaYJProject/Kia/Sorrento.fxml"));
			Scene scene = new Scene(root);
			sorrento.setScene(scene);
			sorrento.show();
			sorrento.setResizable(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void bmws3buttonAction(ActionEvent s3) {
		btnbmw3.getScene().getWindow();
		Stage bmw3 = new Stage();
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/javaYJProject/BMW/3S.fxml"));
			Scene scene = new Scene(root);
			bmw3.setScene(scene);
			bmw3.show();
			bmw3.setResizable(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void bmws5buttonAction(ActionEvent s5) {
		btnbmw5.getScene().getWindow();
		Stage bmw5 = new Stage();
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/javaYJProject/BMW/5S.fxml"));
			Scene scene = new Scene(root);
			bmw5.setScene(scene);
			bmw5.show();
			bmw5.setResizable(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void bmws7buttonAction(ActionEvent s7) {
		btnbmw7.getScene().getWindow();
		Stage bmw7 = new Stage();
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/javaYJProject/BMW/7S.fxml"));
			Scene scene = new Scene(root);
			bmw7.setScene(scene);
			bmw7.show();
			bmw7.setResizable(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void bmwsxbuttonAction(ActionEvent sx) {
		btnbmwX.getScene().getWindow();
		Stage bmwX = new Stage();
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/javaYJProject/BMW/XS.fxml"));
			Scene scene = new Scene(root);
			bmwX.setScene(scene);
			bmwX.show();
			bmwX.setResizable(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void a4buttonAction(ActionEvent aa4) {
		btna4.getScene().getWindow();
		Stage a4 = new Stage();
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/javaYJProject/Audi/A4.fxml"));
			Scene scene = new Scene(root);
			a4.setScene(scene);
			a4.show();
			a4.setResizable(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void a6buttonAction(ActionEvent aa6) {
		btna6.getScene().getWindow();
		Stage a6 = new Stage();
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/javaYJProject/Audi/A6.fxml"));
			Scene scene = new Scene(root);
			a6.setScene(scene);
			a6.show();
			a6.setResizable(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void a7buttonAction(ActionEvent aa7) {
		btna7.getScene().getWindow();
		Stage a7 = new Stage();
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/javaYJProject/Audi/A7.fxml"));
			Scene scene = new Scene(root);
			a7.setScene(scene);
			a7.show();
			a7.setResizable(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void q7buttonAction(ActionEvent qq7) {
		btnq7.getScene().getWindow();
		Stage q7 = new Stage();
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/javaYJProject/Audi/Q7.fxml"));
			Scene scene = new Scene(root);
			q7.setScene(scene);
			q7.show();
			q7.setResizable(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void KIAbuttonAction(ActionEvent ke) {
		btnKIA.getScene().getWindow().hide();
		Stage kia = new Stage();
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("kia3.fxml"));
			Scene scene = new Scene(root);
			kia.setScene(scene);
			kia.show();
			kia.setResizable(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void hyundaibuttonAction(ActionEvent he) {
		btnHyundai.getScene().getWindow().hide();
		Stage hyun = new Stage();
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("Hyundai.fxml"));
			Scene scene = new Scene(root);
			hyun.setScene(scene);
			hyun.show();
			hyun.setResizable(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void BMWbuttonAction(ActionEvent bm) {
		btnBMW.getScene().getWindow().hide();
		Stage BMW = new Stage();
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("BMW.fxml"));
			Scene scene = new Scene(root);
			BMW.setScene(scene);
			BMW.show();
			BMW.setResizable(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void AudibuttonAction(ActionEvent au) {
		btnAudi.getScene().getWindow().hide();
		Stage Audi = new Stage();
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("Audi.fxml"));
			Scene scene = new Scene(root);
			Audi.setScene(scene);
			Audi.show();
			Audi.setResizable(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void btncbuttonAction(ActionEvent bc) {
		btnc.getScene().getWindow();
		Stage cl = new Stage();
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/javaYJProject/Bentz/C.fxml"));
			Scene scene = new Scene(root);
			cl.setScene(scene);
			cl.show();
			cl.setResizable(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void btnebuttonAction(ActionEvent be) {
		btne.getScene().getWindow();
		Stage el = new Stage();
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/javaYJProject/Bentz/E.fxml"));
			Scene scene = new Scene(root);
			el.setScene(scene);
			el.show();
			el.setResizable(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void btnsbuttonAction(ActionEvent bs) {
		btns.getScene().getWindow();
		Stage sl = new Stage();
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/javaYJProject/Bentz/S.fxml"));
			Scene scene = new Scene(root);
			sl.setScene(scene);
			sl.show();
			sl.setResizable(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void bntgbuttonAction(ActionEvent bg) {
		btng.getScene().getWindow();
		Stage gl = new Stage();
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/javaYJProject/Bentz/G.fxml"));
			Scene scene = new Scene(root);
			gl.setScene(scene);
			gl.show();
			gl.setResizable(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void BenzbuttonAction(ActionEvent bz) {
		btnBenz.getScene().getWindow().hide();
		Stage Benz = new Stage();
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("Benz.fxml"));
			Scene scene = new Scene(root);
			Benz.setScene(scene);
			Benz.show();
			Benz.setResizable(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void reviewbuttonAction() {
		Stage Benz = new Stage();
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("ReviewPage.fxml"));
			Scene scene = new Scene(root);
			Benz.setScene(scene);
			Benz.show();
			Benz.setResizable(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
//	public void reviewk5buttonAction() {
//		Stage Benz = new Stage();
//		Parent root;
//		try {
//			root = FXMLLoader.load(getClass().getResource("ReviewPage.fxml"));
//			Scene scene = new Scene(root);
//			Benz.setScene(scene);
//			Benz.show();
//			Benz.setResizable(true);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}

}
