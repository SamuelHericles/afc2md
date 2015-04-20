package br.com.caelum.tubaina2.conversor.logica.sintaxe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ConversorDeIndexTest {

	private static final String TEXTO = "[img imagens/servlets/http.png w=50%]"
										+ "O comportamento das servlets que vamos ver neste capítulo foi definido na classe"
										+ " %%HttpServlet%% do pacote %%javax.servlet%%.";
	private ConversorDeSintaxe conversor;

	@Before
	public void setUp() {
		conversor = new ConversorDeIndex();
	}

	@Test
	public void emUmaLinha() {
		Assert.assertEquals("", conversor.converte("[index Managed Bean]"));
	}

	@Test
	public void maiusculo() {
		Assert.assertEquals("", conversor.converte("[INDEX Cabeçalho da nota fiscal]"));
	}

	@Test
	public void emMaisDeUmaLinha() {
		Assert.assertEquals("", conversor.converte("[index Branches por etapa\n de desenvolvimento]"));
	}

	@Test
	public void variosNaMesmaLinha() {
		Assert.assertEquals("", conversor.converte("[index Request][index Response]"));
	}

	@Test
	public void variosEmVariasLinhas() {
		Assert.assertEquals("\n", conversor.converte("[index Request]\n[index Response]"));
	}
	
	@Test
	public void variosEmVariasLinhasComTextoNoMeio() {
		Assert.assertEquals("\n"+TEXTO, conversor.converte("[index HTTP]\n"
													+ TEXTO
													+ "[index HttpServlet]"));
	}
	
	@Test
	public void comEspacosNaFrente() {
		Assert.assertEquals("", conversor.converte("[index         Propriedades de Breakpoint]"));
	}
	
	@Test
	public void comQuebraDeLinhasTabsEEspacosNaFrente() {
		Assert.assertEquals("", conversor.converte("[index\n  \t\t   \n    Propriedades de Breakpoint]"));
	}
	
}
