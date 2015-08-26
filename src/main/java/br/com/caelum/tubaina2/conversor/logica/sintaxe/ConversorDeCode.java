package br.com.caelum.tubaina2.conversor.logica.sintaxe;

public class ConversorDeCode implements ConversorDeSintaxe {

	private static final String REGEX_HIGHLIGHT = "(?i)\\[code(.*)\\s+h=?\\s?\\d+?.*\\]";
	private static final String REPLACEMENT_HIGHLIGHT = "\\[code$1\\]";

	private static final String REGEX_CERQUILHA = "(?i)\\[code(.*)\\s+#\\]";
	private static final String REPLACEMENT_CERQUILHA = "\\[code$1\\]";

	private static final String REGEX_ABERTURA_CODE = "(?i)\\[code(.*?)\\]";
	private static final String REPLACEMENT_ABERTURA_CODE = "```$1";
	
	private static final String REGEX_FECHAMENTO_CODE = "(?i)\\[/code\\]";
	private static final String REPLACEMENT_FECHAMENTO_CODE = "```";

	@Override
	public String converte(String sintaxe) {
		return sintaxe
				.replaceAll(REGEX_HIGHLIGHT, REPLACEMENT_HIGHLIGHT)
				.replaceAll(REGEX_CERQUILHA, REPLACEMENT_CERQUILHA)
				.replaceAll(REGEX_ABERTURA_CODE, REPLACEMENT_ABERTURA_CODE)
				.replaceAll(REGEX_FECHAMENTO_CODE, REPLACEMENT_FECHAMENTO_CODE);
	}
	
}
