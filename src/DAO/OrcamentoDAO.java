package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import db.DB;
import entity.Orcamento;
import entity.Produto;
import gui.util.Alerts;
import javafx.scene.control.Alert.AlertType;

public class OrcamentoDAO {
	
	
	public static void adicionarOrcamento(Orcamento orcamento) {
		
		String sql = "INSERT INTO orcamento (horarioDeEntrega, precoDoServico, precoDoProduto, nomeDoServico, nomeDoProduto, unidades, precoDoMaterialPorMetro, metro, email, statusDoOrcamento, observacao, valorTotal, id) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			
			connection = DB.getConnection();
			preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			preparedStatement.setString(1, orcamento.getHorarioDeEntrega());
			preparedStatement.setInt(2, orcamento.getPrecoDoServico());
			preparedStatement.setInt(3, orcamento.getPrecoDoProduto());
			preparedStatement.setString(4, orcamento.getNomeDoServicoContratado());
			preparedStatement.setString(5, orcamento.getNomeDoProduto());
			preparedStatement.setInt(6, orcamento.getUnidadesDoProduto());
			preparedStatement.setInt(7, orcamento.getPrecoDoMaterial());
			preparedStatement.setInt(8, orcamento.getMetro());
			preparedStatement.setString(9, orcamento.getEmailDeConfirmacao());
			preparedStatement.setString(10, orcamento.getStatusDoOrcamento());
			preparedStatement.setString(11, orcamento.getObservacao());
			preparedStatement.setInt(12, orcamento.getValorTotal());
			preparedStatement.setLong(13, orcamento.getId());
			preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	public static List<Orcamento> getOrcamento(){
		
		String sql = "SELECT * FROM orcamento";

		List<Orcamento> orcamentos = new ArrayList<>();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		// classe que vai recuperar os dados do banco
		ResultSet resultSet = null;

		try {

			connection = DB.getConnection();
			preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) { // enquanto tiver dado, ele vai rodar.

				Orcamento orcamento = new Orcamento();

			    orcamento.setHorarioDeEntrega(resultSet.getString("horarioDeEntrega"));
			    orcamento.setPrecoDoServico(resultSet.getInt("precoDoServico"));
			    orcamento.setPrecoDoProduto(resultSet.getInt("precoDoProduto"));
			    orcamento.setNomeDoServicoContratado(resultSet.getString("nomeDoServico"));
			    orcamento.setNomeDoProduto(resultSet.getString("nomeDoProduto"));
			    orcamento.setUnidadesDoProduto(resultSet.getInt("unidades"));
			    orcamento.setPrecoDoMaterial(resultSet.getInt("precoDoMaterialPorMetro"));
			    orcamento.setMetro(resultSet.getInt("metro"));
			    orcamento.setEmailDeConfirmacao(resultSet.getString("email"));
			    orcamento.setStatusDoOrcamento(resultSet.getString("statusDoOrcamento"));
			    orcamento.setObservacao(resultSet.getString("observacao"));
			    orcamento.setValorTotal(resultSet.getInt("valorTotal"));
			    orcamento.setId(resultSet.getLong("id"));
				
				orcamentos.add(orcamento);
			}

		} catch (Exception e) {
			Alerts.showAlerts("Erro ao acessar o bando de dados", "erro", e.getMessage(), AlertType.ERROR);
		}
		return orcamentos;
	}

}
