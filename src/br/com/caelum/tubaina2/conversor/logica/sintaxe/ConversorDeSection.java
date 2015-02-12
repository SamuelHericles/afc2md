package br.com.caelum.tubaina2.conversor.logica.sintaxe;

public class ConversorDeSection implements ConversorDeSintaxe {

	private static final String REGEX_SECTION = "\\[section (.*)\\]";
	private static final String REPLACEMENT_SECTION = "## $1";
	
	@Override
	public String converte(String sintaxe) {
		return sintaxe.replaceAll(REGEX_SECTION, REPLACEMENT_SECTION);
	}

}
