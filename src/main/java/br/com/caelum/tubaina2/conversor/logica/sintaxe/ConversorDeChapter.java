package br.com.caelum.tubaina2.conversor.logica.sintaxe;

public class ConversorDeChapter implements ConversorDeSintaxe {

	private static final String REGEX_CHAPTER = "(?is)\\[CHAPTER\\s+(.*?)\\]";
	private static final String REPLACEMENT_CHAPTER = "# $1";

	@Override
	public String converte(String sintaxe) {
		return sintaxe.replaceAll(REGEX_CHAPTER, REPLACEMENT_CHAPTER);
	}

}
