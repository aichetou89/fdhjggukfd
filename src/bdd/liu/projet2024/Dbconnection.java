package bdd.liu.projet2024;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconnection {
	 static final String URL = "jdbc:mysql://localhost:3306/GestionDeBibliotheque";
	 static final String USER = "root";
	 static final String PASSWORD = "";

	 static Connection connection = null;

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("Connecté");
		} catch (ClassNotFoundException e) {
			// TODO : handle exception
		} catch (SQLException e) {
			// TODO : handle exception
		}
		return connection;
	}

	public static void main(String[] args) throws SQLException {
		Dbconnection.getConnection();
		
	}

}

