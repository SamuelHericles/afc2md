package br.com.caelum.tubaina2.conversor.logica.sintaxe;

public class ConversorDeExercise implements ConversorDeSintaxe {

	private static final String REGEX_ABERTURA_EXERCISE = "(?i)\\[EXERCISE\\]";
	private static final String REGEX_FECHAMENTO_EXERCISE = "(?i)\\[/EXERCISE\\]";
	private static final String REPLACEMENT_ABERTURA_EXERCISE = "";
	private static final String REPLACEMENT_FECHAMENTO_EXERCISE = "";

	@Override
	public String converte(String sintaxe) {
		return sintaxe.replaceAll(REGEX_ABERTURA_EXERCISE, REPLACEMENT_ABERTURA_EXERCISE).replaceAll(REGEX_FECHAMENTO_EXERCISE, REPLACEMENT_FECHAMENTO_EXERCISE);
	}

}
