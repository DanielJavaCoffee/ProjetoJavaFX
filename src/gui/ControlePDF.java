package gui;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import DAO.ClienteDAO;
import DAO.OrcamentoDAO;
import DAO.ProdutoDAO;
import DAO.ServicosDAO;
import application.Main;
import entity.Cliente;
import entity.GeradorDeRelatorioPDF;
import entity.Orcamento;
import entity.Produto;
import entity.Servicos;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;

public class ControlePDF {
	@FXML
	private Button buttonGerarPDFCliente;
	@FXML
	private Button buttonGerarPDFProduto;
	@FXML
	private Button buttonGerarPDFServico;
	@FXML
	private Button buttonGerarPDFOrcamento;
	@FXML
	private Button buttonVoltar;

	@FXML
	public void buttonPDFClienteAction() throws IOException {

		try {

			GeradorDeRelatorioPDF.geradorDePDFCliente((ArrayList<Cliente>) ClienteDAO.getClientes());
			URI link = new URI("file:///C:/ws-javaFX/Projeto/Cliente.PDF");
			Desktop.getDesktop().browse(link);
		} catch (URISyntaxException e) {
			Alerts.showAlerts("Erro", "Erro", e.getMessage(), AlertType.ERROR);
		}
	}

	@FXML
	public void buttonPDFProdutoAction() throws IOException {

		try {
			GeradorDeRelatorioPDF.GeradorDePDFProduto((ArrayList<Produto>) ProdutoDAO.getProdutos());
			URI link = new URI("file:///C:/ws-javaFX/Projeto/Produto.PDF");
			Desktop.getDesktop().browse(link);
		} catch (URISyntaxException e) {
			Alerts.showAlerts("Erro", "Erro", e.getMessage(), AlertType.ERROR);
		}
	}
	
	@FXML
	public void buttonPDFServicoAction() throws IOException {
		try {
			GeradorDeRelatorioPDF.geradorDePDFServico((ArrayList<Servicos>) ServicosDAO.getServicos());
			URI link = new URI("file:///C:/ws-javaFX/Projeto/Servico.PDF");
			Desktop.getDesktop().browse(link);
		} catch (URISyntaxException e) {
			Alerts.showAlerts("Erro", "Erro", e.getMessage(), AlertType.ERROR);
		}
	}
	
	@FXML
	public void buttonPDFOrcamentoAction() throws IOException {
		try {
			GeradorDeRelatorioPDF.GeradorDePDFOrcamento((ArrayList<Orcamento>) OrcamentoDAO.getOrcamento());
			URI link = new URI("file:///C:/ws-javaFX/Projeto/Orcamento.PDF");
			Desktop.getDesktop().browse(link);
		} catch (URISyntaxException e) {
			Alerts.showAlerts("Erro", "Erro", e.getMessage(), AlertType.ERROR);
		}
	}

	@FXML
	public void buttonVoltarAction() throws IOException {
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
			Alerts.showAlerts("Erro De Carregamento De Tela", "Erro De Carregamento De Tela.", e.getMessage(),
					AlertType.ERROR);
		}
	}
}
