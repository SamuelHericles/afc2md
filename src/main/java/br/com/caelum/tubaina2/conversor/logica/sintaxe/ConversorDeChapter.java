package br.com.caelum.tubaina2.conversor.logica.sintaxe;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConversorDeChapter implements ConversorDeSintaxe {

	private static final String REGEX_CHAPTER = "(?is)\\[CHAPTER\\s+(.*?)\\]";
	private static final String REPLACEMENT_CHAPTER = "# $1";

	@Override
	public String converte(String sintaxe) {
		return sintaxe.replaceAll(REGEX_CHAPTER, REPLACEMENT_CHAPTER);
	}

	public static String titulo(String conteudo) {
		Matcher matcher = Pattern.compile(ConversorDeChapter.REGEX_CHAPTER)
				.matcher(conteudo);
		if (matcher.find() && matcher.groupCount() >= 1) {
			String titulo = matcher.group(1);
			if (titulo != null && !titulo.isEmpty()) {
				return titulo.trim();
			}
		}
		return "Capítulo sem título";
	}

}
