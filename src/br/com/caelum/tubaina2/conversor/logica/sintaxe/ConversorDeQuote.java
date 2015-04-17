package br.com.caelum.tubaina2.conversor.logica.sintaxe;


public class ConversorDeQuote implements ConversorDeSintaxe {

	private static final String REGEX_QUOTE = "\\[(?is)QUOTE (.*?)\\]";
	private static final String REPLACEMENT_QUOTE = "_$1_";

	@Override
	public String converte(String sintaxe) {
		return sintaxe.replaceAll(REGEX_QUOTE, REPLACEMENT_QUOTE);
	}

}
