package br.com.caelum.tubaina2.conversor.logica.sintaxe;

public class ConversorDeItalico implements ConversorDeSintaxe {

	private static final String REGEX_ITALICO = "(?s)\\:\\:(.*?)\\:\\:";
	private static final String REPLACEMENT_ITALICO = "_$1_";
	
	@Override
	public String converte(String sintaxe) {
		return sintaxe.replaceAll(REGEX_ITALICO, REPLACEMENT_ITALICO);
	}

}
