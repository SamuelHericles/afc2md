package br.com.caelum.tubaina2.conversor.modelo;

import java.nio.file.Path;

public class MarkDown {

	private final Path path;
	private final String conteudo;

	public MarkDown(Path path, String conteudo) {
		this.path = path;
		this.conteudo = conteudo;
	}

	public Path path() {
		return path;
	}
	
	public String conteudo() {
		return conteudo;
	}
	
}
