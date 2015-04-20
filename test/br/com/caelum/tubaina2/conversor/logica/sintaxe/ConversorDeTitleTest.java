package br.com.caelum.tubaina2.conversor.logica.sintaxe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ConversorDeTitleTest {

	private ConversorDeSintaxe conversor;

	@Before
	public void setUp() {
		conversor = new ConversorDeTitle();
	}

	@Test
	public void emUmaLinha() {
		Assert.assertEquals("### Recebendo dados e adicionando comportamentos", conversor.converte("[title Recebendo dados e adicionando comportamentos]"));
	}

	@Test
	public void maiusculo() {
		Assert.assertEquals("### Wizard para notas fiscais", conversor.converte("[TITLE Wizard para notas fiscais]"));
	}

	@Test
	public void emMaisDeUmaLinha() {
		String convertido = conversor.converte("[title Onde devo abrir e fechar minhas conexões\n"
												+ " e transações com o banco de dados?]");
		String esperado = "### Onde devo abrir e fechar minhas conexões\n"
							+ " e transações com o banco de dados?";
		Assert.assertEquals(esperado, convertido);
	}
	
	@Test
	public void duasSeguidas(){
		String uma = "Onde devo abrir e fechar minhas conexões e transações com o banco de dados?";
		String outra = "Já utilizamos o CDI para realizar a injeção do %%EntityManager%%.";
		String paragrafo = "Uma solução com CDI\n\n";
		
		String convertido = conversor.converte("[title "+ uma+ "]\n\n"+paragrafo+"[title "+outra+"]\n");
		String esperado = "### "+ uma+ "\n\n"+paragrafo+"### "+outra+"\n";
		
		Assert.assertEquals(esperado, convertido);
	}
	
	@Test
	public void comEspacosNaFrente(){
		String convertido = conversor.converte("[title                Trabalhando em paralelo com branches]");
		String esperado = "### Trabalhando em paralelo com branches";
		
		Assert.assertEquals(esperado, convertido);
	}

	@Test
	public void comQuebrasDeLinhaTabsEEspacosNaFrente(){
		String convertido = conversor.converte("[title\n   \t\t    \n         Protocolo HTTP/HTTPS]");
		String esperado = "### Protocolo HTTP/HTTPS";
		
		Assert.assertEquals(esperado, convertido);
	}

	
}
