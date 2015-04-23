package br.com.caelum.tubaina2.conversor.logica.sintaxe;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.caelum.tubaina2.conversor.logica.sintaxe.ConversorDeParagrafo.AjudanteDeParsingDeCode;

public class ConversorDeBox implements ConversorDeSintaxe {

	private static final Pattern REGEX_ABERTURA_BOX = Pattern.compile("(?i)\\[box\\s*(.*?)\\]");
	private static final String FECHAMENTO_BOX = "[/box]";

	private AjudanteDeParsingDeCode code;
	
	@Override
	public String converte(String sintaxe) {
		code = new AjudanteDeParsingDeCode();

		
		StringBuilder convertido = new StringBuilder();

		String[] linhas = sintaxe.split("\\n");

		boolean dentroDeBox = false;

		for (String linha : linhas) {
			code.emNovaLinha();
			
			Matcher matcherAbertura = REGEX_ABERTURA_BOX.matcher(linha.trim());
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
					code.verificaSeEstaDentro(linha);
					if(code.naoEstaDentroNemAbrindoNemFechando()) {
						convertido.append("> " + linha.trim() + "\n");
					} else {
						convertido.append("> " + linha + "\n");
					}
				} else {
					convertido.append(linha + "\n");
				}
			}
		}

		return convertido.toString();
	}

}
