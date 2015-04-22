package br.com.caelum.tubaina2.conversor.logica.sintaxe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ConversorDeImgTest {
	
	private ConversorDeSintaxe conversor;

	@Before
	public void setUp() {
		conversor = new ConversorDeImg();
	}
	
	@Test
	public void emVariasLinhas(){
		String sintaxe = "[img imagens/o-que-eh-jsf/rad.png w=30" +
						 "\"ajustando as propriedades de um componente no VB\"]";
		String esperado = "[ajustando as propriedades de um componente no VB {w=30}](imagens/o-que-eh-jsf/rad.png)";
		
		String convertido = conversor.converte(sintaxe);
		
		Assert.assertEquals(esperado, convertido);
	}

}
