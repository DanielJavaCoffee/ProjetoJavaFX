package gui;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import DAO.OrcamentoDAO;
import DAO.ProdutoDAO;
import DAO.ServicosDAO;
import application.Main;
import entity.Mensageiro;
import entity.Orcamento;
import entity.Produto;
import entity.Servicos;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ControleTelaDeOrcamento implements Initializable {

	@FXML
	private TextField textoHorarioDeEntrega;
	@FXML
	private TextField textoPrecoDoServico;
	@FXML
	private TextField textoPrecoDoProduto;
	@FXML
	private TextField textoServicoContratado;
	@FXML
	private TextField textoNomeDoProduto;
	@FXML
	private TextField textoUnidadeDoProduto;
	@FXML
	private TextField textoPrecoPorMaterial;
	@FXML
	private TextField textoQuantosMetros;
	@FXML
	private TextField textoConfirmaEmail;
	@FXML
	private TextField textoStatus;
	@FXML
	private TextArea textoObservacao;
	@FXML
	private Button buttonVoltar;
	@FXML
	private Button buttonSalvar;

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

		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/TelaDeMenu.fxml"));
			ScrollPane scrollPane = fxmlLoader.load();
			scrollPane.setFitToHeight(true);
			scrollPane.setFitToWidth(true);
			Scene scene = new Scene(scrollPane);
			Main.primaryStage.setScene(scene);
			Main.primaryStage.show();
		} catch (RuntimeException e) {
			Alerts.showAlerts("Erro De Carregamento De Tela", "Erro De Carregamento De Tela", e.getMessage(),
					AlertType.ERROR);
		}
	}

	@FXML
	public void onButtonSalvar() {

		String horarioDeEntrega = textoHorarioDeEntrega.getText();
		int precoDoServico = Integer.parseInt(textoPrecoDoServico.getText());
		int precoDoProduto = Integer.parseInt(textoPrecoDoProduto.getText());
		String servicoContratado = textoServicoContratado.getText();
		String nomeDoProduto = textoNomeDoProduto.getText();
		int unidades = Integer.parseInt(textoUnidadeDoProduto.getText());
		int precoDoMaterialPorMetro = Integer.parseInt(textoPrecoPorMaterial.getText());
		int metros = Integer.parseInt(textoQuantosMetros.getText());
		String email = textoConfirmaEmail.getText();
		String status = textoStatus.getText();
		String observacao = textoObservacao.getText();

		int somarMetro = precoDoMaterialPorMetro * metros;
		int somar = precoDoProduto * unidades;
		int total = somarMetro + somar + precoDoServico;
		Orcamento orcamento = new Orcamento(horarioDeEntrega, precoDoServico, precoDoProduto, servicoContratado,
				nomeDoProduto, unidades, precoDoMaterialPorMetro, metros, email, status, observacao, total);
		OrcamentoDAO.adicionarOrcamento(orcamento);
		Mensageiro.enviarMensagemDeEmailOrcamento("Informações Do Seu Orçamento", orcamento.getEmailDeConfirmacao(),
				orcamento);
		Alerts.showAlerts("Orçamento Salvo com sucesso!", "Orçamento Salvo", null, AlertType.CONFIRMATION);

	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodesProduto();
		updateTableViewProduto();
		
		initializeNodesServico();
		updateTableViewServico();
		
	}

	public void initializeNodesProduto() {

		tableColumnNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		tableColumnValor.setCellValueFactory(new PropertyValueFactory<>("Valor"));
		tableColumnPreco.setCellValueFactory(new PropertyValueFactory<>("precoPorMetro"));
		tableColumnDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
		tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
	}

	public void updateTableViewProduto() { // carregar dados na tela

		List<Produto> list = produto.getProdutos();
		observableList = FXCollections.observableArrayList(list);
		tableViewProduto.setItems(observableList);
	}
	
	public void updateTableViewServico() { // carregar dados na tela

		List<Servicos> list = servicos.getServicos();
		obsList = FXCollections.observableArrayList(list);
		tableServicos.setItems(obsList);

	}

	private void initializeNodesServico() {
		columnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		columnPreco.setCellValueFactory(new PropertyValueFactory<>("valor"));
		columnDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
		columnDuracao.setCellValueFactory(new PropertyValueFactory<>("tempoDeDuracao"));
		columnID.setCellValueFactory(new PropertyValueFactory<>("id"));
	}
}
