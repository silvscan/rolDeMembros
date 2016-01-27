package br.com.ipb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	/*private static final String STR_DRIVER = "com.mysql.jdbc.Driver";
	private static final String USER = "ipbjard_user";
	private static final String PASSWORD = "ipbjard_ipb321";
	private static final String IP = "ipbjardimcalifornia.com.br";
	private static final String DATABASE = "ipbjard_db";
	private static final String STR_CON = "jdbc:mysql://" + IP + ":3306/"+ DATABASE;
	*/
	private static final String STR_DRIVER = "com.mysql.jdbc.Driver";
	private static final String USER = "root";
	private static final String PASSWORD = "leafar321";
	private static final String IP = "localhost";
	private static final String DATABASE = "ipbjard_db";
	private static final String STR_CON = "jdbc:mysql://" + IP + ":3307/"+ DATABASE;

	public static Connection getConexao() throws SQLException {
		Connection conn = null;
		try {
			Class.forName(STR_DRIVER);
			conn = DriverManager.getConnection(STR_CON, USER, PASSWORD);
			return conn;

		} catch (ClassNotFoundException e) {
			throw new SQLException("Driver de conexão com banco de dados nao encontrado", e);
		} catch (SQLException e) {
			throw new SQLException("Erro ao obter a conexao com banco de dados", e);
		}
	}

	public static void closeConnection(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
