package br.com.caelum.tubaina2.conversor.logica.sintaxe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ConversorDeIndexTest {

	private static final String TEXTO = "[img imagens/servlets/http.png w=50%]"
										+ "O comportamento das servlets que vamos ver neste capítulo foi definido na classe"
										+ " %%HttpServlet%% do pacote %%javax.servlet%%.";
	private ConversorDeSintaxe convesor;

	@Before
	public void setUp() {
		convesor = new ConversorDeIndex();
	}

	@Test
	public void emUmaLinha() {
		Assert.assertEquals("", convesor.converte("[index Managed Bean]"));
	}

	@Test
	public void maiusculo() {
		Assert.assertEquals("", convesor.converte("[INDEX Cabeçalho da nota fiscal]"));
	}

	@Test
	public void emMaisDeUmaLinha() {
		Assert.assertEquals("", convesor.converte("[index Branches por etapa\n de desenvolvimento]"));
	}

	@Test
	public void variosNaMesmaLinha() {
		Assert.assertEquals("", convesor.converte("[index Request][index Response]"));
	}

	@Test
	public void variosEmVariasLinhas() {
		Assert.assertEquals("\n", convesor.converte("[index Request]\n[index Response]"));
	}
	
	@Test
	public void variosEmVariasLinhasComTextoNoMeio() {
		Assert.assertEquals("\n"+TEXTO, convesor.converte("[index HTTP]\n"
													+ TEXTO
													+ "[index HttpServlet]"));
	}
}
