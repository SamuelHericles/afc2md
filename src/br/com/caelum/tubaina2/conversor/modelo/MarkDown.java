package br.com.caelum.tubaina2.conversor.modelo;

import java.nio.file.Path;

public class MarkDown {

	private final Path path;
	private final String conteudo;
	private String titulo;

	public MarkDown(Path path, String conteudo, String titulo) {
		this.path = path;
		this.conteudo = conteudo;
		this.titulo = titulo;
	}

	public Path path() {
		return path;
	}
	
	public String conteudo() {
		return conteudo;
	}

	public String titulo() {
		return titulo;
	}
	
}
