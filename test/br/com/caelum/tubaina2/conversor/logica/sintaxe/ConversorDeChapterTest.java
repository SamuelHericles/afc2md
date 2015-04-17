package br.com.caelum.tubaina2.conversor.logica.sintaxe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ConversorDeChapterTest {

	private ConversorDeSintaxe convesor;

	@Before
	public void setUp() {
		convesor = new ConversorDeChapter();
	}

	@Test
	public void emUmaLinha() {
		Assert.assertEquals("", convesor.converte("[chapter Eclipse IDE]"));
	}

	@Test
	public void maiusculo() {
		Assert.assertEquals("", convesor.converte("[CHAPTER Templates com Facelets]"));
	}

	@Test
	public void emMaisDeUmaLinha() {
		Assert.assertEquals("", convesor.converte("[chapter  Apêndice\n - Problemas com concorrência]"));
	}
	
	
}
