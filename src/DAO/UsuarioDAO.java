package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.PreparedStatement;
import db.DB;
import db.DbException;
import entity.Usuario;
import gui.util.Alerts;
import javafx.scene.control.Alert.AlertType;

public class UsuarioDAO {

	public static void adicionarUsuario(Usuario usuario) {

		String sql = "INSERT INTO usuario (nome, email, senha, confirmaSenha) VALUES (?, ?, ?, ?)";
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DB.getConnection();
			preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			preparedStatement.setString(1, usuario.getNome());
			preparedStatement.setString(2, usuario.getEmail());
			preparedStatement.setString(3, usuario.getSenha());
			preparedStatement.setString(4, usuario.getComfirmarSenha());
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			Alerts.showAlerts("Erro", "Erro", e.getMessage(), AlertType.ERROR);
		}
	}

	public static boolean existeUsuario() {

		String sql = "SELECT * FROM usuario";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = DB.getConnection();
			preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next())
				return true;

		} catch (Exception e) {

		}
		return false;
	}

	public static boolean entrarLogin(String email, String senha) {

		String sql = "SELECT * FROM usuario WHERE email = ? AND senha = ?";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {

			connection = DB.getConnection();
			preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, senha);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return true;
			}

		} catch (Exception e) {
			Alerts.showAlerts("Erro", "Erro", e.getMessage(), AlertType.ERROR);
		}
		return false;
	}

	public static Usuario recuperarSenha(String nome) {

		String sql = "SELECT * FROM usuario WHERE nome = ?";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = DB.getConnection();
			preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			preparedStatement.setString(1, nome);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				String senha = resultSet.getString("senha");
				String email = resultSet.getString("email");
				return  new Usuario(nome, email, senha, senha);
			}

		} catch (Exception e) {

		}
		return null;
	}

	
	
	public static void excluirConta(String email, String senha) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String sql = "DELETE FROM usuario WHERE email = ? AND senha = ? ";

		try {
			connection = DB.getConnection();
			preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, senha);
			preparedStatement.execute();

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
	}

	public static boolean existeUsuario(String email, String senha) {

		String sql = "SELECT * FROM usuario WHERE email = ? AND senha = ?";

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {

			connection = DB.getConnection();
			preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, senha);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next())
				return true;

		} catch (Exception e) {
			Alerts.showAlerts("Erro ao acessar o bando de dados", "erro", e.getMessage(), AlertType.ERROR);
		}

		return false;

	}
}
