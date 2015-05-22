package br.com.caelum.tubaina2.conversor.logica.sintaxe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ConversorDeRefLabelTest {

	private ConversorDeSintaxe conversor;

	@Before
	public void setUp() {
		conversor = new ConversorDeRefLabel();
	}

	@Test
	public void emUmaLinha() {
		Assert.assertEquals("", conversor.converte("[ref-label capitulo-branches-remotas]"));
	}

	@Test
	public void maiusculo() {
		Assert.assertEquals("", conversor.converte("[REF-LABEL capitulo-local]"));
	}

	@Test
	public void emMaisDeUmaLinha() {
		Assert.assertEquals("", conversor.converte("[ref-label\ncapitulo-branches-locais]"));
	}
	
	@Test
	public void comEspacosNaFrente() {
		Assert.assertEquals("", conversor.converte("[ref-label     capitulo-tags]"));
	}

	@Test
	public void comQuebrasDeLinhaTabsEEspacosNaFrente() {
		Assert.assertEquals("", conversor.converte("[ref-label \n  \t\t \n capitulo-remoto]"));
	}

}
