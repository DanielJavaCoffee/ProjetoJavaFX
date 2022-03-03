package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.mysql.jdbc.PreparedStatement;
import db.DB;
import entity.Produto;
import gui.util.Alerts;
import javafx.scene.control.Alert.AlertType;

public class ProdutoDAO {

	public static void salvarProduto(Produto produto) {

		String sql = "INSERT INTO produto (nome, valor, precoPorMetro ,descricao, id) VALUES (?,?,?,?,?)";

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {

			connection = DB.getConnection();
			preparedStatement = (PreparedStatement) connection.prepareCall(sql);
			preparedStatement.setString(1, produto.getNome());
			preparedStatement.setInt(2, produto.getValor());
			preparedStatement.setInt(3, produto.getPrecoPorMetro());
			preparedStatement.setString(4, produto.getDescricao());
			preparedStatement.setLong(5, produto.getId());
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static List<Produto> getProdutos() {

		String sql = "SELECT * FROM produto";

		List<Produto> produtos = new ArrayList<Produto>();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		// classe que vai recuperar os dados do banco
		ResultSet resultSet = null;

		try {

			connection = DB.getConnection();
			preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) { // enquanto tiver dado, ele vai rodar.

				Produto produto = new Produto();

				produto.setNome(resultSet.getString("nome"));
				produto.setValor(resultSet.getInt("valor"));
				produto.setPrecoPorMetro(resultSet.getInt("precoPorMetro"));
				produto.setDescricao(resultSet.getString("descricao"));
				produto.setID(resultSet.getLong("id"));
				
				produtos.add(produto);
			}

		} catch (Exception e) {
			Alerts.showAlerts("Erro ao acessar o bando de dados", "erro", e.getMessage(), AlertType.ERROR);
		}
		return produtos;
	}
}
