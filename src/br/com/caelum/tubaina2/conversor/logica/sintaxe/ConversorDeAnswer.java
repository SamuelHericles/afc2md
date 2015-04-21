package br.com.caelum.tubaina2.conversor.logica.sintaxe;

public class ConversorDeAnswer implements ConversorDeSintaxe {

	@Override
	public String converte(String sintaxe) {
		return sintaxe.replaceAll("(?is)[ \t]*\\[ANSWER\\](.*?)\\[/ANSWER\\]\\s*", "");
	}

}
