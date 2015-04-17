package br.com.caelum.tubaina2.conversor.logica.sintaxe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ConversorDeRefLabelTest {

	private ConversorDeSintaxe convesor;

	@Before
	public void setUp() {
		convesor = new ConversorDeRefLabel();
	}

	@Test
	public void emUmaLinha() {
		Assert.assertEquals("", convesor.converte("[ref-label capitulo-branches-remotas]"));
	}

	@Test
	public void maiusculo() {
		Assert.assertEquals("", convesor.converte("[REF-LABEL capitulo-local]"));
	}

	@Test
	public void emMaisDeUmaLinha() {
		Assert.assertEquals("", convesor.converte("[ref-label\ncapitulo-branches-remotas]"));
	}
	
	
}
