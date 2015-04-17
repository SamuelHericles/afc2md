package br.com.caelum.tubaina2.conversor.logica.sintaxe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ConversorDeSectionTest {

	private ConversorDeSintaxe convesor;

	@Before
	public void setUp() {
		convesor = new ConversorDeSection();
	}

	@Test
	public void emUmaLinha() {
		Assert.assertEquals("## Lidando com requisições GET no JSF", convesor.converte("[section Lidando com requisições GET no JSF]"));
	}

	@Test
	public void maiusculo() {
		Assert.assertEquals("## Qualifiers do CDI", convesor.converte("[SECTION Qualifiers do CDI]"));
	}

	@Test
	public void emMaisDeUmaLinha() {
		String trecho = "Para saber mais: Melhorando a seleção de produtos\n"
						+ " na tela de itens com o Autocomplete";
		Assert.assertEquals("## "+trecho, convesor.converte("[section "+trecho+"]"));
	}
	
	@Test
	public void duasSeguidas(){
		String uma = "Bibliotecas de componentes";
		String outra = "Melhorando a tela de adição de notas fiscais";
		String paragrafo = "Atualmente, as aplicações precisam ser amigáveis.\n\n";
		
		String convertido = convesor.converte("[section "+ uma+ "]\n\n"+paragrafo+"[section "+outra+"]\n");
		String esperado = "## "+ uma+ "\n\n"+paragrafo+"## "+outra+"\n";
		
		Assert.assertEquals(esperado, convertido);
	}
	
}
