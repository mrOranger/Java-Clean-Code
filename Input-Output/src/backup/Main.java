package backup;

/*
 * Creiamo un piccolo programma che si occupa del backup di un database
 * su un file di testo, usando il database SQLite e le classi viste finora.
 * Il programma esegue fondamentalmente due funzionalità:
 * - Salvataggio dei dati (Database -> File).
 * - Ripristino dei dati (File -> Database).
 */

public class Main {
	
	public static void main(String[] args) {
		DatabaseConnection sqlite = new DatabaseConnection();
		sqlite.eliminaDatabase();
		sqlite.popolaDb(50);
		BackupManager backup = new BackupManager();
		backup.backup("./", sqlite);
		sqlite.eliminaDatabase();
		backup.restore("backup_202207161008.txt", sqlite);
		sqlite.getPersone().stream().forEach(System.out::println);
		sqlite.chiudiConnessione();
	}

}
