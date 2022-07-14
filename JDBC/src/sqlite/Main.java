package sqlite;

import java.util.Map;

public class Main {
	
	public static void main(String[] args) {
		DatabaseConnection dbConnection = new DatabaseConnection();
		Map<String, Integer> cittaFrequenti = StatisticheDbRelazionale.stampaCittaFrequente(dbConnection.connection);
		Map<String, Integer> nomiComuni = StatisticheDbRelazionale.nomiPiuComuni(dbConnection.connection);
		
		System.out.println(cittaFrequenti);
		System.out.println("");
		System.out.println(nomiComuni);
		dbConnection.chiudiConnessione();
	}

}
