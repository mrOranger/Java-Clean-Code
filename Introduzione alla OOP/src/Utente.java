
public class Utente {
	/* Variabili di istanza */
	private String username;
	private String password;
	private boolean sospeso;
	private Livello livelloUtente;
	
	/* Variabili di classe */
	public static final String PREFISSO_UTENTE = "user_";
	public static final String PREFISSO_ADMIN = "admin_";
	
	public static byte numeroProgressivo = 0; // Risparmiamo memoria
	
	public Utente(Livello livelloUtente) {
		this.livelloUtente = livelloUtente;
		this.impostaUsername(); // Separazione delle responsabilità
	}
	
	public void impostaUsername() {
		if(this.livelloUtente == Livello.UTENTE) {
			this.impostaUsernameUtente();
		}else {
			this.impostaUsernameAdmin();
		}
	}
	
	private void impostaUsernameUtente() {
		this.username = Utente.PREFISSO_UTENTE + (Utente.numeroProgressivo++);
	}
	
	private void impostaUsernameAdmin() {
		this.username = Utente.PREFISSO_ADMIN + (Utente.numeroProgressivo++);
	}
	
	public void setPassword(String password) {
		if(password.length() < 10) {
			System.out.println("*** La password deve contenere almeno 10 caratteri ***");
		}else {
			this.password = password;
		}
	}
	
	public void sospendiUtente() {
		this.sospeso = true;
	}
	
	public void reintegraUtente() {
		this.sospeso = false;
	}
	
	public void stampaDescrizione() {
		System.out.println("\n Utente : " + this.username);
		String livello = switch(this.livelloUtente) {
			case UTENTE: {
				yield "Livello : Utente";
			}
			case AMMINISTRATORE: {
				yield "Livello: Amministratore";
			}
		};
		System.out.println(livello);
		if(this.password == null) {
			System.out.println("Password non valida!");
		}else {
			System.out.println("Password OK!");
		}
		System.out.println("Sospeso: " + (this.sospeso ? "Si" : "No"));
	}
}
