package br.com.caelum.tubaina2.conversor.logica.sintaxe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ConversorDeTodoTest {

	private ConversorDeSintaxe convesor;

	@Before
	public void setUp() {
		convesor = new ConversorDeTodo();
	}

	@Test
	public void emUmaLinha() {
		Assert.assertEquals("<!--  exercicios -->", convesor.converte("[todo exercicios]"));
	}

	@Test
	public void maiusculo() {
		Assert.assertEquals("<!--  é imprescindível o desenho para isso -->", convesor.converte("[TODO é imprescindível o desenho para isso]"));
	}

	@Test
	public void emMaisDeUmaLinha() {
		String convertido = convesor.converte("[todo precisa mudar esse screenshot\n"
												+ " e colocar dados que\n"
												+ " pareçam de verdade]");
		String esperado = "<!--  precisa mudar esse screenshot\n"
											+ " e colocar dados que\n"
											+ " pareçam de verdade -->";
		Assert.assertEquals(esperado, convertido);
	}
	
	
}
