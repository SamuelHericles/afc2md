package br.com.caelum.tubaina2.conversor.logica.sintaxe;

public class ConversorDeIndex implements ConversorDeSintaxe {

	private static final String REGEX_INDEX = "\\[(?is)INDEX .*?\\]";
	private static final String REPLACEMENT_INDEX = "";
	
	@Override
	public String converte(String sintaxe) {
		return sintaxe.replaceAll(REGEX_INDEX, REPLACEMENT_INDEX);
	}

}
