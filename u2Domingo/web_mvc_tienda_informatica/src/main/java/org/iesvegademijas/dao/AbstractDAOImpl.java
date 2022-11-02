package org.iesvegademijas.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.sql.Statement;
import java.util.Optional;
import java.util.ResourceBundle;

public abstract class AbstractDAOImpl {
	protected static String driverClassName;
	protected static String dbUrl;
	protected static String schemaUrl;
	protected static String schema;
	protected static String username;
	protected static String password;
	
	static {
		ResourceBundle bundle = ResourceBundle.getBundle("org.iesvegademijas.dao.database");
		driverClassName = bundle.getString("jdbc.driverClassName");
		dbUrl = bundle.getString("jdbc.url");
		schema = bundle.getString("jdbc.schema");
		schemaUrl = dbUrl + schema;
		username = bundle.getString("jdbc.username");
		password = bundle.getString("jdbc.password");
	}
	
	
	/**
	 * Ejecuta un PreparedStatement de tipo insert.
	 * @param ps de tipo insert
	 * @return devuelve Optional de entero correspondiente al ID generado.
	 * @throws SQLException
	 */
	protected Optional<Integer> executeInsert(PreparedStatement ps) throws SQLException {
		
		int rowNum = ps.executeUpdate();
		if (rowNum == 0) {
			System.out.println("Sentencia DML(INSERT, UPDATE o DELETE) cero filas actualizadas.");
		}
		
		try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
			if (generatedKeys.next()) {
				return Optional.of(generatedKeys.getInt(1));
			} else {
				System.out.println("Sentencia no genera ID .");
				return Optional.empty();
			}
		} catch(SQLFeatureNotSupportedException e) {
			e.printStackTrace();
			return Optional.empty();
		}
		
	}
	
	protected void executeUpdate(PreparedStatement ps) throws SQLException  {
		int rowNum = ps.executeUpdate();
		if (rowNum == 0) {
			System.out.println("Sentencia DML(INSERT, UPDATE o DELETE) con cero filas actualizadas.");
		}
	}
	
	protected PreparedStatement prepareStmtGeneratedKeys(Connection conn, String query) throws SQLException {
		return conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
	}
	
	protected PreparedStatement prepareStmtGeneratedKeys(Connection conn, String query,String[] indexNames) throws SQLException {
		return conn.prepareStatement(query, indexNames);
	}
	
	protected static Connection connectDB() throws ClassNotFoundException, SQLException {
		
		Class.forName(driverClassName);
		Connection conn = DriverManager.getConnection(schemaUrl, username, password);
		return conn;
		
	}
	
	protected static void closeDb(Connection connection, Statement statement, ResultSet resultSet) {
		if (resultSet != null)
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if (statement != null)
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if (connection != null)
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
}

