package br.com.caelum.tubaina2.conversor.logica.sintaxe;

public class ConversorDeQuestion implements ConversorDeSintaxe {

	private static final String REGEX_QUESTION = "(?is)\\[QUESTION\\]\\s*(.*?)\\[/QUESTION\\]";
	private static final String REPLACEMENT_QUESTION = "1. $1";

	@Override
	public String converte(String sintaxe) {
		return sintaxe.replaceAll(REGEX_QUESTION, REPLACEMENT_QUESTION);
	}

}
