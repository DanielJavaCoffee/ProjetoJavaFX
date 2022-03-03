package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import DAO.ClienteDAO;
import application.Main;
import entity.Cliente;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class ControleTelaAtualizarCliente implements Initializable {

	@FXML
	private TextField textoNome;
	@FXML
	private TextField textoEmail;
	@FXML
	private TextField textoContato;
	@FXML
	private TextField textoDataDeNascimento;
	@FXML
	private Button buttonVoltar;
	@FXML
	private Button buttonAtualizar;

	@FXML
	public void onButtonVoltarAction() throws IOException {

		try {

			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/TelaDeMenu.fxml"));
			ScrollPane scrollPane = fxmlLoader.load();
			scrollPane.setFitToHeight(true);
			scrollPane.setFitToWidth(true);
			Scene scene = new Scene(scrollPane);
			Main.primaryStage.setScene(scene);
			Main.primaryStage.setTitle("Tela De Menu");
			Main.primaryStage.show();

		} catch (RuntimeException e) {
			Alerts.showAlerts("Erro de carregamento de tela", "Erro", e.getMessage(), AlertType.ERROR);
		}
	}

	@FXML
	public void onButtonAtualizarAction() {

		try {
			String nome = textoNome.getText();
			String email = textoEmail.getText();
			String contato = textoContato.getText();
			String dataDeNascimento = textoDataDeNascimento.getText();

			Cliente cliente = new Cliente();
			cliente.setNome(nome);
			cliente.setEmail(email);
			cliente.setNumeroDeTelefone(contato);
			cliente.setDataDeNascimento(dataDeNascimento);
			
			ClienteDAO clienteDAO = new ClienteDAO();

			if (clienteDAO.existeCliente(email)) {
				ClienteDAO.atualizarClienteEmail(cliente);
				Alerts.showAlerts("Atualizado", "Atualizado", null, AlertType.CONFIRMATION);
			} else {
				Alerts.showAlerts("Esse email não existe", "Email não localizado!", null, AlertType.ERROR);
			}

		} catch (Exception e) {
			Alerts.showAlerts("Erro", "erro", e.getMessage(), AlertType.ERROR);
		}

	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
	}

}
