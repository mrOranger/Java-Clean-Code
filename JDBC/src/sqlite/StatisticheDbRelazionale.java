package sqlite;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashMap;
import java.util.Map;

public class StatisticheDbRelazionale {
	
	public static Map<String, Integer> stampaCittaFrequente(Connection connection) {
		String SQL_STATEMENT = "SELECT citta, COUNT(*) AS residenti FROM persone GROUP BY citta ORDER BY residenti DESC";
		Map<String, Integer> statistica = new LinkedHashMap<>();
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(SQL_STATEMENT);
			while(result.next()) {
				statistica.put(result.getString("citta"), result.getInt("residenti"));
			}
			return statistica;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Map<String, Integer> nomiPiuComuni(Connection connection){
		String SQL_STATEMENT = "SELECT nome, COUNT(*) AS nomeComune FROM persone GROUP BY nome ORDER BY nomeComune DESC";
		Map<String, Integer> statistica = new LinkedHashMap<>();
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(SQL_STATEMENT);
			while(result.next()) {
				statistica.put(result.getString("nome"), result.getInt("nomeComune"));
			}
			return statistica;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
