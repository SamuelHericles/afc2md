package br.com.caelum.tubaina2.conversor.logica.sintaxe;

public class ConversorDeBox implements ConversorDeSintaxe {

	private static final String REGEX_ABERTURA_BOX = "\\[box (.*)\\]";
	private static final String REGEX_FECHAMENTO_BOX = "\\[/box\\]";
	private static final String REPLACEMENT_ABERTURA_BOX = "> **$1**";
	private static final String REPLACEMENT_FECHAMENTO_BOX = "";

	@Override
	public String converte(String sintaxe) {
		return sintaxe
				.replaceAll(REGEX_ABERTURA_BOX, REPLACEMENT_ABERTURA_BOX)
				.replaceAll(REGEX_FECHAMENTO_BOX, REPLACEMENT_FECHAMENTO_BOX);
	}

}
