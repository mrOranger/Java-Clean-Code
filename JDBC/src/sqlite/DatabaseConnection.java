package sqlite;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class DatabaseConnection {
	
	private static final String CONNECTION_STRING = "jdbc:sqlite:prova.db";
	private static final String JDBC_CLASS = "org.sqlite.JDBC";
	public Connection connection;
	
	private static final List<String> NOMI = List.of("Mario", "Maria", "Francesco", "Giuseppina");
	private static final List<String> COGNOMI = List.of("Rossi", "Verdi", "Neri", "Bianchi");
	private static final List<String> CITTA = List.of("Bari", "Milano", "Roma", "Napoli");
	private static final List<Integer> ETA = List.of(23, 19, 87, 56);
	
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
	
	public void popolaDb() {
		for(int i = 0; i < 100; i++) {
			String nome = NOMI.get((int)(Math.random()*NOMI.size()));
			String cognome = COGNOMI.get((int)(Math.random()*COGNOMI.size()));
			String citta = CITTA.get((int)(Math.random()*CITTA.size()));
			int eta = ETA.get((int)(Math.random()*ETA.size()));
			this.inserisciPersona(new Persona(nome, cognome, (byte)eta, citta));
		}
		try {
			this.connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
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
	
	public void inserisciPersone(Collection<Persona> persone) {
		final String SQL_STATEMENT = "INSERT INTO Persone (nome, cognome, citta, eta) VALUES (?, ?, ?, ?)";
		try {
			PreparedStatement preparedStatement = this.connection.prepareStatement(SQL_STATEMENT);
			Iterator<Persona> iterator = persone.iterator();
			while(iterator.hasNext()) {
				Persona personaCorrente = iterator.next();
				preparedStatement.setString(1, personaCorrente.getNome());
				preparedStatement.setString(2, personaCorrente.getCognome());
				preparedStatement.setString(3, personaCorrente.getCitta());
				preparedStatement.setInt(4, (int)personaCorrente.getEta());	
				preparedStatement.addBatch();
			}
			preparedStatement.executeBatch();
			this.connection.commit();
		} catch (SQLException e) {
			this.eseguiRollback();
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
			System.out.println("Connessione chisa con il Database...");
		} catch(SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

}
