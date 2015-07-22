package br.com.caelum.tubaina2.conversor.modelo;


public class MarkDown {

	private final int numero;
	private final String titulo;
	private final String conteudo;

	public MarkDown(int numero, String titulo, String conteudo) {
		this.numero = numero;
		this.titulo = titulo;
		this.conteudo = conteudo;
	}

	public int numero(){
		return numero;
	}

	public String titulo() {
		return titulo;
	}

	public String conteudo() {
		return conteudo;
	}

}
