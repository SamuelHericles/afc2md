package br.com.caelum.tubaina2.conversor.logica.sintaxe;

public class ConversorDeLabel implements ConversorDeSintaxe {

	private static final String REGEX_ABERTURA_LABEL = "(?is)\\[label\\s+.*?\\]";
	private static final String REGEX_FECHAMENTO_LABEL = "(?i)\\[/label(.*)\\]";
	private static final String REPLACEMENT_LABEL = "";
	@Override
	public String converte(String sintaxe) {
		return sintaxe
				.replaceAll(REGEX_ABERTURA_LABEL, REPLACEMENT_LABEL)
				.replaceAll(REGEX_FECHAMENTO_LABEL, REPLACEMENT_LABEL);
	}

}
