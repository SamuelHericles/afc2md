package br.com.caelum.tubaina2.conversor;

import java.nio.file.Path;

public class AFC {

	private final Path path;
	private final String conteudo;
	
	public AFC(Path path, String conteudo) {
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
