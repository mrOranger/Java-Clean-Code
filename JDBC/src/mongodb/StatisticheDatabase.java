package mongodb;

import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Consumer;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class StatisticheDatabase {
	
	private MongoClient client;
	private MongoDatabase database;
	private static final String STAT_RESIDENTI = "StatisticaResidenti";
	private static final String STAT_NOMI = "StatisticheNomi";
	
	public StatisticheDatabase() {
		this.client = new MongoClient("localhost", 27017);
		this.database = client.getDatabase("Statistiche");
		this.svuotaDatabase();
	}
	
	private void svuotaDatabase() {
		if(this.database != null) {
			for(String nome : this.database.listCollectionNames()) {
				this.database.getCollection(nome).drop();
			}
		}
	}
	
	public void salvaStatistica(Map<String, Integer> statistica) {
		MongoCollection<Document> collection = database.getCollection(STAT_RESIDENTI);
		for(Entry<String, Integer> entry : statistica.entrySet()) {
			Document document = new Document(entry.getKey(), entry.getValue());
			collection.insertOne(document);
		}
	}
	
	private void stampaCollection(String nome) {
		this.database.getCollection(nome).find().forEach((Consumer<? super Document>)System.out::println);
	}
	
	public void stampaStatisticheResidenti() {
		this.stampaCollection(STAT_RESIDENTI);
	}
	
	public void stampaStatisticheNomi() {
		this.stampaCollection(STAT_NOMI);
	}
}
