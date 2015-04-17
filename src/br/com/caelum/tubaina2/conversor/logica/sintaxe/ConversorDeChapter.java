package br.com.caelum.tubaina2.conversor.logica.sintaxe;

public class ConversorDeChapter implements ConversorDeSintaxe {

	public static final String REGEX_CHAPTER = "\\[(?is)CHAPTER (.*?)\\]";

	@Override
	public String converte(String sintaxe) {
		return sintaxe.replaceAll(REGEX_CHAPTER, "");
	}

}
