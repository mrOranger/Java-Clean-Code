package serializzazione;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;

import backup.Persona;

public class Serializzazione {
	
	public static void main(String[] args) {
		
		Persona persona = new Persona("Edoardo", "Rossi", 21, "Milano");
		System.out.println("Prima della serializzazione ...");
		System.out.println(persona);
		
		salva(persona, "serializable.dat");
		persona = carica();
		
		System.out.println("Dopo la serializzazione ...");
		System.out.println(persona);
	}
	
	public static void salva(Persona persona, String path) {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path))){
			out.writeObject(persona);
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	public static Persona carica(){
		Persona persona = null;
		
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("serializable.dat"))){
			
			persona = (Persona)in.readObject();
			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} 
		return persona;
	}
	
	public static void salva(Collection<?> lista, String path) {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path))){
			out.writeObject(lista);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static Collection<?> carica(String path){
		Collection<?> persone = null;
		
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(path))){
			
			persone = (ArrayList<Persona>)in.readObject();
			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} 
		return persone;
	}

}
