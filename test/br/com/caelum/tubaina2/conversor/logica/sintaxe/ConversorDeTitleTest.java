package br.com.caelum.tubaina2.conversor.logica.sintaxe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ConversorDeTitleTest {

	private ConversorDeSintaxe convesor;

	@Before
	public void setUp() {
		convesor = new ConversorDeTitle();
	}

	@Test
	public void emUmaLinha() {
		Assert.assertEquals("### Recebendo dados e adicionando comportamentos", convesor.converte("[title Recebendo dados e adicionando comportamentos]"));
	}

	@Test
	public void maiusculo() {
		Assert.assertEquals("### Wizard para notas fiscais", convesor.converte("[TITLE Wizard para notas fiscais]"));
	}

	@Test
	public void emMaisDeUmaLinha() {
		String convertido = convesor.converte("[title Onde devo abrir e fechar minhas conexões\n"
												+ " e transações com o banco de dados?]");
		String esperado = "### Onde devo abrir e fechar minhas conexões\n"
							+ " e transações com o banco de dados?";
		Assert.assertEquals(esperado, convertido);
	}
	
	
}
