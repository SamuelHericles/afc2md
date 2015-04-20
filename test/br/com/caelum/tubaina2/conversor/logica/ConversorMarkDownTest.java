package br.com.caelum.tubaina2.conversor.logica;

import java.io.IOException;
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
		AFC afc = new AFC(Paths.get(""), conteudoAFC);

		MarkDown md = conversor.converte(afc);
		
		String titulo = md.titulo();
		Assert.assertEquals("AJAX com JSF 2", titulo);
	}

	@Test
	public void obtemTituloComEspacosNaFrente() throws IOException {
		String conteudoAFC = "[chapter       AJAX com JSF 2]\n";
		AFC afc = new AFC(Paths.get(""), conteudoAFC);

		MarkDown md = conversor.converte(afc);
		
		String titulo = md.titulo();
		Assert.assertEquals("AJAX com JSF 2", titulo);
	}

	@Test
	public void obtemTituloComQuebraDeLinhaTabsEEspacosNaFrente() throws IOException {
		String conteudoAFC = "[chapter\n   \t\t \n   AJAX com JSF 2]\n";
		AFC afc = new AFC(Paths.get(""), conteudoAFC);

		MarkDown md = conversor.converte(afc);
		
		String titulo = md.titulo();
		Assert.assertEquals("AJAX com JSF 2", titulo);
	}

}
