package br.com.caelum.tubaina2.conversor.logica.sintaxe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ConversorDeInlineCodeTest {

	private ConversorDeSintaxe conversor;

	@Before
	public void setUp() {
		conversor = new ConversorDeInlineCode();
	}

	@Test
	public void variosNaMesmaLinha() {
		String sintaxe = "Use o componente %%<p:themeSwitcher/>%% no %%cabecalho%%.";
		String esperado = "Use o componente `<p:themeSwitcher/>` no `cabecalho`.";
		Assert.assertEquals(esperado, conversor.converte(sintaxe));
	}

	@Test
	public void variosEmVariasLinhas() {
		String sintaxe = "A classe %%QuantidadePorProduto%% recebe\n um %%Long quantidade%% e\n um %%Produto p%%.";
		String esperado = "A classe `QuantidadePorProduto` recebe\n um `Long quantidade` e\n um `Produto p`.";
		Assert.assertEquals(esperado, conversor.converte(sintaxe));
	}

	@Test
	public void variosForaEDentroDeNote() {
		String sintaxe = "		componentes JSF (%%xmlns:h=\"http://java.sun.com/jsf/html\"%% e \n"+
						 "		%%xmlns:f=\"http://java.sun.com/jsf/core\"%%). \n"+
						 "[note]\n"+
						 "	Da para fazer o componente ter filhos e incluir esses dentro do implementation \n"+
						 "	com %%<composite:insertChildren/>%%\n"+
						 "[/note]";
		String esperado = "		componentes JSF (`xmlns:h=\"http://java.sun.com/jsf/html\"` e \n"+
						 "		`xmlns:f=\"http://java.sun.com/jsf/core\"`). \n" +
						 "[note]\n"+
						 "	Da para fazer o componente ter filhos e incluir esses dentro do implementation \n"+
						 "	com `<composite:insertChildren/>`\n"+
						 "[/note]";
		Assert.assertEquals(esperado, conversor.converte(sintaxe));
	}


}
