package gui;

import java.io.IOException;
import java.util.ArrayList;

import DAO.ClienteDAO;
import DAO.UsuarioDAO;
import application.Main;
import entity.Cliente;
import entity.GeradorDeRelatorioPDF;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class ControleTelaDeLogin {

	@FXML
	private TextField textoEmail;
	@FXML
	private PasswordField passwordFieldSenha;
	@FXML
	private Button buttonEntar;
	@FXML
	private Button buttonEsqueciSenha;

	@FXML
	public void onbuttonEntrarAction() throws IOException {

		String email = textoEmail.getText();
		String senha = passwordFieldSenha.getText();

		if (UsuarioDAO.entrarLogin(email, senha)) {

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
		} else {
			Alerts.showAlerts("Usuário Não encontrado", "Não encontramos ninguém com este email ou senha.", null,
					AlertType.INFORMATION);
		}
	}

	@FXML
	private void onButtonEsqueciSenhaAction() {
	
		  try {
		 
		  FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/Tela.fxml")); 
		  Pane pane = fxmlLoader.load();
		  Scene scene = new Scene(pane);
		  Main.primaryStage.setTitle("Entre com o nome do usuário.");
		  Main.primaryStage.setScene(scene);
		  Main.primaryStage.show();
		  
		  } catch (IOException e) {
			  Alerts.showAlerts("IO Exception",  "Erro de carregamento de tela", e.getMessage(), AlertType.ERROR); } }
}
