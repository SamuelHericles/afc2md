package br.com.caelum.tubaina2.conversor.logica.sintaxe;

public class ConversorDeTitle implements ConversorDeSintaxe {

	private static final String REGEX_TITLE = "\\[title (.*)\\]";
	private static final String REPLACEMENT_TITLE = "### $1";
	
	@Override
	public String converte(String sintaxe) {
		return sintaxe.replaceAll(REGEX_TITLE, REPLACEMENT_TITLE);
	}

}
