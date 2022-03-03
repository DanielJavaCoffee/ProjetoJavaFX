package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import DAO.ClienteDAO;
import application.Main;
import entity.Mensageiro;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ControleTelaGmail implements Initializable {

	@FXML
	private Button buttonVoltar;
	@FXML
	private Button buttonSalvar;
	@FXML
	private TextField textoEmail;
	@FXML
	private TextField textoAssunto;
	@FXML
	private TextArea textoMensagem;

	@FXML
	public void onButtonVoltarAction() throws IOException {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/TelaDeMenu.fxml"));
			ScrollPane scrollPane = fxmlLoader.load();
			scrollPane.setFitToHeight(true); // altura
			scrollPane.setFitToWidth(true); // largura
			Scene scene = new Scene(scrollPane);
			Main.primaryStage.setScene(scene);
			Main.primaryStage.setTitle("Tela De Menu");
			Main.primaryStage.show();

		} catch (RuntimeException e) {
			Alerts.showAlerts("Erro De Carregamento De Tela", "Erro", e.getMessage(), AlertType.ERROR);
		}
	}

	@FXML
	public void onButtanEnviarMensagemAction() {

		try {

			String assunto = textoAssunto.getText();
			String email = textoEmail.getText();
			String texto = textoMensagem.getText();
			if (ClienteDAO.existeCliente(email)) {
				Mensageiro.enviarMensagem(assunto, email, texto);
				Alerts.showAlerts("Email enviado com sucesso!", "Email enviado", null, AlertType.CONFIRMATION);
			} else {
				Alerts.showAlerts("Email não localizado!", "Email não existe no sistema!", null, AlertType.INFORMATION);
			}
		} catch (Exception e) {
			Alerts.showAlerts("Email enviado com sucesso!", "Email enviado", e.getMessage(), AlertType.CONFIRMATION);
		}
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO Auto-generated method stub

	}

}
