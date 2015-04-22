package br.com.caelum.tubaina2.conversor.logica.sintaxe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ConversorDeBoxTest {

	private ConversorDeSintaxe conversor;

	@Before
	public void setUp() {
		conversor = new ConversorDeBox();
	}

	@Test
	public void emUmaLinha() {
		String box = "[box Git e GitHub sao a mesma coisa?]";
		String esperado = "> **Git e GitHub sao a mesma coisa?**";
		
		Assert.assertEquals(esperado, conversor.converte(box));
	}

	@Test
	public void emMaisDeUmaLinha() {
		String box = "[box Git e GitHub sao \na mesma coisa?]";
		String esperado = "> **Git e GitHub sao \na mesma coisa?**";
		
		Assert.assertEquals(esperado, conversor.converte(box));
	}

	@Test
	public void maiusculo() {
		String box = "[BOX Git e GitHub sao \na mesma coisa?]";
		String esperado = "> **Git e GitHub sao \na mesma coisa?**";
		
		Assert.assertEquals(esperado, conversor.converte(box));
	}
	
	@Test
	public void doisSeguidos() {
		String textoBox1 = "Git e GitHub sao a mesma coisa?";
		String box1 = "[box " + textoBox1 + "]";

		String textoBox2 = "Para saber mais: bla";
		String box2 = "[box " + textoBox2 + "]";
		
		String esperado1 = "> **" +textoBox1 +"**";
		String esperado2 = "> **" +textoBox2 +"**";
		
		Assert.assertEquals(esperado1 +"\n" +esperado2, conversor.converte(box1 +"\n" +box2));
	}
	
	@Test
	public void comEspacosNaFrente() {
		String box = "[box      Git e GitHub sao a mesma coisa?]";
		String esperado = "> **Git e GitHub sao a mesma coisa?**";
		
		Assert.assertEquals(esperado, conversor.converte(box));
	}

	@Test
	public void comQuebrasDeLinhaTabsEEspacosNaFrente() {
		String box = "[box\n   \t\t    \n         Git e GitHub sao a mesma coisa?]";
		String esperado = "> **Git e GitHub sao a mesma coisa?**";
		
		Assert.assertEquals(esperado, conversor.converte(box));
	}
	
	@Test
	public void semTitulo() {
		String box = "[box]";
		String esperado = "> ****";
		
		Assert.assertEquals(esperado, conversor.converte(box));
	}

}
