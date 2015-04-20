package br.com.caelum.tubaina2.conversor.modelo;

import java.nio.file.Path;

public class Summary {

	public static final String NOME_MD = "SUMMARY.md";
	public static final String TITULO_MD = "Sumário";

	private StringBuilder conteudo = new StringBuilder();
	
	public void adiciona(MarkDown md){
		conteudo.append(linha(md));		
	}
	
	private String linha(MarkDown md) {
		String titulo = md.titulo();
		Path fileName = md.path().getFileName();
		return "* ["+titulo+"]("+fileName+")\n";
	}
	
	public String conteudo() {
		return conteudo.toString();
	}
}
