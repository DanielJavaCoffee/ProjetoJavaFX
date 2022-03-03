package gui;

import java.io.IOException;

import DAO.ServicosDAO;
import application.Main;
import entity.Servicos;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import net.bytebuddy.implementation.bind.annotation.TargetMethodAnnotationDrivenBinder;

public class ControleTelaCadastroDeServico {

	@FXML
	private TextField textoNome;
	@FXML
	private TextField textoValor;
	@FXML
	private TextField textoDescricao;
	@FXML
	private TextField textoTempoDoServico;
	@FXML
	private Button buttonSalvar;
	@FXML
	private Button buttonVoltar;

	@FXML
	public void onButtonSalvarAction() {
		try {

			String nome = textoNome.getText();
			int valor = Integer.parseInt(textoValor.getText());
			String descricao = textoDescricao.getText();
			String tempo = textoTempoDoServico.getText();

			Servicos servicos = new Servicos(nome, valor, descricao, tempo);
			ServicosDAO.salvarServicos(servicos);
			Alerts.showAlerts("Serviço Cadastrado!", "Serviço Cadastrado com sucesso!", null, AlertType.CONFIRMATION);
		} catch (NumberFormatException e) {
			Alerts.showAlerts("Erro", "O campo preço não pode ser Letras. Apenas numeros!", e.getMessage(),
					AlertType.ERROR);
		}
	}

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
}
