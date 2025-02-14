package entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class Conexion {
	private Connection connection = null;
	private PreparedStatement sentencia = null;
	private static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
	private String DB_URL = "jdbc:mariadb://127.0.0.1/";
	
	public Conexion(String user, String password, String dataBase) throws SQLException, ClassNotFoundException {
		Class.forName(JDBC_DRIVER);
		System.out.println("Conectando...");
		DB_URL = DB_URL + dataBase;
		connection = DriverManager.getConnection(DB_URL, user,password);
	}
	
	public void consulta (String sql) throws SQLException {
		sentencia = connection.prepareStatement(sql);
	}
	public ResultSet resultado() throws SQLException {
		return sentencia.executeQuery();
	}
	public int modificacion () throws SQLException, SQLIntegrityConstraintViolationException{
		return sentencia.executeUpdate();
	}
	public void close() throws SQLException {
		if (sentencia != null) {
			sentencia.close();
		}
	}
	public PreparedStatement getSentencia() {
		return sentencia;
	}
	
}
