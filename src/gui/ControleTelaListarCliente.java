package gui;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import DAO.ClienteDAO;
import application.Main;
import entity.Cliente;
import gui.util.Alerts;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class ControleTelaListarCliente implements Initializable {

	@FXML
	private TableView<Cliente> tableViewCliente;
	@FXML
	private TableColumn<Cliente, String> tableColumnNome;
	@FXML
	private TableColumn<Cliente, String> tableColumnEmail;
	@FXML
	private TableColumn<Cliente, String> tableColumnContato;
	@FXML
	private TableColumn<Cliente, String> tableColumnDataDeNascimento;
	@FXML
	private TableColumn<Cliente, Long> tableColumnId;
	@FXML
	private Button buttonVoltar;
	@FXML
	private Button buttonRemoverCliente;

	private ObservableList<Cliente> obsList;

	private ClienteDAO cliente;

	public void setCliente(ClienteDAO cliente) {
		this.cliente = cliente;
	}

	@FXML
	public void onButtonVoltarAction() throws IOException {
		
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/TelaDeMenu.fxml"));
			ScrollPane scrollPane = fxmlLoader.load();
			Scene scene = new Scene(scrollPane);
			scrollPane.setFitToHeight(true);
			scrollPane.setFitToWidth(true);
			Main.primaryStage.setTitle("Tela De Menu");
			Main.primaryStage.setScene(scene);
			Main.primaryStage.show();

		} catch (RuntimeException e) {
			Alerts.showAlerts("Erro De Carregamento De Tela", "Erro", e.getMessage(), AlertType.ERROR);
		}
	}

	public void onButtonRemoverCliente() throws IOException {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/TelaRemoverCliente.fxml"));
			Parent parent = fxmlLoader.load();
			Scene scene = new Scene(parent);
			Main.primaryStage.setScene(scene);
			Main.primaryStage.show();
		} catch (RuntimeException e) {
			Alerts.showAlerts("Erro De Carregamento De Tela", "Erro", e.getMessage(), AlertType.ERROR);
		}
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
		updateTableView();

	}

	public void updateTableView() { // carregar dados na tela

		List<Cliente> list = cliente.getClientes();
		obsList = FXCollections.observableArrayList(list);
		tableViewCliente.setItems(obsList);

	}

	private void initializeNodes() {
		tableColumnNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		tableColumnEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
		tableColumnContato.setCellValueFactory(new PropertyValueFactory<>("numeroDeTelefone"));
		tableColumnDataDeNascimento.setCellValueFactory(new PropertyValueFactory<>("dataDeNascimento"));
		tableColumnId.setCellValueFactory(new PropertyValueFactory<>("Id"));

	}

}
