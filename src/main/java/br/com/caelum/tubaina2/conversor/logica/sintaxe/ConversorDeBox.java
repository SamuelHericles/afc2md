package br.com.caelum.tubaina2.conversor.logica.sintaxe;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.caelum.tubaina2.conversor.logica.sintaxe.ConversorDeParagrafo.AjudanteDeParsingDeCode;

public class ConversorDeBox implements ConversorDeSintaxe {

	private AjudanteDeParsingDeBox box;
	private AjudanteDeParsingDeCode code;
	
	@Override
	public String converte(String sintaxe) {
		box = new AjudanteDeParsingDeBox();
		code = new AjudanteDeParsingDeCode();
		
		StringBuilder convertido = new StringBuilder();

		String[] linhas = sintaxe.split("\\n");

		for (String linha : linhas) {
			code.emNovaLinha();
			
			boolean abrindoBox = box.estaAbrindoBox(linha);
			boolean fechandoBox = box.estaFechandoBox(linha);
			if(abrindoBox){
				trataAberturaBox(convertido);
			}
			if(fechandoBox){
				trataFechamentoBox(convertido);
			} 
			
			if(!abrindoBox && !fechandoBox){
				trataTextoNormal(convertido, linha);
			}
		}

		return convertido.toString();
	}

	private void trataAberturaBox(StringBuilder convertido) {
		box.entrou();
		if(box.temTitulo()){
			adicionaTituloDeBox(convertido);
		}
	}

	private void trataFechamentoBox(StringBuilder convertido) {
		adicionaFechamentoDeBox(convertido);
		box.saiu();
	}

	private void trataTextoNormal(StringBuilder convertido, String linha) {
		if(box.estaDentro()){
			trataTextoDentroDoBox(convertido, linha);
		} else {
			adicionaTextoForaDoBox(convertido, linha);
		}
	}

	private void trataTextoDentroDoBox(StringBuilder convertido, String linha) {
		code.verificaSeEstaDentro(linha);
		if(code.naoEstaDentroNemAbrindoNemFechando()) {
			adicionaTextoNormalDentroDoBox(convertido, linha);
		} else {
			adicionaCodeDentroDoBox(convertido, linha);
		}
	}

	private void adicionaTituloDeBox(StringBuilder convertido) {
		convertido.append("> **" + box.titulo() + "**\n").append("> \n");
	}

	private void adicionaFechamentoDeBox(StringBuilder convertido) {
		convertido.append("\n<!-- comentario para separar quotes adjacentes -->\n\n");
	}

	private void adicionaTextoForaDoBox(StringBuilder convertido, String linha) {
		convertido.append(linha + "\n");
	}

	private void adicionaCodeDentroDoBox(StringBuilder convertido, String linha) {
		convertido.append("> " + linha + "\n");
	}

	private void adicionaTextoNormalDentroDoBox(StringBuilder convertido,
			String linha) {
		convertido.append("> " + linha.trim() + "\n");
	}

	static class AjudanteDeParsingDeBox {
		private static final Pattern REGEX_ABERTURA_BOX = Pattern.compile("(?i)\\[box\\s*(.*?)\\]");
		private static final String FECHAMENTO_BOX = "[/box]";

		private boolean dentro;
		private String titulo;

		AjudanteDeParsingDeBox() {
			dentro = false;
			titulo = null;
		}

		String titulo() {
			return titulo;
		}

		void entrou() {
			dentro = true;
		}

		void saiu() {
			dentro = false;
		}
		
		boolean estaDentro(){
			return dentro;
		}
		
		boolean estaAbrindoBox(String linha){
			Matcher matcherAbertura = REGEX_ABERTURA_BOX.matcher(linha.trim());
			if (matcherAbertura.find() && matcherAbertura.groupCount() >= 1) {
				titulo = matcherAbertura.group(1);
				return true;
			}
			return false;
		}
		
		boolean estaFechandoBox(String linha){
			return linha.trim().toLowerCase().endsWith(FECHAMENTO_BOX);
		}
		
		boolean temTitulo(){
			return titulo != null && !titulo.isEmpty(); 
		}
	}

}
