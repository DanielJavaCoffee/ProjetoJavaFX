package gui;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import DAO.ServicosDAO;
import application.Main;
import entity.Cliente;
import entity.Servicos;
import gui.util.Alerts;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class ControleDeTelaListarServico implements Initializable{
	
	@FXML
	private Button buttonVoltar;
	@FXML
	private Button buttonRemoverServico;
	@FXML
	private TableView<Servicos> tableServicos;
	@FXML
	private TableColumn<Servicos, String> columnNome;
	@FXML
	private TableColumn<Servicos, Integer> columnPreco;
	@FXML
	private TableColumn<Servicos, String> columnDescricao;
	@FXML
	private TableColumn<Servicos, String> columnDuracao;
	@FXML
	private TableColumn<Servicos, Long> columnID;
	
	private ObservableList<Servicos> obsList;
	private ServicosDAO servicos;
	
	public void setServicos(ServicosDAO servico) {
		this.servicos = servico;
	}
	
	@FXML
	public void onButtonVoltarAction() throws IOException {
		System.out.println("Clicoui");
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
	
	@FXML
	public void onButtonExcluirServico() {
		
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		updateTableView();
		initializeNodes();
	}
	
	
	public void updateTableView() { // carregar dados na tela

		List<Servicos> list = servicos.getServicos();
		obsList = FXCollections.observableArrayList(list);
		tableServicos.setItems(obsList);

	}

	private void initializeNodes() {
		columnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		columnPreco.setCellValueFactory(new PropertyValueFactory<>("valor"));
		columnDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
		columnDuracao.setCellValueFactory(new PropertyValueFactory<>("tempoDeDuracao"));
		columnID.setCellValueFactory(new PropertyValueFactory<>("id"));
	}
}
