package br.com.caelum.tubaina2.conversor.logica.sintaxe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ConversorDeParagrafoTest {
	
	private ConversorDeSintaxe conversor;

	@Before
	public void setUp() {
		conversor = new ConversorDeParagrafo();
	}

	@Test
	public void removeEspacosETabsNaFrenteDeTextoNormal(){
		String sintaxe = "	  Entender um pouco da história da plataforma Java é essencial para enxergar os motivos que  	  \n" +
						 "		    a levaram ao sucesso.       \n"+
						 " \n   " +
						 "		   Quais eram os seus maiores problemas quando programava na década de 1990?        \n";
		String convertido = conversor.converte(sintaxe);
		String esperado = "Entender um pouco da história da plataforma Java é essencial para enxergar os motivos que\n" +
						  "a levaram ao sucesso.\n"+
						  "\n" +
						 "Quais eram os seus maiores problemas quando programava na década de 1990?\n";
		Assert.assertEquals(esperado, convertido);
	}
	
	@Test
	public void removeEspacosETabsNaFrenteDoTextoQuandoHaCodeEmUmaLinha() {
		String sintaxe = "	  Pode ocorrer o erro:\n" +
						 "```Exception in thread \"main\" java.lang.NoClassDefFoundError: NomeDaClasse```\n" +
						 "	  Isso ocorre quando você tenta acessar uma classe que não está no classpath.";
		String convertido = conversor.converte(sintaxe);
		String esperado = "Pode ocorrer o erro:\n"+
						  "```Exception in thread \"main\" java.lang.NoClassDefFoundError: NomeDaClasse```\n" +
						  "Isso ocorre quando você tenta acessar uma classe que não está no classpath.\n";
		Assert.assertEquals(esperado, convertido);
	}

	@Test
	public void naoRemoveEspacosDentroDeCode(){
		String sintaxe = "	  Para mostrar uma linha, podemos fazer:   	\n" +
						 "``` java\n" +
						 "	System.out.println(\"Minha primeira aplicação Java!\");\n" +
						 "```\n" +
						 "   \n   " +
						 "  	 	  Mas esse código não será aceito pelo  compilador java.  	 ";
		String convertido = conversor.converte(sintaxe);
		String esperado = "Para mostrar uma linha, podemos fazer:\n" +
						  "``` java\n" +
						  "	System.out.println(\"Minha primeira aplicação Java!\");\n" +
						  "```\n" +
						  "\n" +
						  "Mas esse código não será aceito pelo  compilador java.\n";
		Assert.assertEquals(esperado, convertido);
	}
	
}
