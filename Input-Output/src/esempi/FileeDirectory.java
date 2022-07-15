package esempi;

import java.io.File;

import eccezioni.FileNotFoundException;

public class FileeDirectory {
	
	public static void main(String[] args) {
		
		String path = "." + File.separator + "src" + File.separator + "esempi" + File.separator + "persona.txt";
		
		FileeDirectory.stampaDirectory();
		FileeDirectory.stampaFileInfo(path);
		
		System.exit(0);
	}
	
	public static void stampaFileInfo(String path) {
		File file = new File(path);
		if(file.exists()) {
			System.out.println("Il file si trova in " + file.getAbsolutePath() + "  occupa " + file.length() + " byte");
		} else {
			throw new FileNotFoundException("File non trovato!");
		}
	}
	
	public static void stampaDirectory() {
		File directory = new File("./");
		for(File f : directory.listFiles()) {
			if(f.isDirectory()) {
				System.out.println(f.getName() + " (directory)");
			} else {
				System.out.println(f.getName() + " - " + f.length() + " byte");
			}
		}		
	}

}
