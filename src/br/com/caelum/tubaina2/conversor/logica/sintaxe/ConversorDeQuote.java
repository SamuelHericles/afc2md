package br.com.caelum.tubaina2.conversor.logica.sintaxe;

import java.util.regex.Pattern;

public class ConversorDeQuote implements ConversorDeSintaxe {

	@Override
	public String converte(String sintaxe) {
		return Pattern.compile("\\[(?is)QUOTE (.*?)\\]").matcher(sintaxe).replaceAll("_$1_");
	}

}
