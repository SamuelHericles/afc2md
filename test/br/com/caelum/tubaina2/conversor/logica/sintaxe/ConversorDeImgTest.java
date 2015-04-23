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
	public void emUmaLinha(){
		String sintaxe = "[img imagens/projeto/novas/new_server_glassfish4_01.png]";
		
		String convertido = conversor.converte(sintaxe);
		
		String esperado = "![](imagens/projeto/novas/new_server_glassfish4_01.png)";
		Assert.assertEquals(esperado, convertido);
	}

	@Test
	public void maiusculo(){
		String sintaxe = "[IMG imagens/cap2/project_page.png]";
		
		String convertido = conversor.converte(sintaxe);
		
		String esperado = "![](imagens/cap2/project_page.png)";
		Assert.assertEquals(esperado, convertido);
	}

	@Test
	public void emUmaLinhaComWidth(){
		String sintaxe = "[img imagens/o-que-eh-jsf/swingset-peixe.png w=85]";
		
		String convertido = conversor.converte(sintaxe);
		
		String esperado = "![ {w=85}](imagens/o-que-eh-jsf/swingset-peixe.png)";
		Assert.assertEquals(esperado, convertido);
	}

	@Test
	public void emUmaLinhaComWidthEmPorcento(){
		String sintaxe = "[img imagens/projeto/uml.png w=60%]";
		
		String convertido = conversor.converte(sintaxe);
		
		String esperado = "![ {w=60%}](imagens/projeto/uml.png)";
		Assert.assertEquals(esperado, convertido);
	}
	

	@Test
	public void emUmaLinhaComLabel(){
		String sintaxe = "[img imagens/cap11/tela-merge.png \"Tela de gerenciamento de branches\"]";
		
		String convertido = conversor.converte(sintaxe);
		
		String esperado = "![Tela de gerenciamento de branches](imagens/cap11/tela-merge.png)";
		Assert.assertEquals(esperado, convertido);
	}

	@Test
	public void emUmaLinhaComLabelEWidth(){
		String sintaxe = "[img imagens/cap2/github_signup.png w=60 \"Criando conta no GitHub\"]";
		
		String convertido = conversor.converte(sintaxe);
		
		String esperado = "![Criando conta no GitHub {w=60}](imagens/cap2/github_signup.png)";
		Assert.assertEquals(esperado, convertido);
	}

	@Test
	public void emUmaLinhaComLabelEWidthEmPorcento(){
		String sintaxe = "[img imagens/cap2/finish_signup.png w=80% \"Selecionando plano no GitHub\"]";
		
		String convertido = conversor.converte(sintaxe);
		
		String esperado = "![Selecionando plano no GitHub {w=80%}](imagens/cap2/finish_signup.png)";
		Assert.assertEquals(esperado, convertido);
	}

	@Test
	public void emVariasLinhasComLabel(){
		String sintaxe = "[img imagens/cap4/repositorio_bare.png \"Estrutura de diretórios do\n"+
						 "repositório Git\"]";
		
		String convertido = conversor.converte(sintaxe);
		
		String esperado = "![Estrutura de diretórios do\n"
						+ "repositório Git](imagens/cap4/repositorio_bare.png)";
		Assert.assertEquals(esperado, convertido);
	}

	@Test
	public void emVariasLinhasComLabelEWidth(){
		String sintaxe = "[img imagens/o-que-eh-jsf/rad.png w=30\n" +
						 "\"ajustando as propriedades de um componente no VB\"]";
		
		String convertido = conversor.converte(sintaxe);
		
		String esperado = "![ajustando as propriedades de um componente no VB {w=30}](imagens/o-que-eh-jsf/rad.png)";
		Assert.assertEquals(esperado, convertido);
	}

	@Test
	public void emVariasLinhasComLabelEWidthEmPorcento(){
		String sintaxe = "[img imagens/cap3/git_commit.png w=90% \"Gravando arquivos e mudanças com\n" +
						 "Git\"]";
		
		String convertido = conversor.converte(sintaxe);
		
		String esperado = "![Gravando arquivos e mudanças com\n"
						+ "Git {w=90%}](imagens/cap3/git_commit.png)";
		Assert.assertEquals(esperado, convertido);
	}

	@Test
	public void variasSeguidas(){
		String sintaxe = "[img imagens/cap2/github_signup.png w=60 \"Criando conta no GitHub\"]\n"+
						 "\n"+
						 "Então, selecione o plano apropriado e finalize o cadastro, clicando em\n"+
						 "::Finish Signup::. \n"+
						 "\n"+
						 "[img imagens/cap2/finish_signup.png w=80 \"Selecionando plano no GitHub\"]\n";

		String convertido = conversor.converte(sintaxe);
		
		String esperado = "![Criando conta no GitHub {w=60}](imagens/cap2/github_signup.png)\n"+
						 "\n"+
						 "Então, selecione o plano apropriado e finalize o cadastro, clicando em\n"+
						 "::Finish Signup::. \n"+
						 "\n"+
						 "![Selecionando plano no GitHub {w=80}](imagens/cap2/finish_signup.png)\n";
		Assert.assertEquals(esperado, convertido);
	}
	
	

}
