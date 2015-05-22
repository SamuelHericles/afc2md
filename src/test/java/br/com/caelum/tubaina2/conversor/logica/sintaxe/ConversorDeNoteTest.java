package br.com.caelum.tubaina2.conversor.logica.sintaxe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ConversorDeNoteTest {

	private ConversorDeSintaxe conversor;

	@Before
	public void setUp() {
		conversor = new ConversorDeNote();
	}

	@Test
	public void emUmaLinha() {
		String nota = "[note]Mostre também a solução com soma de progressão aritmética.[/note]";
		
		String convertido = conversor.converte(nota);
		
		String esperado =   "<!-- @note Mostre também a solução com soma de progressão aritmética. -->";
		
		Assert.assertEquals(esperado, convertido);
	}
	
	@Test
	public void emVariasLinhas() {
	String nota = "	[note]\n"+
				  "		A analogia da folha de papel é ::killer:: :). Dá para usar fácil na aula com \n"+ 
				  "		desenhos. E é a melhor forma de explicar templates que achei (baseado no livro \n"+
				  "		de JSF2 :)). Adriano\n"+
				  "	[/note]\n";

	String convertido = conversor.converte(nota);
	
	String esperado = "	<!-- @note \n"+
					  "		A analogia da folha de papel é ::killer:: :). Dá para usar fácil na aula com \n"+ 
					  "		desenhos. E é a melhor forma de explicar templates que achei (baseado no livro \n"+
					  "		de JSF2 :)). Adriano\n"+
					  "	 -->\n";
	
	Assert.assertEquals(esperado, convertido);
	}

}
