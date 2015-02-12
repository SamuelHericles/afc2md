package br.com.caelum.tubaina2.conversor.logica;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import br.com.caelum.tubaina2.conversor.modelo.AFC;
import br.com.caelum.tubaina2.conversor.modelo.MarkDown;

public class ConversorMarkDown {
	
	public MarkDown converte(AFC afc) throws IOException {
		String conteudoAFC = afc.conteudo();
		String conteudoMD = converteConteudo(conteudoAFC);
		Path pathMD = Paths.get(afc.path().toString().replace(".afc", ".md"));
		
		return new MarkDown(pathMD, conteudoMD);
	}

	private String converteConteudo(String conteudoAFC) {
		return conteudoAFC
				.replaceAll("\\[title (.*)\\]", "### $1")
				.replaceAll("\\[section (.*)\\]", "## $1")
				.replaceAll("\\[box (.*)\\]", "> **$1**")
				.replaceAll("\\[/box\\]", "")
				.replaceAll("\\[code(.*)\\]", "```$1")
				.replaceAll("\\[/code\\]", "```")
				.replaceAll("(?s)\\:\\:(.*?)\\:\\:", "_$1_")
				.replaceAll("(?s)%%(.*?)%%", "`$1`")
				.replaceAll(
						"\\[img (\\S+)[ ]?(w=[0-9]{1,3})?([ ]\"(.*)\")?\\]",
						"![$4 {$2}]($1)")
				.replaceAll("[ ]\\{\\}(\\]\\(.*\\))", "$1")
				.replaceAll("\\[index .*\\]", "")
				.replaceAll("\\[label .*\\]", "")
				.replaceAll("\\[ref-label .*\\]", "");
	}

}
