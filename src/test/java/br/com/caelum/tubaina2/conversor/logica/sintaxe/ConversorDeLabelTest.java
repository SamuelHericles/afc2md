package br.com.caelum.tubaina2.conversor.logica.sintaxe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ConversorDeLabelTest {
	
	private ConversorDeSintaxe conversor;

	@Before
	public void setUp() {
		conversor = new ConversorDeLabel();
	}

	@Test
	public void emUmaLinha() {
		Assert.assertEquals("", conversor.converte("[label capitulo-branches-remotas]"));
	}

	@Test
	public void maiusculo() {
		Assert.assertEquals("",	conversor.converte("[LABEL capitulo-tags]"));
	}

	@Test
	public void variosNaMesmaLinha() {
		Assert.assertEquals("",	conversor.converte("[label capitulo-github][label secao-github]"));
	}

	@Test
	public void variosEmVariasLinhas() {
		Assert.assertEquals("\n", conversor.converte("[label capitulo-github]\n[label secao-github]"));
	}

	@Test
	public void comEspacosNaFrente() {
		Assert.assertEquals("", conversor.converte("[label     capitulo-branches-locais]"));
	}

	@Test
	public void comQuebraDeLinhasTabsEEspacosNaFrente() {
		Assert.assertEquals("", conversor.converte("[label\n  \t\t   \n    capitulo-remoto]"));
	}

}
