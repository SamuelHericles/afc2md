package br.com.caelum.tubaina2.conversor.modelo;

import java.nio.file.Path;

public class AFC {

	private final Path path;
	private final String conteudo;
	private boolean readme;
	
	public AFC(Path path, String conteudo) {
		this.path = path;
		this.conteudo = conteudo;
		this.readme = false;
	}

	public Path path() {
		return path;
	}

	public String conteudo() {
		return conteudo;
	}

	public boolean isReadme() {
		return readme;
	}
	
	public void tornaReadme() {
		this.readme = true;
	}

}
