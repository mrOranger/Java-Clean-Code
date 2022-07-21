package javafx.esercizio_login.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.esercizio_login.User;

public class DatabaseManager {

	private static final String CONNECTION_STRING = "jdbc:sqlite:users.db";
	private static final String JDBC_CLASS = "org.sqlite.JDBC";
	private Connection connection;
	
	public DatabaseManager() {
		try {
			this.connection = null;
			Class.forName(JDBC_CLASS);
			connection = DriverManager.getConnection(CONNECTION_STRING);
			System.out.println("Connessione stabilita!");	
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void registerUser(String username, String password) {
		try {
			PreparedStatement statement = this.connection.prepareStatement("INSERT INTO Users (Username, Password) VALUES (?, ?)");
			statement.setString(1, username);
			statement.setString(2, password);
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public User getUser(String username) {
		User user = null;
		try {
			Statement statement = this.connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Users");
			while(resultSet.next()) {
				user = new User(resultSet.getString("Username"), resultSet.getString("Password"));
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public void closeConnection() {
		try {
			connection.close();
			System.out.println("Connessione chiusa con il Database...");
		} catch(SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}
	
}
