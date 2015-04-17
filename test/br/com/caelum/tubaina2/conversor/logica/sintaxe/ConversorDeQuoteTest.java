package br.com.caelum.tubaina2.conversor.logica.sintaxe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ConversorDeQuoteTest {

	private static final String ARISTOTELES = "\"A grandeza não consiste em receber honras, mas em merecê-las.\" -- Aristóteles";
	private static final String SHAW = "\"A ciência nunca resolve um problema sem criar mais dez\" -- George Bernard Shaw";
	private static final String VOLTAIRE = "\"Eu respeito o poder eterno, não cabe a mim determinar seus limites, eu não afirmo nada,\n"
											+ " contento-me em crer que sejam possíveis mais coisas do que nós pensamos.\"\n"
											+ " -- Voltaire, Micromegas, considerado o primeiro conto de ficção científica da história";
	
	private ConversorDeSintaxe convesor;

	@Before
	public void setUp() {
		convesor = new ConversorDeQuote();
	}

	@Test
	public void emUmaLinha() {
		Assert.assertEquals("_"+ARISTOTELES+"_", convesor.converte("[quote "+ARISTOTELES+"]"));
	}

	@Test
	public void maiusculo() {
		Assert.assertEquals("_"+SHAW+"_", convesor.converte("[QUOTE "+SHAW+"]"));
	}

	@Test
	public void emMaisDeUmaLinha() {
		Assert.assertEquals("_"+VOLTAIRE+"_", convesor.converte("[quote "+VOLTAIRE+"]"));
	}
	
	
}
