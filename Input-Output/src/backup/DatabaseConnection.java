package backup;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

public class DatabaseConnection {
	
	private static final String CONNECTION_STRING = "jdbc:sqlite:prova.db";
	private static final String JDBC_CLASS = "org.sqlite.JDBC";
	public Connection connection;
	
	
	public DatabaseConnection() {
		try {
			this.connection = null;
			Class.forName(JDBC_CLASS);
			connection = DriverManager.getConnection(CONNECTION_STRING);
			connection.setAutoCommit(false);
			System.out.println("Connessione stabilita!");	
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void popolaDb(int numeroPersone) {
		for(int i = 0; i < numeroPersone; i++) {
			this.inserisciPersona(PersonGenerator.creaPersona());
		}
	}
	
	public void inserisciPersona(Persona persona) {
		final String SQL_STATEMENT = "INSERT INTO Persone (nome, cognome, citta, eta) VALUES (?, ?, ?, ?)";
		try {
			PreparedStatement preparedStatement = this.connection.prepareStatement(SQL_STATEMENT);
			preparedStatement.setString(1, persona.getNome());
			preparedStatement.setString(2, persona.getCognome());
			preparedStatement.setString(3, persona.getCitta());
			preparedStatement.setInt(4,(int)persona.getEta());
			preparedStatement.execute();
		} catch (SQLException e) {
			this.eseguiRollback();
			e.printStackTrace();
		} 
	}
	
	public Collection<Persona> getPersone(){
		Collection<Persona> persone = new ArrayList<>();
		try {
			Statement statement = this.connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Persone");
			while(resultSet.next()) {
				persone.add(new Persona(resultSet.getString("nome"), resultSet.getString("cognome"), (byte)resultSet.getInt("eta"), resultSet.getString("citta")));
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return persone;
	}
	
	public void eliminaDatabase() {
		final String SQL_STATEMENT = "DELETE FROM persone";
		try {
			PreparedStatement preparedStatement = this.connection.prepareStatement(SQL_STATEMENT);
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void eseguiRollback() {
		try {
			this.connection.rollback();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	public void chiudiConnessione() {
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
