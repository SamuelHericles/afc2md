package br.com.caelum.tubaina2.conversor.logica.sintaxe;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConversorDeBox implements ConversorDeSintaxe {

	private static final String REGEX_ABERTURA_BOX = "(?i)\\[box\\s*(.*?)\\]";
	private static final String FECHAMENTO_BOX = "[/box]";

	@Override
	public String converte(String sintaxe) {

		Pattern regexAbertura = Pattern.compile(REGEX_ABERTURA_BOX);
		StringBuilder convertido = new StringBuilder();

		String[] linhas = sintaxe.split("\\n");

		boolean dentroDeBox = false;

		for (String linha : linhas) {
			Matcher matcherAbertura = regexAbertura.matcher(linha.trim());
			if (matcherAbertura.find() && matcherAbertura.groupCount() >= 1) {
				dentroDeBox = true;
				String tituloBox = matcherAbertura.group(1);
				if (!tituloBox.isEmpty()) {
					convertido.append("> **" + tituloBox + "**\n")
							  .append("> \n");
				}
			} else if(FECHAMENTO_BOX.equalsIgnoreCase(linha.trim())){
				convertido.append("\n<!-- comentario para separar quotes adjacentes -->\n\n");
				dentroDeBox = false;
			} else {
				if(dentroDeBox){
					convertido.append("> " + linha.trim() + "\n");
				} else {
					convertido.append(linha + "\n");
				}
			}
		}

		return convertido.toString();
	}

}
