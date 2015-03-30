package br.com.caelum.tubaina2.conversor.logica.sintaxe;

public class ConversorDeList implements ConversorDeSintaxe {

	private static final String REGEX_ABERTURA_LIST = "\\[list(.*)\\]";
	private static final String REGEX_FECHAMENTO_LIST = "\\[/list\\]";
	private static final String REPLACEMENT_LIST = "";
	
	@Override
	public String converte(String sintaxe) {
		return sintaxe
				.replaceAll(REGEX_ABERTURA_LIST, REPLACEMENT_LIST)
				.replaceAll(REGEX_FECHAMENTO_LIST, REPLACEMENT_LIST);
	}

}
