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
		Assert.assertEquals("<!-- exercicios -->", convesor.converte("[todo exercicios]"));
	}

	@Test
	public void maiusculo() {
		Assert.assertEquals("<!-- é imprescindível o desenho para isso -->", convesor.converte("[TODO é imprescindível o desenho para isso]"));
	}

	@Test
	public void emMaisDeUmaLinha() {
		String convertido = convesor.converte("[todo precisa mudar esse screenshot\n"
												+ " e colocar dados que\n"
												+ " pareçam de verdade]");
		String esperado = "<!-- precisa mudar esse screenshot\n"
											+ " e colocar dados que\n"
											+ " pareçam de verdade -->";
		Assert.assertEquals(esperado, convertido);
	}
	
	@Test
	public void duasSeguidas(){
		String uma = "falar do @Default tbm; talvez @New";
		String outra = "imagem desenhando um wizard com varias paginas encadeadas";
		String paragrafo = "Imagine que nossa %%NotaFiscal%% necessite de muitos dados além de CNPJ e data.\n\n";
		
		String convertido = convesor.converte("[TODO "+ uma+ "]\n\n"+paragrafo+"[TODO "+outra+"]\n");
		String esperado = "<!-- "+ uma+ " -->\n\n"+paragrafo+"<!-- "+outra+" -->\n";
		
		Assert.assertEquals(esperado, convertido);
	}

	
}
