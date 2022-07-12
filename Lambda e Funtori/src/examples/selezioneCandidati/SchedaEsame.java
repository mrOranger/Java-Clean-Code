package examples.selezioneCandidati;

public class SchedaEsame {
	
	private byte quizJava;
	private byte quizPhp;
	private byte quizLinux;
	private byte quizInglese;
	
	public byte getQuizJava() {
		return quizJava;
	}

	public void setQuizJava(byte quizJava) {
		this.quizJava = quizJava;
	}

	public byte getQuizPhp() {
		return quizPhp;
	}

	public void setQuizPhp(byte quizPhp) {
		this.quizPhp = quizPhp;
	}

	public byte getQuizLinux() {
		return quizLinux;
	}

	public void setQuizLinux(byte quizLinux) {
		this.quizLinux = quizLinux;
	}

	public byte getQuizInglese() {
		return quizInglese;
	}

	public void setQuizInglese(byte quizInglese) {
		this.quizInglese = quizInglese;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(this.quizJava + " quiz di Java\n");
		stringBuilder.append(this.quizPhp + " quiz di Php\n");
		stringBuilder.append(this.quizLinux + " quiz di Linux\n");
		stringBuilder.append(this.quizInglese + " quiz di Inglese\n");
		return stringBuilder.toString();
	}

}
