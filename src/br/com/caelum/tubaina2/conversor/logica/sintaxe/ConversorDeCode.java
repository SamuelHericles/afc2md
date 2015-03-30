package br.com.caelum.tubaina2.conversor.logica.sintaxe;

public class ConversorDeCode implements ConversorDeSintaxe {

	private static final String REGEX_ABERTURA_CODE = "\\[code(.*)\\]";
	private static final String REGEX_FECHAMENTO_CODE = "\\[/code\\]";
	private static final String REGEX_HIGHLIGHT = "h=(.*)";
	private static final String REPLACEMENT_ABERTURA_CODE = "```$1";
	private static final String REPLACEMENT_FECHAMENTO_CODE = "```";
	private static final String REPLACEMENT_HIGHLIGHT = "";

	@Override
	public String converte(String sintaxe) {
		return sintaxe
				.replaceAll(REGEX_ABERTURA_CODE, REPLACEMENT_ABERTURA_CODE)
				.replaceAll(REGEX_FECHAMENTO_CODE, REPLACEMENT_FECHAMENTO_CODE)
				.replaceAll(REGEX_HIGHLIGHT, REPLACEMENT_HIGHLIGHT);
	}
	
}
