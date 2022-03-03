package gui;

import java.io.IOException;

import DAO.UsuarioDAO;
import application.Main;
import entity.Mensageiro;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;

public class ControleDeTela {
	
	@FXML
	private Button buttonEnviarEmail;
	@FXML
	private Button buttonVoltar;
	@FXML
	private TextField textoUsuario;
	
	public void onButtonEnviarEmailAction() {
		
		String nome = textoUsuario.getText();
		
		if(UsuarioDAO.recuperarSenha(nome) != null) {
			Mensageiro.enviarMensagemDeRecuperacaoDeSenha("Recuperamento De Senha", "danielsilvacr123@gmail.com", UsuarioDAO.recuperarSenha(nome));
		} else {
			Alerts.showAlerts("Usuário não encontrado!", "Usuário não encontrado!", null, AlertType.ERROR);
		}
	}
	
	@FXML
	public void onButtonVoltarAction() throws IOException {
		
		try {
	    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/TelaDeLogin.fxml"));
	    	Parent parent = fxmlLoader.load();
		    Scene scene = new Scene(parent);
	    	Main.primaryStage.setScene(scene);
		    Main.primaryStage.show();
		
		} catch (RuntimeException e) {
			Alerts.showAlerts("Erro De Carregamento De Tela", "Tela não está carregando!", e.getMessage(), AlertType.ERROR);
		}
	}
}
