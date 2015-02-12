package br.com.caelum.tubaina2.conversor.logica.sintaxe;

public class ConversorDeRefLabel implements ConversorDeSintaxe {

	private static final String REGEX_REF_LABEL = "\\[ref-label .*\\]";
	private static final String REPLACEMENT_REF_LABEL = "";
	
	@Override
	public String converte(String sintaxe) {
		return sintaxe.replaceAll(REGEX_REF_LABEL, REPLACEMENT_REF_LABEL);
	}

}
