package gestione.biblioteca.servizi;

public class ServizioRiparazione implements Servizio{

	@Override
	public String ricezioneInoltro(Inoltro<?> inoltro) {
		return "Servizio di riparazione. \nRicevuto inoltro di " + inoltro.stampaScheda();
	}

}
