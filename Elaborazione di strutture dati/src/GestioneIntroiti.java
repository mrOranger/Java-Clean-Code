import java.util.List;
import java.util.OptionalDouble;

public class GestioneIntroiti {
	
	private List<IntroitoPunto> introiti;
	
	public GestioneIntroiti() {
		this.introiti = List.of(
				new IntroitoPunto("AB123", 120.00),
				new IntroitoPunto("AC345", 43.12),
				new IntroitoPunto("AD122", 2000.00),
				new IntroitoPunto("AK111", 1200.00)
		);
	}
	
	public double getTotale() {
		return this.introiti.stream().mapToDouble((introito) -> introito.getImporto()).sum();
	}
	
	public double getImportoMedio() {
		OptionalDouble optional = this.introiti.stream().mapToDouble((introito) -> introito.getImporto()).average();
		if(optional.isPresent()) {
			return optional.getAsDouble();
		}
		return -1d;
	}
	
	public void stampaIntroitiAlti() {
		this.introiti.stream().sorted((intro1, intro2) -> {
			return (int)(intro2.getImporto() - intro1.getImporto());
		}).limit(3).forEach(System.out::println);
	}
	
	public void stampaSuperamentoMedia() {
		this.introiti.stream().sorted((intro1, intro2) -> {
			return (int)(intro2.getImporto() - intro1.getImporto());
		}).filter((introito) -> {
			return introito.getImporto() > this.getImportoMedio();
		}).forEach(System.out::println);;
	}
}
