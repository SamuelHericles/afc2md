package br.com.caelum.tubaina2.conversor.logica.sintaxe;

public class ConversorDeImg implements ConversorDeSintaxe {

	private static final String REGEX_IMG = "(?is)\\[img\\s*(\\S+)[ ]?(w=[0-9]{1,3}%?)?(\\s*\"(.*?)\")?.*?\\]";
	private static final String REGEX_EMPTY_WIDTH = "[ ]\\{\\}(\\]\\(.*\\))";
	private static final String REPLACEMENT_IMG = "![$4 {$2}]($1)";
	private static final String REPLACEMENT_EMPTY_WIDTH = "$1";
	
	@Override
	public String converte(String sintaxe) {
		return sintaxe
				.replaceAll(REGEX_IMG, REPLACEMENT_IMG)
				.replaceAll(REGEX_EMPTY_WIDTH, REPLACEMENT_EMPTY_WIDTH);
	}
	
}
