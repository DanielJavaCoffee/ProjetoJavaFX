package gui;

import java.io.IOException;

import DAO.ProdutoDAO;
import application.Main;
import entity.Produto;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ControleTelaCadastroProduto {

	@FXML
	private TextField textNome;
	@FXML
	private TextField textoValor;
	@FXML
	private TextField textoPrecoPorMetro;
	@FXML
	private TextArea textAreaDescricao;
	@FXML
	private Button buttonVoltar;
	@FXML
	private Button buttonSalvar;
	@FXML
	public void onButtanSalvarProdutoAction() {

		try {

			String nome = textNome.getText();
			int valor = Integer.parseInt(textoValor.getText());
			int preco = Integer.parseInt(textoPrecoPorMetro.getText());
			String descricao = textAreaDescricao.getText();

			Produto produto = new Produto(nome, valor, preco, descricao);
			ProdutoDAO.salvarProduto(produto);
			Alerts.showAlerts("Produto Cadastrado!", "Produto Cadastrado Com Sucesso!", null, AlertType.CONFIRMATION);
		} catch (Exception e) {
			Alerts.showAlerts("Erro ao salvar o produto", "ERRO", e.getMessage(), AlertType.ERROR);
		}
	}

	@FXML
	public void onButtanVoltarAction() throws IOException {
	
		try {
			
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/TelaDeMenu.fxml"));
			ScrollPane scrollPane = fxmlLoader.load();
			scrollPane.setFitToHeight(true);
			scrollPane.setFitToWidth(true);
			Scene scene = new Scene(scrollPane);
			Main.primaryStage.setTitle("Tela De Menu");
			Main.primaryStage.setScene(scene);
			Main.primaryStage.show();
			
		} catch (RuntimeException e) {
			Alerts.showAlerts("Erro De Carregamento De Tela", "Erro", e.getMessage(), AlertType.ERROR);
		}
	}
}
