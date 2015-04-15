package br.com.caelum.tubaina2.conversor.logica.sintaxe;

public class ConversorDeTodo implements ConversorDeSintaxe {

	private static final String REGEX_TODO = "\\[(?is)TODO(.*)\\]";
	private static final String REPLACEMENT_TODO = "<!-- $1 -->";

	@Override
	public String converte(String sintaxe) {
		return sintaxe.replaceAll(REGEX_TODO, REPLACEMENT_TODO);
	}
	
}
