package gui;

import java.io.IOException;
import DAO.UsuarioDAO;
import application.Main;
import entity.Usuario;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;

public class ControleTelaDeCadastro {

	@FXML
	private TextField textoNome;
	@FXML
	private TextField textoEmail;
	@FXML
	private PasswordField textoSenha;
	@FXML
	private PasswordField textoConfirmarSenhar;
	@FXML
	private Button buttonContinuar;

	@FXML
	public void onButtonContinuarAction() throws IOException {

		String nome = textoNome.getText();
		String email = textoEmail.getText();
		String senha = textoSenha.getText();
		String confirmaSenha = textoConfirmarSenhar.getText();
		try {
			if (nome.isBlank() || email.isBlank() || senha.isBlank() || confirmaSenha.isBlank() || !senha.equals(confirmaSenha)) {
				Alerts.showAlerts("Algum campo está em branco ou as senhas não são iguais!",
						"Preencha os campos vazios ou Verificasse se as senhas são iguais!", null,
						AlertType.INFORMATION);
			} else {
					Usuario usuario = new Usuario(nome, email, senha, confirmaSenha);
					UsuarioDAO.adicionarUsuario(usuario);
					carregarTela();
			}
			
		} catch (RuntimeException e) {
			Alerts.showAlerts("Houve Algum Erro", "Erro", e.getMessage(), AlertType.ERROR);
		}
	}

	public void carregarTela() throws IOException {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/TelaDeMenu.fxml"));
			ScrollPane scrollPane = fxmlLoader.load();
			scrollPane.setFitToHeight(true);
			scrollPane.setFitToWidth(true);
			Scene scene = new Scene(scrollPane);
			Main.primaryStage.setScene(scene);
			Main.primaryStage.show();
		} catch (RuntimeException e) {
			Alerts.showAlerts("Houve Algum Erro", "Erro De Carregamento De Tela", e.getMessage(), AlertType.ERROR);
		}
	}
}
