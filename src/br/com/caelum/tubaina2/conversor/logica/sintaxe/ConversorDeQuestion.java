package br.com.caelum.tubaina2.conversor.logica.sintaxe;

public class ConversorDeQuestion implements ConversorDeSintaxe {

	private static final String REGEX_ABERTURA_QUESTION = "(?i)\\[QUESTION\\]";
	private static final String REGEX_FECHAMENTO_QUESTION = "(?i)\\[/QUESTION\\]";

	@Override
	public String converte(String sintaxe) {
		return sintaxe.replaceAll(REGEX_ABERTURA_QUESTION, "").replaceAll(REGEX_FECHAMENTO_QUESTION, "");
	}

}
