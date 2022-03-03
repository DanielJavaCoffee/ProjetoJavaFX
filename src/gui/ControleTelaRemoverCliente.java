package gui;

import java.io.IOException;

import DAO.ClienteDAO;
import application.Main;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class ControleTelaRemoverCliente {

	@FXML
	private Button buttonExcluir;
	@FXML
	private Button buttonVoltar;
	@FXML
	private TextField textoEmail;

	@FXML
	public void onButtonExcluirAction() {
		String email = textoEmail.getText();

		if (ClienteDAO.existeCliente(email)) {
			ClienteDAO.excluirPorEmail(email);
			Alerts.showAlerts("Cliente excluido", "O Cliente foi excluido do sistema.", null, AlertType.CONFIRMATION);
		} else {
			Alerts.showAlerts("Erro", "Cliente não localizado com este Email.", null, AlertType.ERROR);
		}
	}

	@FXML
	public void onButtonVoltar() throws IOException {

		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/TelaListaCliente.fxml"));
			Parent parent = fxmlLoader.load();
			Scene scene = new Scene(parent);
			Main.primaryStage.setScene(scene);
			Main.primaryStage.setTitle("Tela Listar Cliente");
			Main.primaryStage.show();
			
		} catch (RuntimeException e) {
			Alerts.showAlerts("Erro", "Erro de carregamento de tela.", e.getMessage(), AlertType.ERROR);
		}
	}

}
