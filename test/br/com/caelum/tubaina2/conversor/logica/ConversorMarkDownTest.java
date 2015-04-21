package br.com.caelum.tubaina2.conversor.logica;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.caelum.tubaina2.conversor.modelo.AFC;
import br.com.caelum.tubaina2.conversor.modelo.MarkDown;

public class ConversorMarkDownTest {

	private ConversorMarkDown conversor;

	@Before
	public void setUp(){
		conversor = new ConversorMarkDown();
	}

	@Test
	public void obtemTituloEmUmaLinha() throws IOException {
		String conteudoAFC = "[chapter AJAX com JSF 2]\n";
		AFC afc = new AFC(Paths.get(""), conteudoAFC, false);

		MarkDown md = conversor.converte(afc);
		
		String titulo = md.titulo();
		Assert.assertEquals("AJAX com JSF 2", titulo);
	}

	@Test
	public void obtemTituloComEspacosNaFrente() throws IOException {
		String conteudoAFC = "[chapter       AJAX com JSF 2]\n";
		AFC afc = new AFC(Paths.get(""), conteudoAFC, false);

		MarkDown md = conversor.converte(afc);
		
		String titulo = md.titulo();
		Assert.assertEquals("AJAX com JSF 2", titulo);
	}

	@Test
	public void obtemTituloComQuebraDeLinhaTabsEEspacosNaFrente() throws IOException {
		String conteudoAFC = "[chapter\n   \t\t \n   AJAX com JSF 2]\n";
		AFC afc = new AFC(Paths.get(""), conteudoAFC, false);

		MarkDown md = conversor.converte(afc);
		
		String titulo = md.titulo();
		Assert.assertEquals("AJAX com JSF 2", titulo);
	}

	@Test
	public void notesComCodeEInlineCode() throws IOException, URISyntaxException {
		AFC afc = criaAfcAPartirDoArquivo("/exemplos/afc/notes_com_code_e_inline_code.afc");
		
		MarkDown md = conversor.converte(afc);
		String conteudoMD = md.conteudo();
		
		String conteudoEsperadoMD = obtemMdEsperadoDoArquivo("/exemplos/md/notes_com_code_e_inline_code.md");
		Assert.assertEquals(conteudoEsperadoMD, conteudoMD);
	}

	public AFC criaAfcAPartirDoArquivo(String nomeAFC) throws URISyntaxException, IOException {
		Path pathAFC = Diretorio.getResourceAsPath(nomeAFC);
		String conteudoAFC = Diretorio.getPathContents(pathAFC);
		return new AFC(pathAFC, conteudoAFC, false);
	}

	public String obtemMdEsperadoDoArquivo(String nomeMD) throws URISyntaxException, IOException {
		Path pathMD = Diretorio.getResourceAsPath(nomeMD);
		return Diretorio.getPathContents(pathMD);
	}

}
