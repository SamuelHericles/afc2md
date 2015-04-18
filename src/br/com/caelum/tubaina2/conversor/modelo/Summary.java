package br.com.caelum.tubaina2.conversor.modelo;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Summary {

	private StringBuilder conteudo = new StringBuilder();
	
	public void adiciona(MarkDown md){
		conteudo.append(linha(md));		
	}
	
	private String linha(MarkDown md) {
		String titulo = md.titulo();
		Path fileName = md.path().getFileName();
		return "* ["+titulo+"]("+fileName+")\n";
	}
	
	public MarkDown emMd(){
		Path path = Paths.get("SUMMARY.md");
		return new MarkDown(path, conteudo.toString(), "Sumário");
	}
}
