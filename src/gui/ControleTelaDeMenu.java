package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import application.Main;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class ControleTelaDeMenu implements Initializable {

	@FXML
	private MenuItem menuCadastroCliente;
	@FXML
	private MenuItem menuCadastroDeProduto;
	@FXML
	private MenuItem menuListarCliente;
	@FXML
	private MenuItem menuListarProduto;
	@FXML
	private MenuItem menuGmail;
	@FXML
	private MenuItem menuAtualizarCliente;
	@FXML
	private MenuItem menuExcluirconta;
	@FXML
	private MenuItem menuGerarPDF;
	@FXML
	private MenuItem menuFazerOrcamento;
	@FXML
	private MenuItem menuCadastroDeServico;
	@FXML
	private MenuItem menuListarServico;

	public static Stage primaryStage;

	@FXML
	public void onMenuClienteAction() throws IOException {
		carregarTela("/gui/TelaCadastroCliente.fxml");
	}

	@FXML
	public void onMenuProdutoAction() throws IOException {
		carregarTela("/gui/TelaCadastrarProduto.fxml");
	}
	
	@FXML
	public void onMenuCadastroDeServicoAction() throws IOException{
		carregarTela("/gui/TelaDeCadastroServico.fxml");
	}
	
	@FXML
	public void onMenuListarServico() throws IOException {
		carregarTela("/gui/TelaListarServico.fxml");
	}

	@FXML
	public void onMenuListarClienteAction() throws IOException {
		carregarTela("/gui/TelaListaCliente.fxml");
	}

	@FXML
	public void onMenuListarProdutoAction() throws IOException {
		carregarTela("/gui/TelaListarProduto.fxml");
	}
	
	@FXML
	public void onMenuGmailAction() throws IOException {
		carregarTela("/gui/TelaGmail.fxml");
	}
	
	@FXML
	public void onAtualizarClienteAction() throws IOException {
		carregarTela("/gui/TelaAtualizarCliente.fxml");
	}
	
	@FXML
	public void onExcluirContaAction() throws IOException {
		carregarTela("/gui/TelaExcluirConta.fxml");
	}
	
	@FXML
	public void onGerarPDFAction() throws IOException {
		carregarTela("/gui/TelaPDF.fxml");
	}
	
	@FXML
	public void onFazerOrcamento() throws IOException{
		carregarTela("/gui/TelaDeOrcamento.fxml");
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {

	}

	public void carregarTela(String string) throws IOException {

		try {

			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(string));
			Parent parent = fxmlLoader.load();
			Scene mainScene = new Scene(parent);
			Main.primaryStage.setScene(mainScene);
			Main.primaryStage.setTitle("Listar Cliente");
			Main.primaryStage.show();

		} catch (RuntimeException e) {
			Alerts.showAlerts("Erro de carregamento de tela", "Erro", e.getMessage(), AlertType.ERROR);
		}
	}
}
