package br.com.caelum.tubaina2.conversor.logica.sintaxe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ConversorDeChapterTest {

	private ConversorDeSintaxe conversor;

	@Before
	public void setUp() {
		conversor = new ConversorDeChapter();
	}

	@Test
	public void emUmaLinha() {
		Assert.assertEquals("# Eclipse IDE", conversor.converte("[chapter Eclipse IDE]"));
	}

	@Test
	public void maiusculo() {
		Assert.assertEquals("# Templates com Facelets", conversor.converte("[CHAPTER Templates com Facelets]"));
	}

	@Test
	public void emMaisDeUmaLinha() {
		Assert.assertEquals("# Apêndice\n - Problemas com concorrência", conversor.converte("[chapter Apêndice\n - Problemas com concorrência]"));
	}
	
	@Test
	public void comEspacosNaFrente() {
		Assert.assertEquals("# Ajax com JSF 2", conversor.converte("[chapter            Ajax com JSF 2]"));
	}

	@Test
	public void comQuebraDeLinhaTabsEEspacosNaFrente() {
		Assert.assertEquals("# Apêndice - Internacionalização: sua aplicação em várias línguas", conversor.converte("[chapter\n   \t\t \n   Apêndice - Internacionalização: sua aplicação em várias línguas]"));
	}

}
