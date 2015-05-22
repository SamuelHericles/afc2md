package br.com.caelum.tubaina2.conversor.logica.sintaxe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ConversorDeItalicoTest {

	private ConversorDeSintaxe conversor;

	@Before
	public void setUp() {
		conversor = new ConversorDeItalico();
	}

	@Test
	public void variosNaMesmaLinha() {
		String sintaxe = "Existem frameworks ::Action Based:: (Baseado em Ações) e ::Component Based:: (Baseado em Componentes).";
		String esperado = "Existem frameworks _Action Based_ (Baseado em Ações) e _Component Based_ (Baseado em Componentes).";
		Assert.assertEquals(esperado, conversor.converte(sintaxe));
	}
	
	@Test
	public void seguidoPorDoisPontos(){
		String sintaxe = "Para declarar o validador crie um novo input logo ::acima do botão de submit:::";
		String esperado = "Para declarar o validador crie um novo input logo _acima do botão de submit_:";
		Assert.assertEquals(esperado, conversor.converte(sintaxe));
	}

	@Test
	public void emVariasLinhas(){
		String sintaxe = "	Os templates são divididos em duas partes: o ::arquivo de template:: e o ::cliente \n"+
						 "	do template::.\n";
		String esperado = "	Os templates são divididos em duas partes: o _arquivo de template_ e o _cliente \n"+
						  "	do template_.\n";
		Assert.assertEquals(esperado, conversor.converte(sintaxe));
	}

	


}
