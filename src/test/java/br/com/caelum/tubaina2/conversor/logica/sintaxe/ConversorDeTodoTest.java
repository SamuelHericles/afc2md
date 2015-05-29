package br.com.caelum.tubaina2.conversor.logica.sintaxe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ConversorDeTodoTest {

	private ConversorDeSintaxe conversor;

	@Before
	public void setUp() {
		conversor = new ConversorDeTodo();
	}

	@Test
	public void emUmaLinha() {
		Assert.assertEquals("<!--@todo exercicios -->", conversor.converte("[todo exercicios]"));
	}

	@Test
	public void maiusculo() {
		Assert.assertEquals("<!--@todo é imprescindível o desenho para isso -->", conversor.converte("[TODO é imprescindível o desenho para isso]"));
	}

	@Test
	public void emMaisDeUmaLinha() {
		String convertido = conversor.converte("[todo precisa mudar esse screenshot\n"
												+ " e colocar dados que\n"
												+ " pareçam de verdade]");
		String esperado = "<!--@todo precisa mudar esse screenshot\n"
											+ " e colocar dados que\n"
											+ " pareçam de verdade -->";
		Assert.assertEquals(esperado, convertido);
	}
	
	@Test
	public void duasSeguidas(){
		String uma = "falar do @Default tbm; talvez @New";
		String outra = "imagem desenhando um wizard com varias paginas encadeadas";
		String paragrafo = "Imagine que nossa %%NotaFiscal%% necessite de muitos dados além de CNPJ e data.\n\n";
		
		String convertido = conversor.converte("[TODO "+ uma+ "]\n\n"+paragrafo+"[TODO "+outra+"]\n");
		String esperado = "<!--@todo "+ uma+ " -->\n\n"+paragrafo+"<!--@todo "+outra+" -->\n";
		
		Assert.assertEquals(esperado, convertido);
	}

	@Test
	public void comEspacosNaFrente(){
		String convertido = conversor.converte("[TODO          nesse paragrafo ha a confusão clássica de IoC e DI; arrumar isso]");
		String esperado = "<!--@todo nesse paragrafo ha a confusão clássica de IoC e DI; arrumar isso -->";
		
		Assert.assertEquals(esperado, convertido);
	}

	@Test
	public void comQuebrasDeLinhaTabsEEspacosNaFrente(){
		String convertido = conversor.converte("[TODO\n   \t\t    \n         jsf2: flash]");
		String esperado = "<!--@todo jsf2: flash -->";
		
		Assert.assertEquals(esperado, convertido);
	}
	
}
