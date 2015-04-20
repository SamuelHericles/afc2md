package br.com.caelum.tubaina2.conversor.logica.sintaxe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ConversorDeSectionTest {

	private ConversorDeSintaxe conversor;

	@Before
	public void setUp() {
		conversor = new ConversorDeSection();
	}

	@Test
	public void emUmaLinha() {
		Assert.assertEquals("## Lidando com requisições GET no JSF", conversor.converte("[section Lidando com requisições GET no JSF]"));
	}

	@Test
	public void maiusculo() {
		Assert.assertEquals("## Qualifiers do CDI", conversor.converte("[SECTION Qualifiers do CDI]"));
	}

	@Test
	public void emMaisDeUmaLinha() {
		String titulo = "Para saber mais: Melhorando a seleção de produtos\n"
						+ " na tela de itens com o Autocomplete";
		Assert.assertEquals("## "+titulo, conversor.converte("[section "+titulo+"]"));
	}
	
	@Test
	public void duasSeguidas(){
		String tituloPrimeira = "Bibliotecas de componentes";
		String tituloSegunda = "Melhorando a tela de adição de notas fiscais";
		String paragrafo = "Atualmente, as aplicações precisam ser amigáveis.\n\n";
		
		String convertido = conversor.converte("[section "+ tituloPrimeira+ "]\n\n"+paragrafo+"[section "+tituloSegunda+"]\n");
		String esperado = "## "+ tituloPrimeira+ "\n\n"+paragrafo+"## "+tituloSegunda+"\n";
		
		Assert.assertEquals(esperado, convertido);
	}
	
	@Test
	public void comEspacosNaFrente(){
		String convertido = conversor.converte("[section                Criando um novo repositório]");
		String esperado = "## Criando um novo repositório";
		
		Assert.assertEquals(esperado, convertido);
	}

	@Test
	public void comQuebrasDeLinhaTabsEEspacosNaFrente(){
		String convertido = conversor.converte("[section\n   \t\t    \n         Criando um novo repositório]");
		String esperado = "## Criando um novo repositório";
		
		Assert.assertEquals(esperado, convertido);
	}

}
