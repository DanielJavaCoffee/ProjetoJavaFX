package gui;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import DAO.ProdutoDAO;
import application.Main;
import entity.Produto;
import gui.util.Alerts;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ControleTelaListarProduto implements Initializable {

	@FXML
	private Button buttonVoltar;
	@FXML
	private Button buttonExcluir;
	@FXML
	private TableView<Produto> tableViewProduto;
	@FXML
	private TableColumn<Produto, String> tableColumnNome;
	@FXML
	private TableColumn<Produto, Integer> tableColumnValor;
	@FXML
	private TableColumn<Produto, Integer> tableColumnPreco;
	@FXML
	private TableColumn<Produto, String> tableColumnDescricao;
	@FXML
	private TableColumn<Produto, Long> tableColumnId;

	private ObservableList<Produto> observableList;

	private ProdutoDAO produto;

	public void setProduto(ProdutoDAO produtoDAO) {
		this.produto = produtoDAO;
	}

	@FXML
	public void onButtonvoltarAction() throws IOException {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/TeLaDeMenu.fxml"));
			ScrollPane scrollPane = fxmlLoader.load();
			scrollPane.setFitToHeight(true);
			scrollPane.setFitToWidth(true);
			Scene scene = new Scene(scrollPane);
			Main.primaryStage.setTitle("Tela De Menu");
			Main.primaryStage.setScene(scene);
			Main.primaryStage.show();

		} catch (RuntimeException e) {
			Alerts.showAlerts("Erro De Carregamento De Tela", "erro", e.getMessage(), AlertType.ERROR);
		}
	}
	
	@FXML
	public void onButtonExcluirAction() {
		
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
		updateTableView();
	}

	public void initializeNodes() {

		tableColumnNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		tableColumnValor.setCellValueFactory(new PropertyValueFactory<>("Valor"));
		tableColumnPreco.setCellValueFactory(new PropertyValueFactory<>("precoPorMetro"));
		tableColumnDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
		tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
	}

	public void updateTableView() { // carregar dados na tela

		List<Produto> list = produto.getProdutos();
		observableList = FXCollections.observableArrayList(list);
		tableViewProduto.setItems(observableList);
	}
}
