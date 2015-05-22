package br.com.caelum.tubaina2.conversor.modelo;

import java.nio.file.Path;

public class AFC {

	private final Path path;
	private final String conteudo;
	private final boolean primeiro;
	
	public AFC(Path path, String conteudo, boolean primeiro) {
		this.path = path;
		this.conteudo = conteudo;
		this.primeiro = primeiro;
	}

	public Path path() {
		return path;
	}

	public String conteudo() {
		return conteudo;
	}

	public boolean primeiro() {
		return primeiro;
	}
	
}
