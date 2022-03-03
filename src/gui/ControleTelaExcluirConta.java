package gui;

import java.io.IOException;
import DAO.UsuarioDAO;
import application.Main;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;

public class ControleTelaExcluirConta {

	@FXML
	private TextField textoCampoEmail;
	@FXML
	private PasswordField textoCampoSenha;
	@FXML
	private Button buttonExcluir;
	@FXML
	private Button buttonVoltar;

	@FXML
	public void onExcluirconta() {

		try {
			String email = textoCampoEmail.getText();
			String senha = textoCampoSenha.getText();
			if (UsuarioDAO.existeUsuario(email, senha)) {
				UsuarioDAO.excluirConta(email, senha);
				Alerts.showAlerts("Conta exluida com sucesso!", "Tudo Certo", null, AlertType.CONFIRMATION);
			} else {
				Alerts.showAlerts("Conta não localizada!", "Erro, Usuário não encontrado no banco de dados.", null, AlertType.CONFIRMATION);
			}
		} catch (Exception e) {
			Alerts.showAlerts("Algo deu errado", "Erro", e.getMessage(), AlertType.ERROR);
		}
	}

	@FXML
	public void onButtonVoltar() throws IOException {

		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/TelaDeMenu.fxml"));
			ScrollPane scrollPane = fxmlLoader.load();
			scrollPane.setFitToHeight(true);
			scrollPane.setFitToWidth(true);
			Scene scene = new Scene(scrollPane);
			Main.primaryStage.setScene(scene);
			Main.primaryStage.show();
		} catch (RuntimeException e) {
			Alerts.showAlerts("Erro De Carregamento De Tela", "Erro", e.getMessage(), AlertType.ERROR);
		}
	}
}
