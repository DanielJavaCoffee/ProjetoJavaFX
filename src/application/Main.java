package application;

import java.io.IOException;

import DAO.UsuarioDAO;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	public static Stage primaryStage;

	public void start(Stage stage) {

		if (UsuarioDAO.existeUsuario()) {
			try {
				primaryStage = stage;
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/TelaDeLogin.fxml"));
				Parent parent = loader.load();

				// scrollPane.setFitToHeight(true); // altura
				// scrollPane.setFitToWidth(true); // largura

				Scene mainScene = new Scene(parent);
				primaryStage.setResizable(false);
				primaryStage.setScene(mainScene);
				primaryStage.setTitle("Sample JavaFX application");
				primaryStage.show();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {

			try {
				primaryStage = stage;
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/TelaDeCadastroUsuario.fxml"));
				Parent parent = loader.load();

				// scrollPane.setFitToHeight(true); // altura
				// scrollPane.setFitToWidth(true); // largura

				Scene mainScene = new Scene(parent);
				primaryStage.setResizable(false);
				primaryStage.setScene(mainScene);
				primaryStage.setTitle("Sample JavaFX application");
				primaryStage.show();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
