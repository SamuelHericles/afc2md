package br.com.caelum.tubaina2.conversor.logica.sintaxe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ConversorDeQuestionTest {

	private ConversorDeSintaxe conversor;

	@Before
	public void setUp() {
		conversor = new ConversorDeQuestion();
	}

	@Test
	public void soComUm() {
		String questao = "[question]\n"+
						 "		Entre no diretório %%Caelum/26/%% e copie os jars da pasta %%jars%% para a pasta %%WEB-INF/lib%% do seu projeto.\n"+
						 "[/question]\n";
		
		String convertido = conversor.converte(questao);
		
		String esperado = "1. Entre no diretório %%Caelum/26/%% e copie os jars da pasta %%jars%% para a pasta %%WEB-INF/lib%% do seu projeto.\n";
		Assert.assertEquals(esperado, convertido);
	}

	@Test
	public void maiusculo() {
		String questao = "[QUESTION]\n"+
						 "Inicie o Glassfish e acesse a URL: %%http://localhost:8080/%% \n"+
						 "[/QUESTION]\n";
		
		String convertido = conversor.converte(questao);
		
		String esperado = "1. Inicie o Glassfish e acesse a URL: %%http://localhost:8080/%%\n";
		Assert.assertEquals(esperado, convertido);
	}

	@Test
	public void variasSeguidas() {
		String questoes = "[question]\n"+
						 "		Em %%WebContent%%, através do menu **File -> New -> Other -> HTML** crie um arquivo chamado **index.xhtml**.\n"+
						 "[/question]\n" +
						 "[question]\n"+
						 "	Implemente nosso primeiro código JSF com um campo de texto e um botão.\n"+
						 "[/question]\n";
		
		String convertido = conversor.converte(questoes);
		
		String esperado = "1. Em %%WebContent%%, através do menu **File -> New -> Other -> HTML** crie um arquivo chamado **index.xhtml**.\n" +
						  "1. Implemente nosso primeiro código JSF com um campo de texto e um botão.\n";
		
		Assert.assertEquals(esperado, convertido);
	}

	@Test
	public void comVariasLinhasSoMantemUmTab() {
		String questao = "[question]\n"+
						 "		Em %%WebContent%%, através do menu **File -> New -> Other -> HTML** crie um \n" + 
						 "		arquivo chamado **index.xhtml**. \n"+
						 "		Após definir o nome do arquivo clique em ::Next:: e você verá a seguinte tela:\n"+
						 "		\n" +
						 "		[img imagens/nocoes-basicas/transitional.png w=60%]\n"+
						 "		Selecione a mesma opção da imagem acima.\n"+
						 "		\n"+
						 "[/question]\n";
		
		String convertido = conversor.converte(questao);
		
		String esperado = "1. Em %%WebContent%%, através do menu **File -> New -> Other -> HTML** crie um\n" +
						 "	arquivo chamado **index.xhtml**.\n" +
						 "	Após definir o nome do arquivo clique em ::Next:: e você verá a seguinte tela:\n"+
						 "\n" +
						 "	[img imagens/nocoes-basicas/transitional.png w=60%]\n"+
						 "	Selecione a mesma opção da imagem acima.\n"+
						 "\n";
		
		Assert.assertEquals(esperado, convertido);
	}

	@Test
	public void seguidasComVariasLinhasMantemSoUmTabESoUmEnterEntreAsQuestoes() {
		String questoes = "	[question]\n"+
						 "		Em %%WebContent%%, através do menu **File -> New -> Other -> HTML** crie um \n" + 
						 "		arquivo chamado **index.xhtml**. \n"+
						 "		Após definir o nome do arquivo clique em ::Next:: e você verá a seguinte tela:\n"+
						 "		\n" +
						 "		[img imagens/nocoes-basicas/transitional.png w=60%]\n"+
						 "		Selecione a mesma opção da imagem acima.\n"+
						 "		\n"+
						 "	[/question]\n"+
						 "[question]\n"+
						 "	Inicie o Glassfish e acesse a URL: \n" + 
						 "	%%http://localhost:8080/fj26-notas-fiscais/index.xhtml%% \n"+
						 "	O resultado deve ser esse:\n"+
						 "\n" +
						 "	[img imagens/nocoes-basicas/helloworld.png w=35]\n"+
						 "\n" +
						 "\n" +
						 "[/question]\n"+
						 "[question]\n"+
						 "Verifique o código fonte gerado pela página. Repare que não é nada mais que simples HTML.\n"+
						 "[/question]\n";
		
		String convertido = conversor.converte(questoes);
		
		String esperado = "1. Em %%WebContent%%, através do menu **File -> New -> Other -> HTML** crie um\n" +
						 "	arquivo chamado **index.xhtml**.\n" +
						 "	Após definir o nome do arquivo clique em ::Next:: e você verá a seguinte tela:\n"+
						 "\n" +
						 "	[img imagens/nocoes-basicas/transitional.png w=60%]\n"+
						 "	Selecione a mesma opção da imagem acima.\n"+
						 "1. Inicie o Glassfish e acesse a URL:\n"+
						 "	%%http://localhost:8080/fj26-notas-fiscais/index.xhtml%%\n"+
						 "	O resultado deve ser esse:\n"+
						 "\n" +
						 "	[img imagens/nocoes-basicas/helloworld.png w=35]\n"+
						 "1. Verifique o código fonte gerado pela página. Repare que não é nada mais que simples HTML.\n";
		
		Assert.assertEquals(esperado, convertido);
	}

	@Test
	public void deixaTextoQueNaoTaDentroDaQuestao() {
		String questao = "## Exercício:  Primeira página\n"+
						 "	[question]\n"+
						 "			Entre no diretório %%Caelum/26/%% e copie os jars da pasta %%jars%% para a pasta %%WEB-INF/lib%% do seu projeto.\n"+
						 "	[/question]\n"+
						 "\n"+
						 "## Criando formulário de cadastro";
		
		String convertido = conversor.converte(questao);
		
		String esperado =
				"## Exercício:  Primeira página\n"+
				"1. Entre no diretório %%Caelum/26/%% e copie os jars da pasta %%jars%% para a pasta %%WEB-INF/lib%% do seu projeto.\n"+
				 "\n"+
				 "## Criando formulário de cadastro\n";
		Assert.assertEquals(esperado, convertido);
	}

	@Test
	public void naoModificaTabsDeCode() {
		String questao = "	[question]\n"+
						"	Altere seu programa para imprimir uma mensagem diferente.\n"+
						"		Por exemplo, faça:\n"+
						"		``` java\n"+
						"			class MeuProgramaModificado {\n"+
						"				public static void main(String[] args) {\n"+
						"					System.out.println(\"Uma mensagem diferente.\");\n"+
						"				}\n"+
						"			}\n"+
						"		```\n"+
						"Rode e veja a mensagem alterada!\n"+
						"[/question]";
		
		String convertido = conversor.converte(questao);
		
		String esperado =
				"1. Altere seu programa para imprimir uma mensagem diferente.\n"+
				"	Por exemplo, faça:\n"+
				"	``` java\n"+
				"			class MeuProgramaModificado {\n"+
				"				public static void main(String[] args) {\n"+
				"					System.out.println(\"Uma mensagem diferente.\");\n"+
				"				}\n"+
				"			}\n"+
				"	```\n"+
				"	Rode e veja a mensagem alterada!\n";
		Assert.assertEquals(esperado, convertido);
	}


	@Test
	public void removeDuasQuebrasDeLinhaConsecutivas() {
		String questao = "[question]\n"+
						 "Agora criaremos o nosso projeto dentro do Eclipse.\n"+
						 "\n"+
						 "\n"+
						 "* Clique em _Finish_ e o projeto está criado. Se estiver na\n"+
						 "perspectiva **Java** e for perguntado sobre a mudança para\n"+
						 "a perspectiva **Java EE**, clique em _No_.\n"+
						 "![ {w=65%}](imagens/projeto/novas/new_project_09.png)\n"+
						 "\n"+
						 "* Assim ficará a estrutura do seu projeto:\n"+
						 "![ {w=50%}](imagens/projeto/novas/new_project_10.png)\n"+
						 "\n"+
						 "\n"+
						 "> **Versões do Eclipse**\n"+
						 ">\n"+
						 "> O suporte nativo a JSF 2 foi adicionado ao Eclipse na versão 3.6. Em versões\n"+
						 "> anteriores, não havia um bom modo de ter autocomplete nos arquivos do facelets.\n"+
						 "> Uma alternativa era o uso do plugin JBoss Tools.\n"+
						 "\n"+
						 "<!-- comentario para separar quotes adjacentes -->\n"+
						 "\n"+
						 "[/question]\n";

		String esperado ="1. Agora criaremos o nosso projeto dentro do Eclipse.\n"+
						 "\n"+
						 "	* Clique em _Finish_ e o projeto está criado. Se estiver na\n"+
						 "	perspectiva **Java** e for perguntado sobre a mudança para\n"+
						 "	a perspectiva **Java EE**, clique em _No_.\n"+
						 "	![ {w=65%}](imagens/projeto/novas/new_project_09.png)\n"+
						 "\n"+
						 "	* Assim ficará a estrutura do seu projeto:\n"+
						 "	![ {w=50%}](imagens/projeto/novas/new_project_10.png)\n"+
						 "\n"+
						 "	> **Versões do Eclipse**\n"+
						 "	>\n"+
						 "	> O suporte nativo a JSF 2 foi adicionado ao Eclipse na versão 3.6. Em versões\n"+
						 "	> anteriores, não havia um bom modo de ter autocomplete nos arquivos do facelets.\n"+
						 "	> Uma alternativa era o uso do plugin JBoss Tools.\n"+
						 "\n"+
						 "	<!-- comentario para separar quotes adjacentes -->\n"+
						 "\n";

		Assert.assertEquals(esperado, conversor.converte(questao));
	}	
}
