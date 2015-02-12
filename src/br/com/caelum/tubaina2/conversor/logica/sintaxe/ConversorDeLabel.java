package br.com.caelum.tubaina2.conversor.logica.sintaxe;

public class ConversorDeLabel implements ConversorDeSintaxe {

	private static final String REGEX_LABEL = "\\[label .*\\]";
	private static final String REPLACEMENT_LABEL = "";
	
	@Override
	public String converte(String sintaxe) {
		return sintaxe.replaceAll(REGEX_LABEL, REPLACEMENT_LABEL);
	}

}
