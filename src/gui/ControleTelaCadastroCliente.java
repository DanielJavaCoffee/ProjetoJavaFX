package gui;

import java.io.IOException;

import DAO.ClienteDAO;
import application.Main;
import entity.Cliente;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;

public class ControleTelaCadastroCliente {

	@FXML
	private TextField textNomeCliente;
	@FXML
	private TextField textEmailCliente;
	@FXML
	private TextField textNumeroTelefoneCliente;
	@FXML
	private TextField textDataDeNascimentoCliente;
	@FXML
	private Button buttonSalvar;
	@FXML
	private Button buttonVoltar;

	@FXML
	public void buttanSalvarCliente() throws IOException {

		String nome = textNomeCliente.getText();
		String email = textEmailCliente.getText();
		String contato = textNumeroTelefoneCliente.getText();
		String data = textDataDeNascimentoCliente.getText();

		if(ClienteDAO.existeCliente(email)) {
			
			Alerts.showAlerts("Erro", "O Cliente não pode ser salvo, pois já existe um cliente com este Email", null, AlertType.INFORMATION);
		
		} else {
			
			Cliente cliente = new Cliente(nome, email, contato, data);
			ClienteDAO.salvarCliente(cliente);
			Alerts.showAlerts("Salvo", "Cleinte Salvo", null, AlertType.CONFIRMATION);
		}
	}

	@FXML
	public void buttanVoltar() throws IOException {
		
		try {
			
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/TelaDeMenu.fxml"));
			ScrollPane scrollPane = fxmlLoader.load();

			scrollPane.setFitToHeight(true); // altura
			scrollPane.setFitToWidth(true); // largura

			Scene scene = new Scene(scrollPane);
			Main.primaryStage.setScene(scene);
			Main.primaryStage.setTitle("Cadastramento De Cleinte");
			Main.primaryStage.show();
			
		} catch (RuntimeException e) {
			Alerts.showAlerts("Erro de carregamento de tela", "Erro", e.getMessage(), AlertType.ERROR);
		}
	}
}
