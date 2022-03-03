package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.mysql.jdbc.PreparedStatement;
import db.DB;
import entity.Servicos;

public class ServicosDAO {

	public static void salvarServicos(Servicos servicos) {

		String sql = "INSERT INTO servico (nome, preco, descricaoDoServico, tempoDoServico, id) VALUES (?,?,?,?,?)";

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DB.getConnection();
			preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			preparedStatement.setString(1, servicos.getNome());
			preparedStatement.setInt(2, servicos.getValor());
			preparedStatement.setString(3, servicos.getDescricao());
			preparedStatement.setString(4, servicos.getTempoDeDuracao());
			preparedStatement.setLong(5, servicos.getId());
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static List<Servicos> getServicos() {
		
		String sql = "SELECT * FROM servico";
		List<Servicos> servico = new ArrayList<Servicos>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = DB.getConnection();
			preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				Servicos servicos = new Servicos();
				
				servicos.setNome(resultSet.getString("nome"));
				servicos.setValor(resultSet.getInt("preco"));
				servicos.setDescricao(resultSet.getString("descricaoDoServico"));
				servicos.setTempoDeDuracao(resultSet.getString("tempoDoServico"));
				servicos.setId(resultSet.getLong("id"));
				servico.add(servicos);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return servico;
	}
}
