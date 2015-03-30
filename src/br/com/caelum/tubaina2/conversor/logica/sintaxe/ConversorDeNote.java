package br.com.caelum.tubaina2.conversor.logica.sintaxe;

public class ConversorDeNote implements ConversorDeSintaxe {

	private static final String REGEX_ABERTURA_NOTE = "\\[note\\]";
	private static final String REGEX_FECHAMENTO_NOTE = "\\[/note\\]";
	private static final String REPLACEMENT_ABERTURA_NOTE = "<!--";
	private static final String REPLACEMENT_FECHAMENTO_NOTE = "-->";

	@Override
	public String converte(String sintaxe) {
		return sintaxe
				.replaceAll(REGEX_ABERTURA_NOTE, REPLACEMENT_ABERTURA_NOTE)
				.replaceAll(REGEX_FECHAMENTO_NOTE, REPLACEMENT_FECHAMENTO_NOTE);
	}

}
