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
	public void comTitulo() {
		String box = "[box Git e GitHub sao a mesma coisa?]\n"+
					  "	Não.\n"+
					  "[/box]\n";
		
		String esperado = "> **Git e GitHub sao a mesma coisa?**\n"+
						  "> \n"+
						  "> Não.\n"+
						  "\n<!-- comentario para separar quotes adjacentes -->\n\n";
		
		Assert.assertEquals(esperado, conversor.converte(box));
	}

	@Test
	public void maiusculo() {
		String box = "[BOX Git e GitHub sao a mesma coisa?]\n"+
					  "	Não.\n"+
					  "[/BOX]\n";
		
		String esperado = "> **Git e GitHub sao a mesma coisa?**\n"+
						  "> \n"+
						  "> Não.\n"+
						  "\n<!-- comentario para separar quotes adjacentes -->\n\n";
		
		Assert.assertEquals(esperado, conversor.converte(box));
	}
	
	@Test
	public void comEspacosNaFrente() {
		String box = "[box      Git e GitHub sao a mesma coisa?]\n"+
					  "	Não.\n"+
					  "[/box]\n";

		String esperado = "> **Git e GitHub sao a mesma coisa?**\n"+
						  "> \n"+
						  "> Não.\n"+
						  "\n<!-- comentario para separar quotes adjacentes -->\n\n";
		
		Assert.assertEquals(esperado, conversor.converte(box));
	}

	@Test
	public void comTabsEEspacosNaFrente() {
		String box = "[box   \t\t     Git e GitHub sao a mesma coisa?]\n"+
					  "	Não.\n"+
					  "[/box]\n";

		String esperado = "> **Git e GitHub sao a mesma coisa?**\n"+
						  "> \n"+
						  "> Não.\n"+
						  "\n<!-- comentario para separar quotes adjacentes -->\n\n";
		
		Assert.assertEquals(esperado, conversor.converte(box));
	}

	@Test
	public void doisSeguidos() {
		String box = "[box Git e GitHub sao a mesma coisa?]\n"+
					  "	Não.\n"+
					  "[/box]\n"+
					  "[box Para saber mais: bla]\n"+
					  "	Blablablabla.\n"+
					  "[/box]\n";
		
		String esperado = "> **Git e GitHub sao a mesma coisa?**\n"+
						  "> \n"+
						  "> Não.\n"+
						  "\n"+
						  "<!-- comentario para separar quotes adjacentes -->\n"+
						  "\n"+
						  "> **Para saber mais: bla**\n"+
						  "> \n"+
						  "> Blablablabla.\n"+
						  "\n"+
						  "<!-- comentario para separar quotes adjacentes -->\n"+
						  "\n";
		
		Assert.assertEquals(esperado, conversor.converte(box));
	}
	
	@Test
	public void semTitulo() {
		String box = "[box]\n"+
					  "	Git e GitHub não são a mesma coisa!\n"+
					  "[/box]\n";
	
		String esperado = "> Git e GitHub não são a mesma coisa!\n"+
						  "\n<!-- comentario para separar quotes adjacentes -->\n\n";
		
		Assert.assertEquals(esperado, conversor.converte(box));
	}
	
	@Test
	public void comVariasLinhas(){
		String box = "[box GitHub for Windows]\n"+
					 "A maioria dos usuários do Windows não tem o hábito de utilizar \n"+
					 "o prompt de comandos, e perfere instalar alguma aplicação visual \n"+
					 "para trabalhar com o Git. \n"+
					 "\n"+
					 "Uma destas aplicações é o **GitHub for Windows**, e mostraremos \n"+
					 "como utilizá-la no capítulo [ref-label capitulo-github-windows].\n"+
					 "[/box]\n";
		
		String esperado = "> **GitHub for Windows**\n"+
						  "> \n"+
						  "> A maioria dos usuários do Windows não tem o hábito de utilizar\n"+
						  "> o prompt de comandos, e perfere instalar alguma aplicação visual\n"+
						  "> para trabalhar com o Git.\n"+
						  "> \n"+
						  "> Uma destas aplicações é o **GitHub for Windows**, e mostraremos\n"+
						  "> como utilizá-la no capítulo [ref-label capitulo-github-windows].\n"+
						  "\n"+
						  "<!-- comentario para separar quotes adjacentes -->\n"+
						  "\n";
		
		Assert.assertEquals(esperado, conversor.converte(box));
	}

	@Test
	public void comVariasLinhasSemTitulo(){
		String box = "[box]\n"+
					 "A maneira mais comum de usar Git é pela linha de comando, acessível\n"+
					 "através de um terminal. \n"+
					 "\n"+
					 "É o jeito que a maior parte dos bons profissionais do mercado \n"+
					 "utiliza o Git e será nossa escolha nesse livro.\n"+
					 "[/box]\n";
		
		String esperado = "> A maneira mais comum de usar Git é pela linha de comando, acessível\n"+
						  "> através de um terminal.\n"+
						  "> \n"+
						  "> É o jeito que a maior parte dos bons profissionais do mercado\n"+
						  "> utiliza o Git e será nossa escolha nesse livro.\n"+
						  "\n"+
						  "<!-- comentario para separar quotes adjacentes -->\n"+
						  "\n";
		
		Assert.assertEquals(esperado, conversor.converte(box));
	}
	
	@Test
	public void comVariasLinhasEComCodeDentro(){
		String box = "[box Pasta pessoal]\n"+
					 "A pasta pessoal (::ou home directory::, em inglês) é o local dos arquivos\n"+
					 "de usuário como documentos, fotos, músicas etc.\n"+
					 "\n"+
					 "Se você não souber onde é a pasta pessoal, digite o seguinte comando em\n"+
					 "um terminal:\n"+
					 "\n"+
					 "```\n"+
					 "	$ echo ~\n"+
					 "```\n"+
					 "[/box]";

		String esperado = "> **Pasta pessoal**\n"+
						  "> \n"+
						  "> A pasta pessoal (::ou home directory::, em inglês) é o local dos arquivos\n"+
						  "> de usuário como documentos, fotos, músicas etc.\n"+
						  "> \n"+
						  "> Se você não souber onde é a pasta pessoal, digite o seguinte comando em\n"+
						  "> um terminal:\n"+
						  "> \n"+
						  "> ```\n"+
						  "> 	$ echo ~\n"+
						  "> ```\n"+
						  "\n"+
						  "<!-- comentario para separar quotes adjacentes -->\n"+
						  "\n";
					
		Assert.assertEquals(esperado, conversor.converte(box));
	}

}
