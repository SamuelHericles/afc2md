package br.com.caelum.tubaina2.conversor.logica.sintaxe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ConversorDeAnswerTest {
	
	private ConversorDeSintaxe conversor;

	@Before
	public void setUp() {
		conversor = new ConversorDeAnswer();
	}

	@Test
	public void emUmaLinha() {
		String questao = "[question]\n"+
							"Compile e verifique o nome do arquivo gerado.\n"+
							"[answer]O arquivo %%.class%% gerado tem o nome da classe em si.[/answer]\n"+
						"[/question]\n";
		String convertido = conversor.converte(questao);
		String esperado = "[question]\n"+
							"Compile e verifique o nome do arquivo gerado.\n"+
							"<!--@answer O arquivo %%.class%% gerado tem o nome da classe em si. -->\n"+
						  "[/question]\n";
		Assert.assertEquals(esperado, convertido);
	}

	
	@Test
	public void emVariasLinhas() {
		String questao = "[question]\n"+
							"Compile e verifique o nome do arquivo gerado. Como executar a sua aplicação?\n"+
							"[answer]\n"
							+ "O arquivo %%.class%% gerado tem o nome da classe em si.\n"
							+ "Para executar, rode %%java NomeDaClasse%%.\n"
							+ "[/answer]\n"+
						"[/question]\n";
		String convertido = conversor.converte(questao);
		String esperado = "[question]\n"+
							"Compile e verifique o nome do arquivo gerado. Como executar a sua aplicação?\n"+
							"<!--@answer \n"
							+ "O arquivo %%.class%% gerado tem o nome da classe em si.\n"
							+ "Para executar, rode %%java NomeDaClasse%%.\n"
							+ " -->\n"+
						  "[/question]\n";
		Assert.assertEquals(esperado, convertido);
	}
	
	@Test
	public void comCodeDentro(){
		String questao = "[question]\n"+
						"		Altere seu programa para imprimir uma mensagem diferente.\n"+
						"		[answer]\n"+
						"			[code java]\n"+
						"				class MeuProgramaModificado {\n"+
						"					public static void main(String[] args) {\n"+
						"						System.out.println(\"Uma mensagem diferente.\");\n"+
						"					}\n"+
						"				}\n"+
						"			[/code]\n"+
						"		[/answer]\n"+
						"[/question]";
		String convertido = conversor.converte(questao);
		String esperado = "[question]\n"+
						 "		Altere seu programa para imprimir uma mensagem diferente.\n"+
						 "		<!--@answer \n"+
						 "			[code java]\n"+
						 "				class MeuProgramaModificado {\n"+
						 "					public static void main(String[] args) {\n"+
						 "						System.out.println(\"Uma mensagem diferente.\");\n"+
						 "					}\n"+
						 "				}\n"+
						 "			[/code]\n"+
						 "		 -->\n"+
						 "[/question]";
		Assert.assertEquals(esperado, convertido);
	}
}
