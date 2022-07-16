package backup;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;

public class BackupManager {
	
	private static final String BACKUP_FILE_NAME = "backup_";
	private static final String DATE_TIME_FORMAT = "yyyyMMddHHmm";
	private DateTimeFormatter formatoData;
	
	public BackupManager() {
		this.formatoData = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);
	}
	
	private String creaNomeFile(String path) {
		return path + File.separator + BACKUP_FILE_NAME + formatoData.format(LocalDateTime.now()) + ".txt";
	}
	
	public void backup(String path, DatabaseConnection database) {
		String nomeFile = this.creaNomeFile(path);
		StringBuilder stringBuilder = new StringBuilder();
		Iterator<Persona> iterator = database.getPersone().iterator();
		while(iterator.hasNext()) {
			stringBuilder.append(iterator.next());
			stringBuilder.append(System.getProperty("line.separator"));
		}
		try {
			Files.write(Paths.get(nomeFile), stringBuilder.toString().getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void restore(String nomeFile, DatabaseConnection database) {
		try {
			Files.readAllLines(Paths.get(nomeFile)).stream()
			.forEach((s) -> {
				String[] parti = s.split("-");
				database.inserisciPersona(new Persona(parti[0], parti[1], Integer.parseInt(parti[2]), parti[3]));
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
