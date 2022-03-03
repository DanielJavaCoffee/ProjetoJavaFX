package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.mysql.jdbc.PreparedStatement;
import db.DB;
import db.DbException;
import entity.Cliente;
import gui.util.Alerts;
import javafx.scene.control.Alert.AlertType;

public class ClienteDAO {

	public static void salvarCliente(Cliente cliente) {

		String sql = "INSERT INTO cliente (nome, email, numero, dataDeNascimento, id) VALUES (?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement ps = null;

		try {

			conn = DB.getConnection();
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getEmail());
			ps.setString(3, cliente.getNumeroDeTelefone());
			ps.setString(4, cliente.getDataDeNascimento());
			ps.setLong(5, cliente.getId());
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static List<Cliente> getClientes() {

		String sql = "SELECT * FROM cliente";

		List<Cliente> cliente = new ArrayList<Cliente>();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		// classe que vai recuperar os dados do banco
		ResultSet resultSet = null;

		try {
			connection = DB.getConnection();
			preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) { // enquanto tiver dado, ele vai rodar.

				Cliente clientes = new Cliente();

				clientes.setNome(resultSet.getString("nome"));
				clientes.setEmail(resultSet.getString("email"));
				clientes.setNumeroDeTelefone(resultSet.getString("numero"));
				clientes.setDataDeNascimento(resultSet.getString("dataDeNascimento"));
				clientes.setId(resultSet.getLong("id"));
				cliente.add(clientes);
			}
		} catch (Exception e) {
			Alerts.showAlerts("Erro ao acessar o bando de dados", "erro", e.getMessage(), AlertType.ERROR);
		}
		return cliente;
	}

	public static void excluirPorEmail(String email) {
		
		String sql = "DELETE FROM cliente WHERE email = ?";
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DB.getConnection();
			preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			preparedStatement.setString(1, email);
			preparedStatement.execute();
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
	}

	public static void atualizarClienteEmail(Cliente cliente) {

		String sql = "UPDATE cliente SET nome = ?, email = ?, numero = ?, dataDeNascimento = ? WHERE id = ?";
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {

			connection = DB.getConnection();
			preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			// adicionar valores
			preparedStatement.setString(1, cliente.getNome());
			preparedStatement.setString(2, cliente.getEmail());
			preparedStatement.setString(3, cliente.getNumeroDeTelefone());
			preparedStatement.setString(4, cliente.getDataDeNascimento());
			preparedStatement.setLong(5, cliente.getId());
			preparedStatement.execute();

		} catch (Exception e) {
			Alerts.showAlerts("Erro ao acessar o bando de dados", "erro", e.getMessage(), AlertType.ERROR);
		} 
	} 
	
	public static boolean  existeCliente(String email){

        String sql = "SELECT * FROM cliente WHERE email = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DB.getConnection();
            preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
            preparedStatement.setString(1, email);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) return true;

        } catch (Exception e) {
            Alerts.showAlerts("Erro ao acessar o bando de dados", "erro", e.getMessage(), AlertType.ERROR);
        }
        return false;
    }
}
