package mongodb;

import java.util.Map;
import sqlite.DatabaseConnection;
import sqlite.StatisticheDbRelazionale;

public class Main {
	
	public static void main(String[] args) {	
		DatabaseConnection sqlite = new DatabaseConnection();
		Map<String, Integer> statisticheResidenti = StatisticheDbRelazionale.stampaCittaFrequente(sqlite.connection);
		Map<String, Integer> statisticheNomi = StatisticheDbRelazionale.nomiPiuComuni(sqlite.connection);
		StatisticheDatabase statMongo = new StatisticheDatabase();
		statMongo.salvaStatistica(statisticheResidenti);
		statMongo.salvaStatistica(statisticheNomi);
		System.out.println('\n');
		statMongo.stampaStatisticheNomi();
		statMongo.stampaStatisticheResidenti();	
	}
}
