package br.com.caelum.tubaina2.conversor.logica.sintaxe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ConversorDeQuoteTest {

	private static final String GHANDI = "\"Olho por olho, e o mundo acabará cego.\"--Ghandi";
	private static final String DA_VINCI = "\"Quem pouco pensa, engana-se muito.\"--Leonardo da Vinci";
	private static final String SHAW = "\"A ciência nunca resolve um problema sem criar mais dez\" -- George Bernard Shaw";
	private static final String ARISTOTELES = "\"A grandeza não consiste em receber honras, mas em merecê-las.\" -- Aristóteles";
	private static final String VOLTAIRE = "\"Eu respeito o poder eterno, não cabe a mim determinar seus limites, eu não afirmo nada,\n"
											+ " contento-me em crer que sejam possíveis mais coisas do que nós pensamos.\"\n"
											+ " -- Voltaire, Micromegas, considerado o primeiro conto de ficção científica da história";
	
	private ConversorDeSintaxe conversor;

	@Before
	public void setUp() {
		conversor = new ConversorDeQuote();
	}

	@Test
	public void emUmaLinha() {
		Assert.assertEquals("_"+ARISTOTELES+"_", conversor.converte("[quote "+ARISTOTELES+"]"));
	}

	@Test
	public void maiusculo() {
		Assert.assertEquals("_"+SHAW+"_", conversor.converte("[QUOTE "+SHAW+"]"));
	}

	@Test
	public void emMaisDeUmaLinha() {
		Assert.assertEquals("_"+VOLTAIRE+"_", conversor.converte("[quote "+VOLTAIRE+"]"));
	}

	@Test
	public void comEspacosNaFrente() {
		Assert.assertEquals("_"+GHANDI+"_", conversor.converte("[quote          "+GHANDI+"]"));
	}

	@Test
	public void comQuebrasDeLinhaTabsEEspacosNaFrente() {
		Assert.assertEquals("_"+DA_VINCI+"_", conversor.converte("[quote\n   \t\t   \n    "+DA_VINCI+"]"));
	}
	
}
